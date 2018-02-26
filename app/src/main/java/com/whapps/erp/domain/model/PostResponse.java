package com.whapps.erp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by roman on 19.07.17.
 */

public class PostResponse implements Parcelable {

    private String id;
    private CreatorPost creator;
    private String name;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("recipient_count")
    private int recipientCount;
    @SerializedName("selected_recipients")
    private ArrayList<Recipient> mSelectedRecipients;
    @SerializedName("location_id")
    private String locationId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("media_url")
    private String imageUrl;
    @SerializedName("badge_ids")
    private ArrayList<String> badgeIds;
    private String content;
    @SerializedName("like_count")
    private int likeCount;
    @SerializedName("is_liked")
    private boolean isLiked;
    @SerializedName("comment_count")
    private int commentCount;
    @SerializedName("is_commented")
    private boolean isCommented;
    @SerializedName("selected_comments")
    private ArrayList<Comment> selectedComments;
    @SerializedName("is_awarded")
    private boolean isAwarded;

    public PostResponse(String id, CreatorPost creator, String name, String avatarUrl, int recipientCount, ArrayList<Recipient> selectedRecipients, String locationId, String createdAt, String imageUrl, ArrayList<String> badgeIds, String content, int likeCount, boolean isLiked, int commentCount, boolean isCommented, ArrayList<Comment> selectedComments, boolean isAwarded) {
        this.id = id;
        this.creator = creator;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.recipientCount = recipientCount;
        this.mSelectedRecipients = selectedRecipients;
        this.locationId = locationId;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.badgeIds = badgeIds;
        this.content = content;
        this.likeCount = likeCount;
        this.isLiked = isLiked;
        this.commentCount = commentCount;
        this.isCommented = isCommented;
        this.selectedComments = selectedComments;
        this.isAwarded = isAwarded;
    }

    protected PostResponse(Parcel in) {
        id = in.readString();
        creator = in.readParcelable(CreatorPost.class.getClassLoader());
        name = in.readString();
        avatarUrl = in.readString();
        recipientCount = in.readInt();
        mSelectedRecipients = in.createTypedArrayList(Recipient.CREATOR);
        locationId = in.readString();
        createdAt = in.readString();
        imageUrl = in.readString();
        badgeIds = in.createStringArrayList();
        content = in.readString();
        likeCount = in.readInt();
        isLiked = in.readByte() != 0;
        commentCount = in.readInt();
        isCommented = in.readByte() != 0;
        selectedComments = in.createTypedArrayList(Comment.CREATOR);
        isAwarded = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(creator, flags);
        dest.writeString(name);
        dest.writeString(avatarUrl);
        dest.writeInt(recipientCount);
        dest.writeTypedList(mSelectedRecipients);
        dest.writeString(locationId);
        dest.writeString(createdAt);
        dest.writeString(imageUrl);
        dest.writeStringList(badgeIds);
        dest.writeString(content);
        dest.writeInt(likeCount);
        dest.writeByte((byte) (isLiked ? 1 : 0));
        dest.writeInt(commentCount);
        dest.writeByte((byte) (isCommented ? 1 : 0));
        dest.writeTypedList(selectedComments);
        dest.writeByte((byte) (isAwarded ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PostResponse> CREATOR = new Creator<PostResponse>() {
        @Override
        public PostResponse createFromParcel(Parcel in) {
            return new PostResponse(in);
        }

        @Override
        public PostResponse[] newArray(int size) {
            return new PostResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CreatorPost getCreator() {
        return creator;
    }

    public void setCreator(CreatorPost creator) {
        this.creator = creator;
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

    public int getRecipientCount() {
        return recipientCount;
    }

    public void setRecipientCount(int recipientCount) {
        this.recipientCount = recipientCount;
    }

    public ArrayList<Recipient> getSelectedRecipients() {
        return mSelectedRecipients;
    }

    public void setSelectedRecipients(ArrayList<Recipient> selectedRecipients) {
        this.mSelectedRecipients = selectedRecipients;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<String> getBadgeIds() {
        return badgeIds;
    }

    public void setBadgeIds(ArrayList<String> badgeIds) {
        this.badgeIds = badgeIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public boolean isCommented() {
        return isCommented;
    }

    public void setCommented(boolean commented) {
        isCommented = commented;
    }

    public ArrayList<Comment> getComments() {
        return selectedComments;
    }

    public void setSelectedComments(ArrayList<Comment> selectedComments) {
        this.selectedComments = selectedComments;
    }

    public boolean isAwarded() {
        return isAwarded;
    }

    public void setAwarded(boolean awarded) {
        isAwarded = awarded;
    }
}
