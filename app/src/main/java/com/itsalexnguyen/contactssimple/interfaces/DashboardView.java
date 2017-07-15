package com.itsalexnguyen.contactssimple.interfaces;

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
     * Notifies the view to display a loading dialog.
     */
    void displayProgressDialog();
}
