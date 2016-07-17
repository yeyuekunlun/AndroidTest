package com.test.jsw.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiashiwei on 16/7/17.
 */

public class BookContent {

    public static List<Book> BOOKLIST= new ArrayList<Book>();
    public static Map<Integer,Book> BOOKMAP = new HashMap<Integer,Book>();


    public static class Book{
        public String bookName;
        public String bookDesc;
        public int bookId;

        public  Book(String name,String desc,int bookId){
            this.bookName = name;
            this.bookDesc = desc;
            this.bookId = bookId;
        }

        @Override
        public String toString() {
            return  this.bookName;
        }
    }

    static
    {
        setData(new Book("无字天书","武林至宝,史上罕有人破译其中武学",1));
        setData(new Book("无字天书2","武林至宝,史上罕有人破译其中武学2",2));
        setData(new Book("无字天书3","武林至宝,史上罕有人破译其中武学3",3));
    }

    private static void setData(Book book){
        BOOKLIST.add(book);
        BOOKMAP.put(book.bookId,book);
    }
}
