package com.example.tairo.gitbubapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RepositoryResponse implements Parcelable {

    private List<Repository> repositories;

    protected RepositoryResponse(Parcel in) {
        repositories = in.createTypedArrayList(Repository.CREATOR);
    }

    public static final Creator<RepositoryResponse> CREATOR = new Creator<RepositoryResponse>() {
        @Override
        public RepositoryResponse createFromParcel(Parcel in) {
            return new RepositoryResponse(in);
        }

        @Override
        public RepositoryResponse[] newArray(int size) {
            return new RepositoryResponse[size];
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

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
