package com.itsalexnguyen.contactssimple.viewholders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsalexnguyen.contactssimple.R;

public class ProfileImageViewHolder extends RecyclerView.ViewHolder {
    public final ImageView profileImageView;
    public final TextView nameLabel;

    public ProfileImageViewHolder(View itemView) {
        super(itemView);
        profileImageView = itemView.findViewById(R.id.large_profile_image);
        nameLabel = itemView.findViewById(R.id.name_label);
    }

    @LayoutRes
    public static int getLayoutId() {
        return R.layout.profile_image_row;
    }
}
