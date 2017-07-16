package com.itsalexnguyen.contactssimple.adapters;

import android.content.Context;

import com.itsalexnguyen.contactssimple.R;
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
    private final Context ctx;

    public ContactDetailsListAdapter(ContactDetailsPresenter presenter, Context context) {
        this.presenter = presenter;
        this.listItems = new ArrayList<>();
        this.ctx = context;
    }

    public void buildRows() {
        listItems.clear();

        listItems.add(new ProfileImageBinder(presenter.getContact()));
        //listItems.add(new ContactActionBinder());
        listItems.add(new TwoColumnBinder(ctx.getString(R.string.str_email), presenter.getContactEmail()));
        listItems.add(new TwoColumnBinder(ctx.getString(R.string.str_gender), presenter.getContactGender()));
        listItems.add(new TwoColumnBinder(ctx.getString(R.string.str_location), presenter.getContactLocation()));
        listItems.add(new TwoColumnBinder(ctx.getString(R.string.str_date_of_birth), presenter.getDateOfBirth()));
    }

    @Override
    public List<AbstractDataBinder> getItems() {
        return listItems;
    }
}
