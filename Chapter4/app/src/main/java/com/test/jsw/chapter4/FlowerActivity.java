package com.test.jsw.chapter4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admin on 2016/7/22.
 */
public class FlowerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flowe_layout);

        final ImageView imageView = (ImageView) findViewById(R.id.iv_flower);

        final Animation animBloosm = AnimationUtils.loadAnimation(this,R.anim.bloosm);
        final Animation animReverse = AnimationUtils.loadAnimation(this,R.anim.reverse);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0x123){
                    imageView.startAnimation(animReverse);
                }
            }
        };

    }

}
