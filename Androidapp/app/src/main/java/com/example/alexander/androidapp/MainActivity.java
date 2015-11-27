package com.example.alexander.androidapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    private List<Workout> workouts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workouts = new ArrayList<Workout>();
    }


    public void onButtonClick(View v){

        Date date;
        String exercise;
        int sets, reps;

        EditText d = (EditText) findViewById(R.id.date);
        EditText e = (EditText) findViewById(R.id.exercise);
        EditText s = (EditText) findViewById(R.id.num1);
        EditText r = (EditText) findViewById(R.id.num2);


        TextView t1 = (TextView) findViewById(R.id.sum);

        date = new Date();
        exercise = e.getText().toString();
        sets = Integer.parseInt(s.getText().toString());
        reps = Integer.parseInt(r.getText().toString());

       workouts.add(new Workout(date,exercise,sets,reps));

        Toast.makeText(getApplicationContext(), "Your workout has been added to list",
                Toast.LENGTH_SHORT).show();

        t1.setText(String.valueOf(workouts.size()) + date.toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
