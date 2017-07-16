package com.itsalexnguyen.contactssimple.binders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.itsalexnguyen.contactssimple.viewholders.ContactActionViewHolder;

public class ContactActionBinder extends AbstractDataBinder<ContactActionViewHolder> {
    @Override
    public ContactActionViewHolder createViewHolder(ViewGroup parent) {
        View view = getView(ContactActionViewHolder.getLayoutId(), parent);
        return new ContactActionViewHolder(view);
    }

    @Override
    public void bindViewHolder(ContactActionViewHolder holder) {
        Context ctx = holder.callButton.getContext();

        Animation slideLeft = AnimationUtils.loadAnimation(ctx, android.R.anim.slide_in_left);

        holder.callButton.startAnimation(slideLeft);
        holder.messageButton.startAnimation(slideLeft);
        holder.videoButton.startAnimation(slideLeft);
        holder.emailButton.startAnimation(slideLeft);
    }
}
