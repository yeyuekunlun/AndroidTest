package com.test.jsw.entity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.test.jsw.chapter4.Ex2BookDetail;
import com.test.jsw.chapter4.R;
import com.test.jsw.chapter4.ex2_bookList;

/**
 * Created by jiashiwei on 16/7/17.
 */

public class TestActivity extends Activity implements ex2_bookList.CallBacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex2_fragment_test);
    }


    @Override
    public void onListItemClick(Integer id) {
        Bundle bundle = new Bundle();
        bundle.putInt("BOOKID",id);
        Ex2BookDetail ebd = new Ex2BookDetail();
        ebd.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ex2_book_detail,ebd).commit();
    }
}
