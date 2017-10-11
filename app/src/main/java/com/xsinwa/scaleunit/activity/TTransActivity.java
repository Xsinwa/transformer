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
import com.xsinwa.scaleunit.adapter.DrcTransAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xsinwa on 2017/10/3.
 */
public class TTransActivity extends Activity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DrcTransAdapter mAdapter;

    private List<String> output2List = new ArrayList<String>();
    private List<String> output3List = new ArrayList<String>();
    private List<String> output1List = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttrans);
        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Intent intent = getIntent();
        output1List = intent.getStringArrayListExtra("output1");
        output2List = intent.getStringArrayListExtra("output2");
        output3List = intent.getStringArrayListExtra("output3");
        initView();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("三角转换结果");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.tt_result_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new DrcTransAdapter(output1List,output2List,output3List);
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
