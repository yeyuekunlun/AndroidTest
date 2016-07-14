package com.test.jsw.chapter4;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by admin on 2016/7/14.
 */
public class ExpandableListActivityTest extends ExpandableListActivity {

    int[] icons = {R.drawable.t,R.drawable.p,R.drawable.z};
    String[] titles = {"人族","精灵族","兽族"};
    String[][] descs = {{"古人","仙人","超人"},{"德鲁伊","莉莉丝","玛利亚"},{"狼","龙","凤凰"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseExpandableListAdapter baseExpandableListAdapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return titles.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return descs[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return titles[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return descs[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                return null;
            }

            private TextView getTextView(){
                TextView textView = new TextView(ExpandableListActivityTest.this);
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                return textView;
            }
            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView = getTextView();
                return null;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
        };
    }
}
