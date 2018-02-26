package com.whapps.erp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by roman on 19.07.17.
 */

public class Timeline implements Parcelable {

    private String id;
    private SharePostDetail share;
    private PostResponse post;

    public Timeline(String id, SharePostDetail share, PostResponse post) {
        this.id = id;
        this.share = share;
        this.post = post;
    }

    protected Timeline(Parcel in) {
        id = in.readString();
        post = in.readParcelable(PostResponse.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(post, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Timeline> CREATOR = new Creator<Timeline>() {
        @Override
        public Timeline createFromParcel(Parcel in) {
            return new Timeline(in);
        }

        @Override
        public Timeline[] newArray(int size) {
            return new Timeline[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SharePostDetail getShare() {
        return share;
    }

    public void setShare(SharePostDetail share) {
        this.share = share;
    }

    public PostResponse getPost() {
        return post;
    }

    public void setPost(PostResponse post) {
        this.post = post;
    }
}
