package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class Task {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    @SerializedName("id")
    public String  id;
    @SerializedName("initiatorName")
    public String  initiatorName;

}
