package com.chyour;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//import chyourgui.signIn;
import chyourgui.tasks;

/*
 * SignupActivity author : @apillai @yosephh
 *
 */
public class SignupActivity extends Activity {
    private static final String TAG = SignupActivity.class.getSimpleName();
    private Button btnRegister;

    private EditText inputFullName;
    private EditText inputEmail;
    private EditText inputPassword;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        inputFullName = (EditText) findViewById(R.id.etName);
        inputEmail = (EditText) findViewById(R.id.etEmail);
        inputPassword = (EditText) findViewById(R.id.etpassword);
        btnRegister = (Button) findViewById(R.id.button_submit);


        // Session manager
        session = new SessionManager(getApplicationContext());

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
//            Intent intent = new Intent(SignupActivity.this,
//                    signIn.class);
//            startActivity(intent);
//            finish();
        }

        // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputFullName.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    registerUser(name, email, password);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });


    }

    private void registerUser(final String name, final String email,
                              final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("128.205.44.23")
                .appendPath("chyour")
                .appendPath("registration.php")
                .appendQueryParameter("fullname", name)
                .appendQueryParameter("email", email)
                .appendQueryParameter("password", password);

        final String uri = builder.build().toString();

        StringRequest strReq = new StringRequest(Method.GET,
                uri, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error) {

                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(SignupActivity.this,
                                tasks.class);
                        startActivity(intent);
                        finish();

                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                        if (errorMsg == "User already exists with email address ") {
                            Log.e(TAG, errorMsg);
                            Intent intent = new Intent(SignupActivity.this,
                                    MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                } catch (JSONException e) {
                    Log.e (TAG, "JSONException detected " );
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}