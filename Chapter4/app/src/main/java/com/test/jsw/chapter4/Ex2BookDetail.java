package com.test.jsw.chapter4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.jsw.entity.BookContent;

/**
 * Created by jiashiwei on 16/7/17.
 */

public class Ex2BookDetail extends Fragment {

    BookContent.Book book;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey("BOOKID")){
            book = BookContent.BOOKMAP.get(getArguments().getInt("BOOKID"));
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ex2_book_detail,container,false);

        if (book != null){
            TextView textView_title = (TextView) view.findViewById(R.id.ex2_book_title);
            TextView textView_desc = (TextView) view.findViewById(R.id.ex2_book_desc);
            textView_title.setText(book.bookName);
            textView_desc.setText(book.bookDesc);

        }

        return view;
    }
}
