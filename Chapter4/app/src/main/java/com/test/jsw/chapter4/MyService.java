package com.test.jsw.chapter4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by admin on 2016/7/28.
 */
public class MyService extends Service {
    int state = 0;
    MyBind myBind = new MyBind();
    boolean flag = true;
    public class MyBind extends Binder{
        public int getCount(){
          return state;
        };
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d("MyService","MyService onBind");
        return myBind;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService","MyService Created");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    state++;
                }
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("MyService","MyService onUnbind");
        flag = false;
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("MyService","MyService onRebind");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","MyService onDestroy");
    }
}
