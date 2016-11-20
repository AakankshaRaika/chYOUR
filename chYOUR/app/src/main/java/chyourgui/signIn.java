package chyourgui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import org.json.JSONException;
import org.json.JSONObject;

public class signIn extends AppCompatActivity implements View.OnClickListener {
    Button bSignUp;
    Button bSignIn;
    EditText passwordVar;
    EditText emailVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        emailVar = (EditText) findViewById(R.id.emailVar);
        passwordVar = (EditText) findViewById(R.id.passwordVar);
        bSignIn = (Button) findViewById(R.id.bSignIn);
        bSignUp = (Button) findViewById(R.id.bSignUp);
        bSignIn.setOnClickListener(this);
        bSignUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSignIn:

                bSignIn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                        String email = emailVar.getText().toString().trim();
                        String password = passwordVar.getText().toString().trim();

                        checkLogin(email, password);
                    }
                });
                break;

            case R.id.bSignUp:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
        /**
         * function to verify login details in mysql db
         * */
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

                        Toast.makeText(getApplicationContext(), "Welcome!!!",
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