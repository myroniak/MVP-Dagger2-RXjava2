package com.whapps.erp.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roman on 10.02.18.
 */

public class UserResponse {
    @SerializedName("company_id")
    private String companyId;
    private String email;
    private String name;
    private String role;
    @SerializedName("avatar_url")
    private String avatarUrl;

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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
