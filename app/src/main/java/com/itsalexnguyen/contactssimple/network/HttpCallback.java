package com.itsalexnguyen.contactssimple.network;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by alexnguyen on 2017-07-15.
 */

public interface HttpCallback<T> {
    void onSuccess(Call call, T response);

    void onFailure(Call call, IOException exception);
}
