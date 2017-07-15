package com.itsalexnguyen.contactssimple.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public final class User implements Parcelable {
    @SerializedName("gender")
    public final String gender;

    @SerializedName("name")
    public final NameModel name;

    protected User(Parcel in) {
        gender = in.readString();
        name = in.readParcelable(NameModel.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gender);
        parcel.writeParcelable(name, i);
    }
}
