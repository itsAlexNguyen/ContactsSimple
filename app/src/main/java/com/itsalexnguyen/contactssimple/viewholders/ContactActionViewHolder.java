package com.itsalexnguyen.contactssimple.viewholders;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.itsalexnguyen.contactssimple.R;

public class ContactActionViewHolder extends RecyclerView.ViewHolder {
    public final Button messageButton;
    public final Button callButton;
    public final Button videoButton;
    public final Button emailButton;

    public ContactActionViewHolder(View itemView) {
        super(itemView);
        messageButton = itemView.findViewById(R.id.message_btn);
        callButton = itemView.findViewById(R.id.call_btn);
        videoButton = itemView.findViewById(R.id.video_btn);
        emailButton = itemView.findViewById(R.id.email_btn);
    }

    @LayoutRes
    public static int getLayoutId() {
        return R.layout.contact_actions_row;
    }
}
