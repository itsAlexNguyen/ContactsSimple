package com.itsalexnguyen.contactssimple.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itsalexnguyen.contactssimple.R;
import com.itsalexnguyen.contactssimple.adapters.ContactDetailsListAdapter;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;
import com.itsalexnguyen.contactssimple.presenters.ContactDetailsPresenter;
import com.itsalexnguyen.contactssimple.utils.Constants;

/**
 * This Activity displays detail information about a selected contact.
 */
public class ContactDetailsActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        // Get Intent Data
        Object obj = getIntent().getExtras().get(Constants.CONTACT);
        User contact = obj instanceof User ? (User) obj : null;

        if (contact != null) {
            // Setup Presenter
            ContactDetailsPresenter presenter = new ContactDetailsPresenter(contact);

            // Setup Adapter
            ContactDetailsListAdapter adapter = new ContactDetailsListAdapter(presenter, this);
            adapter.buildRows();

            // Setup Listview
            RecyclerView listView = findViewById(R.id.contactDetailsListView);
            listView.setLayoutManager(new LinearLayoutManager(this));
            listView.setItemAnimator(new DefaultItemAnimator());
            listView.setAdapter(adapter);
        }
    }
}
