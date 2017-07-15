package com.itsalexnguyen.contactssimple.network;

import android.support.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.itsalexnguyen.contactssimple.network.models.RandomUserResponse;

import java.lang.reflect.Type;

import okhttp3.Request;

public class RestService {
    private final NetworkServiceClient client = new NetworkServiceClient();

    public RestService() {
        // Intentionally left empty
    }

    public void getRandomUser(@NonNull HttpCallback<RandomUserResponse> callback) {
        Request.Builder requestBuilder = client.createRequestBuilder(RestEndpoints.RANDOM_USER);
        Type type = new TypeToken<RandomUserResponse>() {
        }.getType();
        client.enqueueRequest(requestBuilder.build(), new ServiceHttpCallBack<>(type, callback));
    }
}
