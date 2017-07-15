package com.itsalexnguyen.contactssimple.interfaces;

import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

/**
 * This is the View layer in the MVP pattern.
 */
public interface DashboardView {

    /**
     * Indicates whether the device has connection to the Internet.
     *
     * @return True if there is network connection, false otherwise.
     */
    boolean isNetworkConnected();

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
     * Notifies the view to display a loading dialog.
     */
    void displayProgressDialog();
}
