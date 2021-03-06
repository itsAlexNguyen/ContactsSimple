package com.itsalexnguyen.contactssimple.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itsalexnguyen.contactssimple.R;
import com.itsalexnguyen.contactssimple.adapters.DashboardListAdapter;
import com.itsalexnguyen.contactssimple.interfaces.DashboardView;
import com.itsalexnguyen.contactssimple.network.RestService;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;
import com.itsalexnguyen.contactssimple.presenters.DashboardPresenter;
import com.itsalexnguyen.contactssimple.utils.Constants;

/**
 * This Activity represents the View Layer. Made to be really 'dumb'.
 */
public class DashboardActivity extends FragmentActivity implements DashboardView,
        RestService.Delegate {
    private final DashboardPresenter presenter = new DashboardPresenter(this, new RestService(this));
    private ProgressDialog progressDialog;
    private DashboardListAdapter adapter;
    private RecyclerView listView;

    // --- Android Life-Cycle [START] ---
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);

        adapter = new DashboardListAdapter(presenter);

        listView = findViewById(R.id.dashboardListView);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setItemAnimator(new DefaultItemAnimator());

        listView.setAdapter(adapter);

        presenter.retrieveContacts();
    }

    // --- Android Life-Cycle [END] ---

    // ---  RestService.Delegate Implementation [START] ---

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public void displayProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.show();
            }
        });
    }

    @Override
    public void hideProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.hide();
            }
        });
    }

    // ---  RestService.Delegate Implementation [END] ---

    // ---  DashboardView Implementation [START] ---

    @Override
    public void refreshPage() {
        listView.post(new Runnable() {
            @Override
            public void run() {
                adapter.buildRows();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void displayContactDetails(User contact) {
        Intent intent = new Intent(this, ContactDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.CONTACT, contact);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showNetworkError() {
        // TODO - Can display an activiy showing an error.
    }

    // ---  DashboardView Implementation [END] ---
}
