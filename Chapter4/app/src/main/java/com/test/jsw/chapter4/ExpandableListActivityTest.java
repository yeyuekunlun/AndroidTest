package com.test.jsw.chapter4;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
                LinearLayout linearLayout = new LinearLayout(ExpandableListActivityTest.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT));

                ImageView imageView = new ImageView(ExpandableListActivityTest.this);
                imageView.setImageResource(icons[i]);
                imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT,AbsListView.LayoutParams.WRAP_CONTENT));

                TextView textView = getTextView();
                textView.setText(titles[i]);

                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }

            private TextView getTextView(){
                TextView textView = new TextView(ExpandableListActivityTest.this);
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                return textView;
            }
            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView = getTextView();
                textView.setText(descs[i][i1]);
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
        };

        setListAdapter(baseExpandableListAdapter);
    }
}
