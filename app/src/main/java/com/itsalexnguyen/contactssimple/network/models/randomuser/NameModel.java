package com.itsalexnguyen.contactssimple.network.models.randomuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NameModel implements Parcelable {
    @SerializedName("title")
    public final String title;

    @SerializedName("first")
    public final String firstName;

    @SerializedName("last")
    public final String lastName;

    protected NameModel(Parcel in) {
        title = in.readString();
        firstName = in.readString();
        lastName = in.readString();
    }

    public static final Creator<NameModel> CREATOR = new Creator<NameModel>() {
        @Override
        public NameModel createFromParcel(Parcel in) {
            return new NameModel(in);
        }

        @Override
        public NameModel[] newArray(int size) {
            return new NameModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
    }
}
