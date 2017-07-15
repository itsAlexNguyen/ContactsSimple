package com.itsalexnguyen.contactssimple.network.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RandomUserResponse implements Parcelable {
    @SerializedName("results")
    public final ArrayList<User> users;

    protected RandomUserResponse(Parcel in) {
        users = in.createTypedArrayList(User.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(users);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RandomUserResponse> CREATOR = new Creator<RandomUserResponse>() {
        @Override
        public RandomUserResponse createFromParcel(Parcel in) {
            return new RandomUserResponse(in);
        }

        @Override
        public RandomUserResponse[] newArray(int size) {
            return new RandomUserResponse[size];
        }
    };
}
