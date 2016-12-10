package chyourgui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.test.espresso.core.deps.guava.hash.HashCode;
import android.support.test.espresso.core.deps.guava.hash.HashFunction;
import android.support.test.espresso.core.deps.guava.hash.Hasher;
import android.support.test.espresso.core.deps.guava.hash.Hashing;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.chyour.AppController;
import com.chyour.R;
import com.chyour.SignupActivity;
import com.chyour.contactUs;
import com.chyour.faq;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//This is Yosephh changed code for the adress for the server (authored by Yosephh)

public class signIn extends AppCompatActivity implements View.OnClickListener {

    Button bSignUp;
    Button bSignIn;
    Button bFAQ;
    EditText passwordVar;
    EditText emailVar;

    HashFunction hf = Hashing.md5();
    Hasher hasher = hf.newHasher();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailVar = (EditText) findViewById(R.id.emailVar);
        passwordVar = (EditText) findViewById(R.id.passwordVar);
        bSignIn = (Button) findViewById(R.id.bSignIn);
        bFAQ = (Button) findViewById(R.id.bFAQ);
        bSignUp = (Button) findViewById(R.id.bSignUp);
        bSignIn.setOnClickListener(this);
        bSignUp.setOnClickListener(this);
        bFAQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSignIn:

                String email = emailVar.getText().toString().trim();
                String password = passwordVar.getText().toString().trim();
                HashCode passwordhashed = hasher.putString(password, StandardCharsets.UTF_8).hash();

                if (emailVar.length() < 1 || passwordVar.length() < 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

                checkLogin(email, passwordhashed.toString());

                try {
                    openFileInput(emailVar.getText().toString() + passwordVar.getText().toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bSignUp:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.bFAQ:
                startActivity(new Intent(this, faq.class));
                break;
            case R.id.bContactUs:
                startActivity(new Intent(this, contactUs.class));
                break;

        }
    }

    private void checkLogin(final String email, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("128.205.44.23")
                .appendPath("chyour")
                .appendPath("login.php")
                .appendQueryParameter("email", email)
                .appendQueryParameter("password", password);

        final String uri = builder.build().toString();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in

                        Toast.makeText(getApplicationContext(), "Welcome!",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(signIn.this,
                                tasks.class);
                        startActivity(intent);
                        finish();

                    } else {

                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Log.e("JSON", "  error");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "Login Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}