package com.test.jsw.chapter4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by admin on 2016/7/22.
 */
public class BomActivity extends Activity {
    MyView myView;
    AnimationDrawable anim ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(R.drawable.back);
        setContentView(frameLayout);
        myView = new MyView(this);
        myView.setBackgroundResource(R.drawable.blast);
        myView.setVisibility(View.INVISIBLE);
        anim = (AnimationDrawable) myView.getBackground();

        frameLayout.addView(myView);
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    anim.stop();
                    myView.setLocation((int)event.getX(),(int)event.getY());
                    myView.setVisibility(View.VISIBLE);
                    anim.start();
                }
                return false;
            }
        });
    }


    class MyView extends ImageView{

        public MyView(Context context){
            super(context);
        }
        public void setLocation(int top, int left){
            this.setFrame(top,left,top+40,left+40);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            try {
                Field field = AnimationDrawable.class.getDeclaredField("mCurFrame");
                field.setAccessible(true);
                int curFrame = field.getInt(anim);
                if (curFrame == anim.getNumberOfFrames()-1){
                    setVisibility(View.INVISIBLE);
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            super.onDraw(canvas);
        }
    }
}
