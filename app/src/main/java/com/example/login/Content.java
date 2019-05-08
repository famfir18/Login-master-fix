package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.Model.Data;
import com.example.login.Model.Result;
import com.example.login.Model.ResultTask;
import com.example.login.Rest.ApiInterface;
import com.example.login.Rest.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Content extends AppCompatActivity {

    TextView txtEmail;
    TextView coba;

    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        coba = (TextView) findViewById(R.id.textView2);

        Bundle extras = getIntent().getExtras();
        String email;

        if(extras != null){
            email = extras.getString("email");
            txtEmail.setText(email);
        }
        apiInterface = ApiUtils.getApiInterface();
        doGetTasl(0);

    }

    private void doGetTasl( int page){
        Call<Result> call = apiInterface.getTask(0);
        call.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()){
                    for(int i =0; i < response.body().getResult().getResult().length; i++) {
                        coba.setText(coba.getText() + " " + response.body().getResult().getResult()[i].id);
                    }

                }else {
                    Toast.makeText(Content.this,"Error!! Please try again!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(Content.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
