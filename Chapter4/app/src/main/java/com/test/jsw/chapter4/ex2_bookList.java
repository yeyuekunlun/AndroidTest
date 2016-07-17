package com.test.jsw.chapter4;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.test.jsw.entity.BookContent;

/**
 * Created by jiashiwei on 16/7/17.
 */

public class ex2_bookList extends ListFragment {

    public CallBacks callBack;

    public interface  CallBacks{
        void onListItemClick(Integer id);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(BookContent.BOOKLIST);
        ListAdapter listAdapter = new ArrayAdapter<BookContent.Book>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,BookContent.BOOKLIST);
        setListAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("tag",position+"");

        callBack.onListItemClick(BookContent.BOOKLIST.get(position).bookId);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(!(activity instanceof CallBacks)){
            throw new IllegalStateException("需要实现Callbacks接口");

        }
        this.callBack = (CallBacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.callBack = null;
    }


    public void setActivateOnItemClick(boolean activateOnItemClick)
    {
        getListView().setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }
}
