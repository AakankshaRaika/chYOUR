package com.chyour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import com.android.volley.Request.Method;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private Button btn_submit;
    private EditText fName, lName, email, username, pwd, veri_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_submit = (Button) findViewById(R.id.button_submit);
        fName = (EditText) findViewById(R.id.et_firstName);
        lName = (EditText) findViewById(R.id.et_lastName);
        email = (EditText) findViewById(R.id.et_email);
        username = (EditText) findViewById(R.id.et_userName);
        pwd = (EditText) findViewById(R.id.et_password);
        veri_pwd = (EditText) findViewById(R.id.et_verify_pwd);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fName.getText().toString();
                String Email = email.getText().toString();
                String password = pwd.getText().toString();

                Toast.makeText(getApplicationContext(),
                        "signing up...", Toast.LENGTH_LONG)
                        .show();

                if (!name.isEmpty() && !Email.isEmpty() && !password.isEmpty()) {

                    registerUser(name, Email, password);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        }
        );




    }

    private void registerUser(final String name, final String email,
                              final String password) {

        // Tag used to cancel the request
        String tag_string_req = "req_register";

        StringRequest strReq = new StringRequest(Method.POST,
                AppConfig.URL_SIGNUP, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("IN REGISTER USER--->", "Register Response: " + response.toString());

                Toast.makeText(getApplicationContext(),
                        "IN onResponse", Toast.LENGTH_LONG)
                        .show();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (error) {
                        Toast.makeText(getApplicationContext(),
                                "error creating JSONObject", Toast.LENGTH_LONG)
                                .show();
                        Log.d("IN REGISTER USER--->", "error on JSONObject ");
                    }
                    if (!error) {
                        // User successfully stored in MySQL

                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");


                        Toast.makeText(getApplicationContext(), "successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                SignupActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
              //  Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };

        try {
            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }





}
