package chyourgui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chyour.R;
import com.chyour.SignupActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class signIn extends AppCompatActivity implements View.OnClickListener {

    private String url;
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
               // registration registration = new registration();
               // Map<String, List<String>> map;
               // map = registration.map;



                if (emailVar.length() < 1 || passwordVar.length() < 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                //if (map.containsKey(emailVar.getText().toString()) == false) {
                 //   AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                 //   builder.setTitle("Alert");
                 //   builder.setMessage("Wrong Username and or Password");
                 //   AlertDialog alertDialog = builder.create();
                 //   alertDialog.show();
                 //   break;
                //}
                //if (map.get(emailVar.getText().toString()).get(1).equals(passwordVar.getText().toString()) == false) {
                //    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                //    builder.setTitle("Alert");
                //    builder.setMessage("Wrong Username and or Password");
                //    AlertDialog alertDialog = builder.create();
                //    alertDialog.show();
               //     break;
               // }



                try {
openFileInput(emailVar.getText().toString() + passwordVar.getText().toString());
                    startActivity(new Intent(this, tasks.class));

                    //String name = inputFullName.getText().toString().trim();
                    
                    String email = emailVar.getText().toString().trim();
                    String password = passwordVar.getText().toString().trim();

                    url = "http://128.205.44.23/chyour/login.php?email="
                            + email + "&password=" + password;
                    

                                        break;

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    AlertDialog.Builder builder = new AlertDialog.Builder(signIn.this);
                        builder.setTitle("Alert");
                        builder.setMessage("Wrong Username and or Password");
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }


            case R.id.bSignUp:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
    }
}