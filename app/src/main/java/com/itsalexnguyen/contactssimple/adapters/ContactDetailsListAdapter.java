package com.itsalexnguyen.contactssimple.adapters;

import com.itsalexnguyen.contactssimple.binders.AbstractDataBinder;
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

    @Override
    public List<AbstractDataBinder> getItems() {
        return listItems;
    }
}
