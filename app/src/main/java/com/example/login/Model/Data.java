package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("status")
    public String  Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaAwal() {
        return namaAwal;
    }

    public void setNamaAwal(String namaAwal) {
        this.namaAwal = namaAwal;
    }

    public String getNamaAkhir() {
        return namaAkhir;
    }

    public void setNamaAkhir(String namaAkhir) {
        this.namaAkhir = namaAkhir;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @SerializedName("id")
    public String id;

    @SerializedName("firstName")
    public String namaAwal;

    @SerializedName("lastName")
    public String namaAkhir;

    @SerializedName("displayName")
    public String display;

    @SerializedName("email")
    public String mail;

    @SerializedName("token")
    public String token;

}
