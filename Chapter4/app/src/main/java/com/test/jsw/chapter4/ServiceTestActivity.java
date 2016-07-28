package com.test.jsw.chapter4;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by admin on 2016/7/28.
 */
public class ServiceTestActivity extends Activity implements View.OnClickListener

{
    Intent intent;
    Button btn_bind;
    Button btn_state;
    Button btn_unbind;
    ServiceConnection serviceConnection;
    MyService.MyBind bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_test_layout);
        btn_bind = (Button) findViewById(R.id.btn_service_bind);
        btn_state = (Button) findViewById(R.id.btn_service_state);
        btn_unbind = (Button) findViewById(R.id.btn_service_unbind);

        btn_bind.setOnClickListener(this);
        btn_state.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("ServiceTestActivity", "ServiceTestActivity onServiceConnected");
                bind = (MyService.MyBind) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("ServiceTestActivity", "ServiceTestActivity onServiceDisconnected");
            }
        };

         intent = new Intent(this, MyService.class);
    }

    @Override
    public void onClick(View v) {

        if (v == btn_bind) {
            bindService(intent,serviceConnection, Service.BIND_AUTO_CREATE);
        } else if (v == btn_state) {
            Toast.makeText(this,bind.getCount(),Toast.LENGTH_SHORT).show();
        } else if (v == btn_unbind) {
            unbindService(serviceConnection);
        }
    }
}
