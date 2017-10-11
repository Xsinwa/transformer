package com.xsinwa.scaleunit.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.adapter.BbrcTransAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xsinwa on 2017/10/3.
 */
public class BbrcTransActivity extends Activity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;

    private List<String> outputList = new ArrayList<String>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManger;
    private BbrcTransAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbrctrans);
        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("不平衡率换算结果");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        Intent intent = getIntent();
        outputList = intent.getStringArrayListExtra("output");

        recyclerView = (RecyclerView) findViewById(R.id.bbrc_result_list);
        layoutManger = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManger);
        mAdapter = new BbrcTransAdapter(outputList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        recyclerView.invalidate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            default:
                break;
        }

    }
}
