package com.whapps.erp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by roman on 02.08.17.
 */

public class User implements Parcelable {

    @SerializedName("company_id")
    private String companyId;
    private String id;
    private String type;
    private String email;
    private String name;
    private String role;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("udf1")
    private String udfOne;
    @SerializedName("udf2")
    private String udfTwo;
    private boolean isFollowing;

    public User(String type, String companyId, String id, String email, String name, String role, String avatarUrl, String udfOne, String udfTwo, boolean isFollowing) {
        this.type = type;
        this.companyId = companyId;
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.avatarUrl = avatarUrl;
        this.udfOne = udfOne;
        this.udfTwo = udfTwo;
        this.isFollowing = isFollowing;
    }

   /* public User(String companyId, String id, String email, String name, String role, String avatarUrl, String udfOne, String udfTwo) {
        this.companyId = companyId;
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.avatarUrl = avatarUrl;
        this.udfOne = udfOne;
        this.udfTwo = udfTwo;
    }*/

    protected User(Parcel in) {
        companyId = in.readString();
        id = in.readString();
        type = in.readString();
        email = in.readString();
        name = in.readString();
        role = in.readString();
        avatarUrl = in.readString();
        udfOne = in.readString();
        udfTwo = in.readString();
        isFollowing = in.readByte() != 0;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUdfOne() {
        return udfOne;
    }

    public void setUdfOne(String udfOne) {
        this.udfOne = udfOne;
    }

    public String getUdfTwo() {
        return udfTwo;
    }

    public void setUdfTwo(String udfTwo) {
        this.udfTwo = udfTwo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setFollowing(boolean following) {
        isFollowing = following;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (isFollowing() != user.isFollowing()) return false;
        if (getCompanyId() != null ? !getCompanyId().equals(user.getCompanyId()) : user.getCompanyId() != null)
            return false;
        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getType() != null ? !getType().equals(user.getType()) : user.getType() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null)
            return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null)
            return false;
        if (getRole() != null ? !getRole().equals(user.getRole()) : user.getRole() != null)
            return false;
        if (getAvatarUrl() != null ? !getAvatarUrl().equals(user.getAvatarUrl()) : user.getAvatarUrl() != null)
            return false;
        if (getUdfOne() != null ? !getUdfOne().equals(user.getUdfOne()) : user.getUdfOne() != null)
            return false;
        return getUdfTwo() != null ? getUdfTwo().equals(user.getUdfTwo()) : user.getUdfTwo() == null;
    }

    @Override
    public int hashCode() {
        int result = getCompanyId() != null ? getCompanyId().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (getAvatarUrl() != null ? getAvatarUrl().hashCode() : 0);
        result = 31 * result + (getUdfOne() != null ? getUdfOne().hashCode() : 0);
        result = 31 * result + (getUdfTwo() != null ? getUdfTwo().hashCode() : 0);
        result = 31 * result + (isFollowing() ? 1 : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(companyId);
        parcel.writeString(id);
        parcel.writeString(type);
        parcel.writeString(email);
        parcel.writeString(name);
        parcel.writeString(role);
        parcel.writeString(avatarUrl);
        parcel.writeString(udfOne);
        parcel.writeString(udfTwo);
        parcel.writeByte((byte) (isFollowing ? 1 : 0));
    }

    public static Comparator<User> COMPARE_BY_NAME = new Comparator<User>() {
        public int compare(User one, User other) {
            return one.getName().compareTo(other.getName());
        }
    };
}
