package com.pxz.baseadapter;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 类说明：listview
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 15:25
 */
public class ListActivity extends AppCompatActivity {
    private TextView tvLeft;
    private ListView lv;
    private ListAdapter listAdapter;
    private ArrayList<String> strings = new ArrayList<>();
    private int num=100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        initAdapter();
        initData();
        initOnClick();
    }

    private void initView() {
        tvLeft = findViewById(R.id.tv_left);
        lv = findViewById(R.id.lv);
    }

    private void initAdapter() {
        listAdapter = new ListAdapter(ListActivity.this, strings);
        lv.setAdapter(listAdapter);
    }

    private void initData() {
        for (int i = 0; i < num; i++) {
            strings.add(i + ":你好");
        }
        listAdapter.notifyDataSetChanged();
    }

    private void initOnClick() {
        tvLeft.setOnClickListener(v -> finish());
    }
}