package com.test.jsw.refirst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ViewSwitcher;

/**
 * Created by admin on 2016/7/11.
 */
public class MainActivity extends Activity{
    static int lableSize = 40;
    String [] lableNames = new String[lableSize];
    int[] icons = new int[lableSize];
    int currentPageNum = -1;
    ViewSwitcher vs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_switcher);
        vs = (ViewSwitcher)findViewById(R.id.viewSwitcher);
        for (int i=0;i<lableSize;i++){
            lableNames[i]=i+"";
            icons[i]=R.drawable.ic_launcher;
        }

        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return lableSize;
            }

            @Override
            public Object getItem(int i) {
                return ;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return null;
            }
        }





    }
}
