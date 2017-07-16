package com.itsalexnguyen.contactssimple.viewholders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.itsalexnguyen.contactssimple.R;

public class TwoColumnViewHolder extends RecyclerView.ViewHolder {

    public TextView label;
    public TextView value;

    public TwoColumnViewHolder(View itemView) {
        super(itemView);
        label = itemView.findViewById(R.id.label_field);
        value = itemView.findViewById(R.id.value_field);
    }

    @LayoutRes
    public static int getLayoutId() {
        return R.layout.two_column_view;
    }
}
