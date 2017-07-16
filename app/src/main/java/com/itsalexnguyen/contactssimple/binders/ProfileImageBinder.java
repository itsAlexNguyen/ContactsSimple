package com.itsalexnguyen.contactssimple.binders;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;

import com.itsalexnguyen.contactssimple.R;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;
import com.itsalexnguyen.contactssimple.utils.CircleTransform;
import com.itsalexnguyen.contactssimple.viewholders.ProfileImageViewHolder;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Locale;

public class ProfileImageBinder extends AbstractDataBinder<ProfileImageViewHolder> {
    private final User contact;

    public ProfileImageBinder(User contact) {
        this.contact = contact;
    }

    @Override
    public ProfileImageViewHolder createViewHolder(ViewGroup parent) {
        View view = getView(ProfileImageViewHolder.getLayoutId(), parent);
        return new ProfileImageViewHolder(view);
    }

    @Override
    public void bindViewHolder(ProfileImageViewHolder holder) {
        Context ctx = holder.profileImageView.getContext();
        // Set profile image.
        Picasso.with(ctx)
                .load(contact.pictures.largeUrl)
                .resize(150, 150)
                .transform(new CircleTransform())
                .into(holder.profileImageView);

        // Set name
        holder.nameLabel.setText(String.format(Locale.getDefault(), "%s %s",
                WordUtils.capitalize(contact.name.firstName),
                WordUtils.capitalize(contact.name.lastName)));

        // Animations
        setFadeAnimation(holder.nameLabel);
        setFadeAnimation(holder.profileImageView);
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }
}
