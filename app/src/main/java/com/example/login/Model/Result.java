package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    public ResultTask getResult() {
        return result;
    }

    public void setResult(ResultTask result) {
        this.result = result;
    }

    @SerializedName("result")
    private ResultTask result;
}