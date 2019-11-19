package com.pxz.baseadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 类说明：首页
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 10:07
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvList;
    private TextView tvRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initOnClick();
    }

    private void initView() {
        tvList=findViewById(R.id.tv_list);
        tvRecycler=findViewById(R.id.tv_recycler);
    }

    private void initOnClick() {
        tvList.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);
        });
        tvRecycler.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,RecyclerActivity.class);
            startActivity(intent);
        });
    }
}