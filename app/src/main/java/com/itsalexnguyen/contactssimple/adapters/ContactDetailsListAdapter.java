package com.itsalexnguyen.contactssimple.adapters;

import com.itsalexnguyen.contactssimple.binders.AbstractDataBinder;
import com.itsalexnguyen.contactssimple.binders.ContactActionBinder;
import com.itsalexnguyen.contactssimple.binders.ProfileImageBinder;
import com.itsalexnguyen.contactssimple.binders.TwoColumnBinder;
import com.itsalexnguyen.contactssimple.presenters.ContactDetailsPresenter;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailsListAdapter extends AbstractDataBindAdapter {
    private final ArrayList<AbstractDataBinder> listItems;
    private final ContactDetailsPresenter presenter;

    public ContactDetailsListAdapter(ContactDetailsPresenter presenter) {
        this.presenter = presenter;
        this.listItems = new ArrayList<>();
    }

    public void buildRows() {
        listItems.clear();

        listItems.add(new ProfileImageBinder(presenter.getContact()));
        listItems.add(new ContactActionBinder());
        listItems.add(new TwoColumnBinder("Email", presenter.getContactEmail()));
        listItems.add(new TwoColumnBinder("Gender", presenter.getContactGender()));
        listItems.add(new TwoColumnBinder("Location", presenter.getContactLocation()));
        listItems.add(new TwoColumnBinder("Date of Birth", presenter.getDateOfBirth()));
    }

    @Override
    public List<AbstractDataBinder> getItems() {
        return listItems;
    }
}
