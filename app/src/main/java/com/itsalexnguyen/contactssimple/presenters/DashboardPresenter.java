package com.itsalexnguyen.contactssimple.presenters;

import android.util.Log;

import com.itsalexnguyen.contactssimple.interfaces.DashboardView;
import com.itsalexnguyen.contactssimple.network.HttpCallback;
import com.itsalexnguyen.contactssimple.network.RestService;
import com.itsalexnguyen.contactssimple.network.models.RandomUserResponse;

import java.io.IOException;

import okhttp3.Call;

/**
 * This is the Presenter as part of the MVP architecture.
 */
public class DashboardPresenter {
    private final String TAG = DashboardPresenter.class.getSimpleName();
    private final DashboardView view;

    /**
     * Constructor.
     */
    public DashboardPresenter(DashboardView view) {
        this.view = view;
        createNetworkCall();
    }

    public void createNetworkCall() {
        RestService restService = new RestService();
        restService.getRandomUser(new HttpCallback<RandomUserResponse>() {
            @Override
            public void onSuccess(Call call, RandomUserResponse response) {
                Log.d(TAG, response.users.get(0).name.firstName);
            }

            @Override
            public void onFailure(Call call, IOException exception) {

            }
        });
    }
}
