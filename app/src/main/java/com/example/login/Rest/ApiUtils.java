package com.example.login.Rest;

public class ApiUtils {

    public static final  String BASE_URL = "http://206.189.47.10:10000/";
//    public static final  String BASE_URL = "http://muslimsalat.com/";

    public static ApiInterface getApiInterface(){
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }

}
