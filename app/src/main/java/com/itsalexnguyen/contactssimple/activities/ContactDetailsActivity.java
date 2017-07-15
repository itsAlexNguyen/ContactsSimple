package com.itsalexnguyen.contactssimple.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itsalexnguyen.contactssimple.R;
import com.itsalexnguyen.contactssimple.adapters.ContactDetailsListAdapter;
import com.itsalexnguyen.contactssimple.adapters.DashboardListAdapter;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;
import com.itsalexnguyen.contactssimple.presenters.ContactDetailsPresenter;
import com.itsalexnguyen.contactssimple.utils.Constants;

public class ContactDetailsActivity extends FragmentActivity {
    private final ContactDetailsPresenter presenter = new ContactDetailsPresenter();
    private ContactDetailsListAdapter adapter;
    private RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        // Setup Adapter
        adapter = new ContactDetailsListAdapter(presenter);

        // Setup Listview
        listView = findViewById(R.id.contactDetailsListView);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(adapter);

        // Get Intent Data
        Object obj = getIntent().getExtras().get(Constants.CONTACT);
        User contact = obj instanceof User ? (User) obj : null;

        if (contact != null) {
            presenter.start();
        }
    }
}
