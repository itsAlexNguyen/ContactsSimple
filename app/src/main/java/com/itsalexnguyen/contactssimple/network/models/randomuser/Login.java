package com.itsalexnguyen.contactssimple.network.models.randomuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Login implements Parcelable {
    @SerializedName("username")
    public final String username;

    @SerializedName("password")
    public final String password;

    @SerializedName("salt")
    public final String salt;

    @SerializedName("md5")
    public final String md5;

    @SerializedName("sha1")
    public final String sha1;

    @SerializedName("sha256")
    public final String sha256;

    protected Login(Parcel in) {
        username = in.readString();
        password = in.readString();
        salt = in.readString();
        md5 = in.readString();
        sha1 = in.readString();
        sha256 = in.readString();
    }

    public static final Creator<Login> CREATOR = new Creator<Login>() {
        @Override
        public Login createFromParcel(Parcel in) {
            return new Login(in);
        }

        @Override
        public Login[] newArray(int size) {
            return new Login[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(salt);
        parcel.writeString(md5);
        parcel.writeString(sha1);
        parcel.writeString(sha256);
    }
}
