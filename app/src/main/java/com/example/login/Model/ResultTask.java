package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class ResultTask {
    public Task[] getResult() {
        return result;
    }

    public void setResult(Task[] result) {
        this.result = result;
    }

    @SerializedName("result")
    private Task[] result;


}