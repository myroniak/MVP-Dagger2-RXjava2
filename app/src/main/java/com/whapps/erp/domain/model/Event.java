package com.whapps.erp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by roman on 21.12.17.
 */

public class Event implements Parcelable{


    private String date;
    private String name;
    @SerializedName("post_id")
    private String postId;
    private ArrayList<Recipient> recipients;
    private boolean isLiked;
    private boolean isCompany;
    private String id;
    private String imageUrl;

    public Event(String id, String postId, String imageUrl, String date, String name, ArrayList<Recipient> recipients, boolean isLiked, boolean isCompany) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.date = date;
        this.name = name;
        this.recipients = recipients;
        this.isLiked = isLiked;
        this.isCompany = isCompany;
        this.postId = postId;
    }

    protected Event(Parcel in) {
        date = in.readString();
        name = in.readString();
        postId = in.readString();
        recipients = in.createTypedArrayList(Recipient.CREATOR);
        isLiked = in.readByte() != 0;
        isCompany = in.readByte() != 0;
        id = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(name);
        dest.writeString(postId);
        dest.writeTypedList(recipients);
        dest.writeByte((byte) (isLiked ? 1 : 0));
        dest.writeByte((byte) (isCompany ? 1 : 0));
        dest.writeString(id);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ArrayList<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<Recipient> recipients) {
        this.recipients = recipients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (isLiked() != event.isLiked()) return false;
        if (isCompany() != event.isCompany()) return false;
        if (getDate() != null ? !getDate().equals(event.getDate()) : event.getDate() != null)
            return false;
        if (getName() != null ? !getName().equals(event.getName()) : event.getName() != null)
            return false;
        if (getPostId() != null ? !getPostId().equals(event.getPostId()) : event.getPostId() != null)
            return false;
        if (getRecipients() != null ? !getRecipients().equals(event.getRecipients()) : event.getRecipients() != null)
            return false;
        if (getId() != null ? !getId().equals(event.getId()) : event.getId() != null) return false;
        return getImageUrl() != null ? getImageUrl().equals(event.getImageUrl()) : event.getImageUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
        result = 31 * result + (getRecipients() != null ? getRecipients().hashCode() : 0);
        result = 31 * result + (isLiked() ? 1 : 0);
        result = 31 * result + (isCompany() ? 1 : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
        return result;
    }
}
