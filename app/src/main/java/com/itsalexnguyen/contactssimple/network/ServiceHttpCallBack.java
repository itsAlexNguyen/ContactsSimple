package com.itsalexnguyen.contactssimple.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A wrapper CallBack for okHttp Callback to include a Java-Type response instead of a String.
 *
 * @param <T> Generic response object.
 */
class ServiceHttpCallBack<T> implements Callback {
    private final String TAG = ServiceHttpCallBack.class.getSimpleName();
    private final Type type;
    private final RestService.Delegate delegate;

    private final HttpCallback<T> callback;

    ServiceHttpCallBack(@NonNull Type type, @NonNull HttpCallback<T> callback,
                        @NonNull RestService.Delegate delegate) {
        this.type = type;
        this.delegate = delegate;
        this.callback = callback;
    }

    private T parsedResponseBody(@NonNull String httpResponseBody) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(httpResponseBody, type);
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        delegate.hideProgressDialog();
        callback.onFailure(call, e);
        Log.d(TAG, call.toString());
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        delegate.hideProgressDialog();
        try {
            callback.onSuccess(call, parsedResponseBody(response.body().string()));
        } catch (IOException ioe) {
            onFailure(call, ioe);
        }
    }
}
