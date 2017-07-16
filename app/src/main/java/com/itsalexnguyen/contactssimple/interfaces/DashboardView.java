package com.itsalexnguyen.contactssimple.interfaces;

import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

/**
 * This is the View layer in the MVP pattern.
 */
public interface DashboardView {

    /**
     * Notifies the View layer to refresh itself.
     */
    void refreshPage();

    /**
     * Notifies the view to display contact details page.
     *
     * @param contact contact to show.
     */
    void displayContactDetails(User contact);

    /**
     * Notifies the view to display a network error.
     */
    void showNetworkError();
}
