package com.itsalexnguyen.contactssimple.adapters;

import com.itsalexnguyen.contactssimple.binders.AbstractDataBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexnguyen on 2017-07-15.
 */

public class ContactDetailsListAdapter extends AbstractDataBindAdapter {
    private final ArrayList<AbstractDataBinder> listItems;

    public ContactDetailsListAdapter() {
        listItems = new ArrayList<>();
    }

    @Override
    public List<AbstractDataBinder> getItems() {
        return null;
    }
}
