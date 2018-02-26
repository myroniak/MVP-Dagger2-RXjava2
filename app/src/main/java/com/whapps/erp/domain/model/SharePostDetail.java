package com.whapps.erp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by roman on 28.11.17.
 */

public class SharePostDetail implements Parcelable {

    private User user;
    @SerializedName("highlight_id")
    private String highlightId;
    private String content;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("recipient_ids")
    private ArrayList<String> recipientIds;

    public SharePostDetail(User user, String highlightId, String content, String createdAt, ArrayList<String> recipientIds) {
        this.user = user;
        this.highlightId = highlightId;
        this.content = content;
        this.createdAt = createdAt;
        this.recipientIds = recipientIds;
    }


    protected SharePostDetail(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        highlightId = in.readString();
        content = in.readString();
        createdAt = in.readString();
        recipientIds = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(user, flags);
        dest.writeString(highlightId);
        dest.writeString(content);
        dest.writeString(createdAt);
        dest.writeStringList(recipientIds);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SharePostDetail> CREATOR = new Creator<SharePostDetail>() {
        @Override
        public SharePostDetail createFromParcel(Parcel in) {
            return new SharePostDetail(in);
        }

        @Override
        public SharePostDetail[] newArray(int size) {
            return new SharePostDetail[size];
        }
    };

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHighlightId() {
        return highlightId;
    }

    public void setHighlightId(String highlightId) {
        this.highlightId = highlightId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<String> getRecipientIds() {
        return recipientIds;
    }

    public void setRecipientIds(ArrayList<String> recipientIds) {
        this.recipientIds = recipientIds;
    }
}
