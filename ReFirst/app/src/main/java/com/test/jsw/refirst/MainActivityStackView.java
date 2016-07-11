package com.test.jsw.refirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

public class MainActivityStackView extends AppCompatActivity {

    public StackView sv ;
    int[] images = new int[]{R.drawable.chrysanthemum, R.drawable.desert, R.drawable.hydrangeas,
            R.drawable.jellyfish, R.drawable.koala, R.drawable.lighthouse, R.drawable.penguins, R.drawable.tulips};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stackview_adapter_test);
        sv = (StackView)findViewById(R.id.stack_view);

        BaseAdapter adp = new BaseAdapter() {

            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView iv = new ImageView(MainActivityStackView.this);
                iv.setImageResource(images[i]);
                iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER );

                return iv;
            }
        };

        sv.setAdapter(adp);
    }

    public void Next(View view) {
        sv.showNext();
    }

    public void Prev(View view){
        sv.showPrevious();
    }

    public void AutoPlay(View view){
    }
}

