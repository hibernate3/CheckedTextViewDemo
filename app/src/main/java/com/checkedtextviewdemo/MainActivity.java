package com.checkedtextviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    List<String> datas = new ArrayList<String>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++) {
            datas.add("item" + i);
        }
        listView = findViewById(R.id.listview1);
        CustomerAdapter adapter = new CustomerAdapter();

        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    class CustomerAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return datas == null ? 0 : datas.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.item, null);
            final CheckedTextView tv_check = view.findViewById(R.id.checkText);
            tv_check.setText(datas.get(position));
            tv_check.setChecked(true);
            tv_check.setCheckMarkDrawable(R.mipmap.ic_launcher);
            tv_check.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    if (tv_check.isChecked()) {
                        tv_check.setCheckMarkDrawable(R.mipmap.ic_launcher_round);
                    } else {
                        tv_check.setCheckMarkDrawable(R.mipmap.ic_launcher);
                    }

                    tv_check.toggle();
                }
            });

            ViewGroup vg = (ViewGroup) view;
            vg.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            return view;
        }
    }
}