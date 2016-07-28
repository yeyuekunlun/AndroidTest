package com.test.jsw.chapter4;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by admin on 2016/7/25.
 */
public class GestrueTest extends Activity implements GestureDetector.OnGestureListener
{

    GestureDetector gestureDetector ;
    ImageView imageView;
    int curScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector = new GestureDetector(this,this);
        setContentView(R.layout.flowe_layout);
        imageView = (ImageView)findViewById(R.id.iv_flower);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
//        Toast.makeText(this,"onDown",Toast.LENGTH_SHORT).show();
        return false;

    }

    @Override
    public void onShowPress(MotionEvent e) {
//        Toast.makeText(this,"onShowPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
//        Toast.makeText(this,"onSingleTapUp",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Toast.makeText(this,"onScroll",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
//        Toast.makeText(this,"onLongPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        velocityX = velocityX>4000?4000:velocityX;
        velocityX = velocityX<-4000?-4000:velocityX;

        curScale+=curScale*velocityX/4000.0f;

        Matrix matrix = new Matrix();
        matrix.setScale(curScale,curScale);
        return false;
    }
}
