package com.example.tairo.gitbubapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UserResponse implements Parcelable {

    private List<User> repositories;

    protected UserResponse(Parcel in) {
        repositories = in.createTypedArrayList(User.CREATOR);
    }

    public static final Creator<UserResponse> CREATOR = new Creator<UserResponse>() {
        @Override
        public UserResponse createFromParcel(Parcel in) {
            return new UserResponse(in);
        }

        @Override
        public UserResponse[] newArray(int size) {
            return new UserResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(repositories);
    }

    public List<User> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<User> repositories) {
        this.repositories = repositories;
    }
}
