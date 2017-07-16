package com.itsalexnguyen.contactssimple.binders;

import android.view.View;
import android.view.ViewGroup;

import com.itsalexnguyen.contactssimple.viewholders.ContactActionViewHolder;

public class ContactActionBinder extends AbstractDataBinder<ContactActionViewHolder> {
    @Override
    public ContactActionViewHolder createViewHolder(ViewGroup parent) {
        View view = getView(ContactActionViewHolder.getLayoutId(), parent);
        return new ContactActionViewHolder(view);
    }

    @Override
    public void bindViewHolder(ContactActionViewHolder holder) {
        // TODO
    }
}
