package com.itsalexnguyen.contactssimple.binders;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.itsalexnguyen.contactssimple.viewholders.TwoColumnViewHolder;

public class TwoColumnBinder extends AbstractDataBinder<TwoColumnViewHolder> {
    private final String label;
    private final String value;

    public TwoColumnBinder(@NonNull String label,
                           @NonNull String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public TwoColumnViewHolder createViewHolder(ViewGroup parent) {
        View view = getView(TwoColumnViewHolder.getLayoutId(), parent);
        return new TwoColumnViewHolder(view);
    }

    @Override
    public void bindViewHolder(TwoColumnViewHolder holder) {
        holder.label.setText(label);
        holder.value.setText(value);
    }
}
