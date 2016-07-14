package com.test.jsw.chapter4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void DoExerciseOne(View view){
        Toast.makeText(this,"test1",Toast.LENGTH_SHORT);
        Intent intent = new Intent(this,Exercise1Activity.class);
        startActivity(intent);
    }
}
