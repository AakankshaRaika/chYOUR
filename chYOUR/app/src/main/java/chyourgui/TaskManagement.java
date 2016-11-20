package chyourgui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chyour.MapsActivity;
import com.chyour.R;
import com.chyour.addTasks;

import static chyourgui.tasks.currentId;
import static chyourgui.tasks.taskMap;


public class TaskManagement extends AppCompatActivity implements View.OnClickListener {

    public static int editClicked;
    Button gpsVar;
    Button toggleVar;
    Button bEdit;
    Button bGoBack3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_management);

        bGoBack3 = (Button) findViewById(R.id.bGoBack3);
        gpsVar = (Button) findViewById(R.id.gpsVar);
        bEdit = (Button) findViewById(R.id.bEdit);
        toggleVar = (Button) findViewById(R.id.toggleVar);

        bGoBack3.setOnClickListener(this);
        gpsVar.setOnClickListener(this);
        bEdit.setOnClickListener(this);
        toggleVar.setOnClickListener(this);

        LinearLayout layout = (LinearLayout) findViewById(R.id.tmLayout);
        LinearLayout tmLayout2 = (LinearLayout) findViewById(R.id.tmLayout2);


        TextView tv = new TextView(this);
        tv.setTextSize(15);
        tv.setGravity(Gravity.CENTER);
        String temp = new String();

        temp = "Title: " + taskMap.get(currentId).get(0) + '\n';
        temp += "Description: " + taskMap.get(currentId).get(1) + '\n';
        temp += "Category: " + taskMap.get(currentId).get(2) + '\n';
        temp += "Location: " + taskMap.get(currentId).get(3) + '\n';
        temp += "Due Date: " + taskMap.get(currentId).get(4)
                + "/" + taskMap.get(currentId).get(5) + " "
                + taskMap.get(currentId).get(6) + ":" + taskMap.get(currentId).get(7)
                + taskMap.get(currentId).get(8);

        tv.setText(temp);
        tmLayout2.addView(tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gpsVar:
                Uri uri = Uri.parse("https://www.google.com/maps/dir/My+Location/"+setUserLocationInput()+"+near+me/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.toggleVar:
                taskMap.remove(currentId);
                startActivity(new Intent(this, tasks.class));
                break;

            case R.id.bEdit:
                editClicked = 1;
                startActivity(new Intent(this, addTasks.class));
                break;

            case R.id.bGoBack3:
                startActivity(new Intent(this, tasks.class));
                break;

        }
    }
    public string setUserLocationInput(){
        String setLocation;
        if(taskMap.get(currentId).get(3).length <= 0 && taskMap.get(currentId).get(2) != "Other" ){
            setLocation = taskMap.get(currentId).get(2);
        }
        return setLocation;
    }
}