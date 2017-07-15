package com.itsalexnguyen.contactssimple.network;

import android.net.Uri;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Wrapper class for Random User Generator.
 */
public class NetworkServiceClient {
    private OkHttpClient client;

    /**
     * Constructor.
     */
    public NetworkServiceClient() {
        client = new OkHttpClient();
    }

    public Request.Builder createRequestBuilder(String path) {
        return new Request.Builder().url(RestEndpoints.BASE_URL + path);
    }

    public void enqueueRequest(Request request, Callback callback) {
        client.newCall(request).enqueue(callback);
    }
}
