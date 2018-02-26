package com.whapps.erp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roman on 19.07.17.
 */

public class CreatorPost implements Parcelable {

    private String id;
    private String name;
    @SerializedName("avatar_url")
    private String avatarUrl;

    protected CreatorPost(Parcel in) {
        id = in.readString();
        name = in.readString();
        avatarUrl = in.readString();
    }

    public static final Creator<CreatorPost> CREATOR = new Creator<CreatorPost>() {
        @Override
        public CreatorPost createFromParcel(Parcel in) {
            return new CreatorPost(in);
        }

        @Override
        public CreatorPost[] newArray(int size) {
            return new CreatorPost[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(avatarUrl);
    }
}
