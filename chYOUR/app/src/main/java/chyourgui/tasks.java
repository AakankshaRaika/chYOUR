package chyourgui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chyour.R;
import com.chyour.addTasks;
import com.chyour.settings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tasks extends AppCompatActivity implements View.OnClickListener {

    public static Map<Integer, List<String>> taskMap = new HashMap<>();
    public static int currentId;
    Button bAddTask;
    Button bSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);

        if (taskMap.size() < 1) {
            TextView tv = new TextView(this);
            tv.setTextSize(50);
            tv.setGravity(Gravity.CENTER);
            tv.setText("Currently no tasks");
            layout2.addView(tv);
        }

        for (Integer key : taskMap.keySet()) {
            Button bt = new Button(this);
            bt.setTextSize(10);
            bt.setBackgroundColor(0xffff0000);
            String temp = new String();

            temp = "Title: " + taskMap.get(key).get(0) + '\n';
            temp += "Description: " + taskMap.get(key).get(1) + '\n';
            temp += "Category: " + taskMap.get(key).get(2) + '\n';
            temp += "Location: " + taskMap.get(key).get(3) + '\n';
            temp += "Due Date: " + taskMap.get(key).get(4)
                    + "/" + taskMap.get(key).get(5) + " "
                    + taskMap.get(key).get(6) + ":" + taskMap.get(key).get(7)
                    + taskMap.get(key).get(8);

            bt.setText(temp);
            layout2.addView(bt);
            bt.setId(key);
            bt.setOnClickListener(this);
        }
        bSettings = (Button) findViewById(R.id.bSettings);
        bSettings.setOnClickListener(this);
        bAddTask = (Button) findViewById(R.id.bAddTask);
        bAddTask.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bAddTask:
                startActivity(new Intent(this, addTasks.class));
                break;


            case R.id.bSettings:
                startActivity(new Intent(this, settings.class));
                break;



            default:
                if (taskMap.containsKey(v.getId())) {
                    currentId = v.getId();
                    startActivity(new Intent(this, TaskManagement.class));
                }
        }
    }
}