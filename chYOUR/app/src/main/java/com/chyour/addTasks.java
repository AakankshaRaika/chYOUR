package com.chyour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chyourgui.tasks;

import static chyourgui.TaskManagement.editClicked;
import static chyourgui.tasks.currentId;
import static chyourgui.tasks.taskMap;


public class addTasks extends AppCompatActivity implements View.OnClickListener {

    static int code;
    Button bAdd;
    Button bGoBack4;
    EditText titleVar;
    EditText descriptionVar;
    EditText locationVar;

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;

    Spinner spinner7;
    Spinner spinner8;
    Spinner spinner9;
    Spinner spinner10;
    Spinner spinner11;

    private static final String TAG = addTasks.class.getSimpleName();
    String tag_string_req = "uploadTaskList";
    String rangeVar = "3";

    // default place holders
    private int longtiude = 1234,
            lattitude = 1234,
            userId = 0001,
            date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        bAdd = (Button) findViewById(R.id.bAdd);
        bGoBack4 = (Button) findViewById(R.id.bGoBack4);

        titleVar = (EditText) findViewById(R.id.titleVar);
        descriptionVar = (EditText) findViewById(R.id.descriptionVar);
        locationVar = (EditText) findViewById(R.id.locationVar);
        bAdd.setOnClickListener(this);
        bGoBack4.setOnClickListener(this);
        spinner1 = (Spinner) findViewById(R.id.month);
        spinner2 = (Spinner) findViewById(R.id.day);
        spinner3 = (Spinner) findViewById(R.id.hour);
        spinner4 = (Spinner) findViewById(R.id.minute);
        spinner5 = (Spinner) findViewById(R.id.ampm);
        spinner6 = (Spinner) findViewById(R.id.category);

        spinner7 = (Spinner) findViewById(R.id.month2);
        spinner8 = (Spinner) findViewById(R.id.day2);
        spinner9 = (Spinner) findViewById(R.id.hour2);
        spinner10 = (Spinner) findViewById(R.id.minute2);
        spinner11 = (Spinner) findViewById(R.id.ampm2);


        if (editClicked == 1) {

            titleVar.setText(taskMap.get(currentId).get(0));
            descriptionVar.setText(taskMap.get(currentId).get(1));
            locationVar.setText(taskMap.get(currentId).get(3));

            ArrayAdapter myAdap1 = (ArrayAdapter) spinner1.getAdapter();
            int spinnerPosition1 = myAdap1.getPosition(taskMap.get(currentId).get(4));
            spinner1.setSelection(spinnerPosition1);

            ArrayAdapter myAdap2 = (ArrayAdapter) spinner2.getAdapter();
            int spinnerPosition2 = myAdap2.getPosition(taskMap.get(currentId).get(5));
            spinner2.setSelection(spinnerPosition2);

            ArrayAdapter myAdap3 = (ArrayAdapter) spinner3.getAdapter();
            int spinnerPosition3 = myAdap3.getPosition(taskMap.get(currentId).get(6));
            spinner3.setSelection(spinnerPosition3);


            ArrayAdapter myAdap4 = (ArrayAdapter) spinner4.getAdapter();
            int spinnerPosition4 = myAdap4.getPosition(taskMap.get(currentId).get(7));
            spinner4.setSelection(spinnerPosition4);

            ArrayAdapter myAdap5 = (ArrayAdapter) spinner5.getAdapter();
            int spinnerPosition5 = myAdap5.getPosition(taskMap.get(currentId).get(8));
            spinner5.setSelection(spinnerPosition5);


            ArrayAdapter myAdap6 = (ArrayAdapter) spinner6.getAdapter();
            int spinnerPosition6 = myAdap6.getPosition(taskMap.get(currentId).get(2));
            spinner6.setSelection(spinnerPosition6);



            ArrayAdapter myAdap7 = (ArrayAdapter) spinner7.getAdapter();
            int spinnerPosition7 = myAdap7.getPosition(taskMap.get(currentId).get(9));
            spinner7.setSelection(spinnerPosition7);

            ArrayAdapter myAdap8 = (ArrayAdapter) spinner8.getAdapter();
            int spinnerPosition8 = myAdap8.getPosition(taskMap.get(currentId).get(10));
            spinner8.setSelection(spinnerPosition8);

            ArrayAdapter myAdap9 = (ArrayAdapter) spinner9.getAdapter();
            int spinnerPosition9 = myAdap9.getPosition(taskMap.get(currentId).get(11));
            spinner9.setSelection(spinnerPosition9);


            ArrayAdapter myAdap10 = (ArrayAdapter) spinner10.getAdapter();
            int spinnerPosition10 = myAdap10.getPosition(taskMap.get(currentId).get(12));
            spinner10.setSelection(spinnerPosition10);

            ArrayAdapter myAdap11 = (ArrayAdapter) spinner11.getAdapter();
            int spinnerPosition11 = myAdap11.getPosition(taskMap.get(currentId).get(13));
            spinner11.setSelection(spinnerPosition11);

        }

    }

    @Override
    public void onClick(View v) {


        String month = spinner1.getSelectedItem().toString();
        String day = spinner2.getSelectedItem().toString();
        String hour = spinner3.getSelectedItem().toString();
        String minute = spinner4.getSelectedItem().toString();
        String ampm = spinner5.getSelectedItem().toString();
        String category = spinner6.getSelectedItem().toString();

        String month2 = spinner7.getSelectedItem().toString();
        String day2 = spinner8.getSelectedItem().toString();
        String hour2 = spinner9.getSelectedItem().toString();
        String minute2 = spinner10.getSelectedItem().toString();
        String ampm2 = spinner11.getSelectedItem().toString();



        switch (v.getId()) {


            case R.id.bGoBack4:
                startActivity(new Intent(this, tasks.class));
                break;


            case R.id.bAdd:

                if (titleVar.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }
                if (descriptionVar.getText().toString().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }


                if (category.equals("Other") && locationVar.getText().length() < 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }

                if (category.equals("Other") && (month2.length() < 1 || day2.length() < 1 ||
                        hour2.length() < 1 || minute2.length() < 1 || ampm2.length() < 1)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(addTasks.this);
                    builder.setTitle("Alert");
                    builder.setMessage("All Fields not Filled in");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                }






                List list = new ArrayList<>();
                list.add(titleVar.getText().toString());
                list.add(descriptionVar.getText().toString());
                list.add(category);
                list.add(locationVar.getText().toString());
                list.add(month);
                list.add(day);
                list.add(hour);
                list.add(minute);
                list.add(ampm);
                list.add(month2);
                list.add(day2);
                list.add(hour2);
                list.add(minute2);
                list.add(ampm2);



                if (editClicked == 1) {
                    taskMap.put(code, list);

                    editClicked = 0;
                    startActivity(new Intent(this, tasks.class));
                    break;
                } else {
                    date = 110101;

                    registerTask(userId, titleVar.getText().toString() , descriptionVar.getText().toString(),
                            date, locationVar.getText().toString(),rangeVar, lattitude, longtiude);
                    taskMap.put(code += 1, list);
                    startActivity(new Intent(this, tasks.class));
                    break;
                }
        }
    }

    private void registerTask(final int userId, final String title ,final String descriptionVar, final int date,
                              final String locationVar,final String range, final int lattitude, final int longtiude) {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("128.205.44.23")
                .appendPath("chyour")
                .appendPath("addTask.php")
                .appendQueryParameter("userID", String.valueOf(userId))
                .appendQueryParameter("taskTitle", title)
                .appendQueryParameter("description", descriptionVar)
                .appendQueryParameter("date", String.valueOf(date))
                .appendQueryParameter("address", locationVar)
                .appendQueryParameter("taskRange", String.valueOf(range))
                .appendQueryParameter("latitude", String.valueOf(lattitude))
                .appendQueryParameter("longitude", String.valueOf(longtiude));

        final String uri = builder.build().toString();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                uri, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Saved in jarvis!!!", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "upload error " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}