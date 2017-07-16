package com.itsalexnguyen.contactssimple.presenters;

import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

public class ContactDetailsPresenter {
    private final User contact;

    public User getContact() {
        return contact;
    }

    public ContactDetailsPresenter(User contact) {
        this.contact = contact;
    }
}
