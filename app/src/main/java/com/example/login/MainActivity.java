package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.Model.Data;
import com.example.login.Model.Result;
import com.example.login.Rest.ApiClient;
import com.example.login.Rest.ApiInterface;
import com.example.login.Rest.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    Button buttonLogin;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        apiInterface = ApiUtils.getApiInterface();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                //validate form
                if (validatelogin(email,password)){
                    //do login
                    doLogin(email,password);

                }


            }
        });
    }
    private boolean validatelogin(String email, String password) {
        if (email == null || email.trim().length() == 0) {
            Toast.makeText(this, "Email is Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String email, String password){
        Call<Data> call = apiInterface.login(email,password);
        call.enqueue(new Callback<Data>() {

            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()){

                    if (response.body().getStatus().equals("SUCCESS")){
                        //login start
                        Intent i = new Intent(MainActivity.this, Content.class);
//                        i.putExtra("email",email);
                        startActivity(i);


                    }else {
                        Toast.makeText(MainActivity.this, "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Error!! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}