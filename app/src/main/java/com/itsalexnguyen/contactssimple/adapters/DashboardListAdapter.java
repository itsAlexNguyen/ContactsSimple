package com.itsalexnguyen.contactssimple.adapters;

import com.itsalexnguyen.contactssimple.binders.AbstractDataBinder;
import com.itsalexnguyen.contactssimple.binders.ContactRowBinder;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;
import com.itsalexnguyen.contactssimple.presenters.DashboardPresenter;

import java.util.ArrayList;
import java.util.List;

public class DashboardListAdapter extends AbstractDataBindAdapter {
    private final DashboardPresenter presenter;
    private final ArrayList<AbstractDataBinder> listItems;

    public DashboardListAdapter(DashboardPresenter presenter) {
        this.presenter = presenter;
        this.listItems = new ArrayList<>();
    }

    public void buildRows() {
        listItems.clear();
        for (User contact : presenter.getContacts()) {
            listItems.add(new ContactRowBinder(contact,
                    presenter.createContactSelectedListener()));
        }
    }

    @Override
    public List<AbstractDataBinder> getItems() {
        return listItems;
    }
}
