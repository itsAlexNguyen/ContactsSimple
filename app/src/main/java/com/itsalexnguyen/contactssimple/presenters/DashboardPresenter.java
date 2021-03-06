package com.itsalexnguyen.contactssimple.presenters;

import android.view.View;

import com.itsalexnguyen.contactssimple.interfaces.DashboardView;
import com.itsalexnguyen.contactssimple.interfaces.ItemSelectedListener;
import com.itsalexnguyen.contactssimple.network.HttpCallback;
import com.itsalexnguyen.contactssimple.network.RestService;
import com.itsalexnguyen.contactssimple.network.models.randomuser.RandomUserResponse;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.Call;

/**
 * This is the Presenter as part of the MVP architecture.
 */
public class DashboardPresenter {

    private final String TAG = DashboardPresenter.class.getSimpleName();
    private final ArrayList<User> contacts = new ArrayList<>();
    private final RestService restService;
    private final DashboardView view;

    /**
     * Retrieves a list of contacts.
     *
     * @return list of User model objects.
     */
    public ArrayList<User> getContacts() {
        return contacts;
    }

    /**
     * Constructor.
     */
    public DashboardPresenter(DashboardView view, RestService restService) {
        this.view = view;
        this.restService = restService;
    }

    public void retrieveContacts() {
        restService.getListRandomUsers(new HttpCallback<RandomUserResponse>() {
            @Override
            public void onSuccess(Call call, RandomUserResponse response) {
                onHandleResponse(response.users);
            }

            @Override
            public void onFailure(Call call, IOException exception) {
                view.showNetworkError();
            }
        });
    }

    // Listeners [BEGIN]

    public ItemSelectedListener<User> createContactSelectedListener() {
        return new ItemSelectedListener<User>() {
            @Override
            public void onItemSelected(User contact) {
                view.displayContactDetails(contact);
            }
        };
    }

    /**
     * Private methods
     */
    private void onHandleResponse(ArrayList<User> users) {
        contacts.clear();
        contacts.addAll(users);
        Collections.sort(contacts);
        view.refreshPage();
    }
}
