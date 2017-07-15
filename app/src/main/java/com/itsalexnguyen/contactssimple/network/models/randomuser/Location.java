package com.itsalexnguyen.contactssimple.network.models.randomuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable {
    @SerializedName("street")
    public final String street;

    @SerializedName("city")
    public final String city;

    @SerializedName("state")
    public final String state;

    @SerializedName("postcode")
    public final int postcode;

    protected Location(Parcel in) {
        street = in.readString();
        city = in.readString();
        state = in.readString();
        postcode = in.readInt();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(street);
        parcel.writeString(city);
        parcel.writeString(state);
    }
}
