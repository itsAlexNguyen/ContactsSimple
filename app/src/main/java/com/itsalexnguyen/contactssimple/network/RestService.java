package com.itsalexnguyen.contactssimple.network;

import android.support.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.itsalexnguyen.contactssimple.network.models.randomuser.RandomUserResponse;

import java.lang.reflect.Type;

import okhttp3.Request;

public class RestService {
    private final NetworkServiceClient client = new NetworkServiceClient();
    private final Delegate delegate;

    public RestService(Delegate delegate) {
        this.delegate = delegate;
    }

    public void getRandomUser(@NonNull HttpCallback<RandomUserResponse> callback) {
        Request.Builder requestBuilder = client.createRequestBuilder(RestEndpoints.RANDOM_USER);
        Type type = new TypeToken<RandomUserResponse>() {
        }.getType();
        client.enqueueRequest(requestBuilder.build(), new ServiceHttpCallBack<>(type, callback, delegate));
        delegate.displayProgressDialog();
    }

    public void getListRandomUsers(@NonNull HttpCallback<RandomUserResponse> callback) {
        if (delegate.isNetworkConnected()) {
            Request.Builder requestBuilder = client
                    .createRequestBuilder(RestEndpoints.randomUsersWithCount(50));
            Type type = new TypeToken<RandomUserResponse>() {
            }.getType();
            client.enqueueRequest(requestBuilder.build(), new ServiceHttpCallBack<>(type, callback, delegate));
            delegate.displayProgressDialog();
        }
    }

    public interface Delegate {
        boolean isNetworkConnected();

        void displayProgressDialog();

        void hideProgressDialog();
    }
}
