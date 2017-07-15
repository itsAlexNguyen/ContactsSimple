package com.itsalexnguyen.contactssimple.viewholders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.itsalexnguyen.contactssimple.R;

public class ContactRowViewHolder extends RecyclerView.ViewHolder {
    public final View backgroundView;
    public final TextView nameLabel;

    public ContactRowViewHolder(View itemView) {
        super(itemView);
        backgroundView = itemView.findViewById(R.id.background_view);
        nameLabel = itemView.findViewById(R.id.name_label);
    }

    @LayoutRes
    public static int getLayoutId() {
        return R.layout.contact_row;
    }
}