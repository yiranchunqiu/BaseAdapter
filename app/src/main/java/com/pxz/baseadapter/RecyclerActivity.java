package com.pxz.baseadapter;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：recyclerview
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 15:25
 */
public class RecyclerActivity extends AppCompatActivity {
    private TextView tvLeft;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private Recycler1Adapter recycler1Adapter;
    private Recycler2Adapter recycler2Adapter;
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<TypeBean> typeBeans = new ArrayList<>();
    private int num = 100;
    private int num2 = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        initAdapter();
        initData();
        initOnClick();
    }

    private void initView() {
        tvLeft = findViewById(R.id.tv_left);
        rv1 = findViewById(R.id.rv_1);
        rv2 = findViewById(R.id.rv_2);
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv1.setLayoutManager(linearLayoutManager);
        recycler1Adapter = new Recycler1Adapter(RecyclerActivity.this, strings);
        rv1.setAdapter(recycler1Adapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(RecyclerActivity.this);
        linearLayoutManager2.setOrientation(RecyclerView.VERTICAL);
        rv2.setLayoutManager(linearLayoutManager2);
        recycler2Adapter = new Recycler2Adapter(RecyclerActivity.this, typeBeans);
        rv2.setAdapter(recycler2Adapter);
    }

    private void initData() {
        for (int i = 0; i < num; i++) {
            strings.add(i + ":你好");
        }
        recycler1Adapter.notifyDataSetChanged();
        for (int i = 0; i < num2; i++) {
            typeBeans.add(new TypeBean(1, (0 + 10 * i) + ""));
            typeBeans.add(new TypeBean(2, (1 + 10 * i) + ""));
            typeBeans.add(new TypeBean(2, (2 + 10 * i) + ""));
            typeBeans.add(new TypeBean(1, (3 + 10 * i) + ""));
            typeBeans.add(new TypeBean(1, (4 + 10 * i) + ""));
            typeBeans.add(new TypeBean(2, (5 + 10 * i) + ""));
            typeBeans.add(new TypeBean(1, (6 + 10 * i) + ""));
            typeBeans.add(new TypeBean(2, (7 + 10 * i) + ""));
            typeBeans.add(new TypeBean(2, (8 + 10 * i) + ""));
            typeBeans.add(new TypeBean(1, (9 + 10 * i) + ""));
        }
        recycler2Adapter.notifyDataSetChanged();
    }

    private void initOnClick() {
        tvLeft.setOnClickListener(v -> finish());
    }
}