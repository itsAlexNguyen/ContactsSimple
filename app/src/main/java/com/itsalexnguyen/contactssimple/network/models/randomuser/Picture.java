package com.itsalexnguyen.contactssimple.network.models.randomuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Picture implements Parcelable {
    @SerializedName("large")
    public final String largeUrl;

    @SerializedName("medium")
    public final String mediumUrl;

    @SerializedName("thumbnail")
    public final String thumbnailUrl;

    protected Picture(Parcel in) {
        largeUrl = in.readString();
        mediumUrl = in.readString();
        thumbnailUrl = in.readString();
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(largeUrl);
        parcel.writeString(mediumUrl);
        parcel.writeString(thumbnailUrl);
    }
}
