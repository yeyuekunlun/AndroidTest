package com.test.jsw.chapter4;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by admin on 2016/7/14.
 */
public class Exercise1Activity extends LauncherActivity {

    String[] names = {"设置程序参数","查看星际兵种"};
    Class<?>[] clazzs = {};
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(this,clazzs[position]);
    }
}
