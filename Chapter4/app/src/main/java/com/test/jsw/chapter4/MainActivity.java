package com.test.jsw.chapter4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.test.jsw.entity.TestActivity;


public class MainActivity extends AppCompatActivity {

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn_exercise1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"test1",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Exercise1Activity.class);
                startActivity(intent);
            }
        });


    }

    public void DoExerciseTwo(View view){
        Log.d("TEST",EX2MainActivity.class.getName());
        Log.d("TEST",TestActivity.class.getName());
        Intent intent = new Intent(MainActivity.this,EX2MainActivity.class);
        startActivity(intent);
//        this.finish();
//        mediaPlayer = new MediaPlayer();
//        try{
//            mediaPlayer.setDataSource(getAssets().openFd("").getFileDescriptor());
//        }catch (Exception e){
//
//        }
    }

    public void StartBrickGame(View view){

    }

    public void PlayAnimBom(View view){
        Intent intent = new Intent(MainActivity.this,BomActivity.class);
        startActivity(intent);
    }

    public void PlayAnimFlower(View view){
        Intent intent = new Intent(MainActivity.this,FlowerActivity.class);
        startActivity(intent);
    }

}
