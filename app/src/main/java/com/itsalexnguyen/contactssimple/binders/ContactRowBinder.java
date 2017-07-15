package com.itsalexnguyen.contactssimple.binders;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsalexnguyen.contactssimple.interfaces.ItemSelectedListener;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;
import com.itsalexnguyen.contactssimple.viewholders.ContactRowViewHolder;

import java.util.ArrayList;
import java.util.Locale;

public class ContactRowBinder extends AbstractDataBinder<ContactRowViewHolder> {
    private final User contact;
    private final ItemSelectedListener<User> listener;

    public ContactRowBinder(
            @NonNull User contact,
            @NonNull ItemSelectedListener<User> listener) {
        this.contact = contact;
        this.listener = listener;
    }

    @Override
    public ContactRowViewHolder createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                ContactRowViewHolder.getLayoutId(), parent, false);
        return new ContactRowViewHolder(view);
    }

    @Override
    public void bindViewHolder(ContactRowViewHolder holder) {
        // Set the name label
        holder.nameLabel.setText(String.format(Locale.getDefault(), "%s %s",
                contact.name.firstName, contact.name.lastName));

        // Set the OnClickListener
        holder.backgroundView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelected(contact);
            }
        });
    }
}
