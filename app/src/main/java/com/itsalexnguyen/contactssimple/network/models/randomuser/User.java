package com.itsalexnguyen.contactssimple.network.models.randomuser;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Model class for a User object from Random User call.
 */
public class User implements Parcelable, Comparable<User> {
    @SerializedName("gender")
    public final String gender;

    @SerializedName("name")
    public final NameModel name;

    @SerializedName("email")
    public final String email;

    @SerializedName("login")
    public final Login login;

    @SerializedName("dob")
    public final String dateOfBirth;

    @SerializedName("registered")
    public final String registrationDate;

    @SerializedName("phone")
    public final String phoneNumber;

    @SerializedName("cell")
    public final String cellPhoneNumber;

    @SerializedName("picture")
    public final Picture pictures;

    @SerializedName("location")
    public final Location location;

    protected User(Parcel in) {
        gender = in.readString();
        name = in.readParcelable(NameModel.class.getClassLoader());
        email = in.readString();
        login = in.readParcelable(Login.class.getClassLoader());
        dateOfBirth = in.readString();
        registrationDate = in.readString();
        phoneNumber = in.readString();
        cellPhoneNumber = in.readString();
        pictures = in.readParcelable(Picture.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
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
    public int compareTo(@NonNull User user) {
        return this.name.lastName.compareTo(user.name.lastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gender);
        parcel.writeParcelable(name, i);
        parcel.writeString(email);
        parcel.writeParcelable(login, i);
        parcel.writeString(dateOfBirth);
        parcel.writeString(registrationDate);
        parcel.writeString(phoneNumber);
        parcel.writeString(cellPhoneNumber);
        parcel.writeParcelable(pictures, i);
        parcel.writeParcelable(location, i);
    }
}
