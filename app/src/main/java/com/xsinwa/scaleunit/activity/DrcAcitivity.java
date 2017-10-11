package com.xsinwa.scaleunit.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.adapter.DrcResultAdapter;
import com.xsinwa.scaleunit.db.DrcResultInfo;
import com.xsinwa.scaleunit.ui.MyEditText;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Xsinwa on 2017/9/24.
 */

public class DrcAcitivity extends Activity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;
    private RadioGroup wireMaterial;
    private RadioButton Copper;
    private RadioButton Aluminum;
    private TextView RTC;

    private MyEditText eT1;
    private MyEditText eT2;
    private MyEditText eR1;
    private TextView eR2;
    private Button DrcTransform;

    private RecyclerView DrcRecyclerView;
    private List<DrcResultInfo> ResultList = new ArrayList<DrcResultInfo>();
    private DrcResultAdapter mAdapter;


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case R.id.copper:
                    RTC.setText("235");
                    break;

                case R.id.aluminum:
                    RTC.setText("225");
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drc);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        Connector.getDatabase();
        initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(DrcAcitivity.this);
        DrcRecyclerView.setLayoutManager(layoutManager);
        initResults();
    }

    private void initResults() {
        ResultList.clear();
        List<DrcResultInfo> templist = DataSupport.findAll(DrcResultInfo.class);
        for (DrcResultInfo resultInfo: templist){
            ResultList.add(0,resultInfo);
        }
        mAdapter = new DrcResultAdapter(this, ResultList);
        DrcRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        DrcRecyclerView.invalidate();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("直阻换算");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        wireMaterial = (RadioGroup) findViewById(R.id.wire_material);
        wireMaterial.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Message msg = new Message();
                msg.what = checkedId;
                handler.sendMessage(msg);
            }
        });

        Copper = (RadioButton) findViewById(R.id.copper);
        Copper.setChecked(true);
        Aluminum = (RadioButton) findViewById(R.id.aluminum);

        RTC = (TextView) findViewById(R.id.RTC);

        eT1 = (MyEditText) findViewById(R.id.T1);
        eT2 = (MyEditText) findViewById(R.id.T2);
        eR1 = (MyEditText) findViewById(R.id.R1);
        eR2 = (TextView) findViewById(R.id.R2);

        DrcTransform = (Button) findViewById(R.id.Drc_transform);
        DrcTransform.setOnClickListener(this);

        DrcRecyclerView = (RecyclerView) findViewById(R.id.Drc_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.Drc_transform:
                DrcResultInfo resultInfo = new DrcResultInfo();
                if (TextUtils.isEmpty(eT1.getInput())){
                    Toast.makeText(this,"请输入温度T1!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(eT2.getInput())) {
                    Toast.makeText(this,"请输入温度T2!", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(eR1.getInput())){
                    Toast.makeText(this,"请输入T1下电阻值R1!", Toast.LENGTH_SHORT).show();
                }else {
                    float T = Float.parseFloat(RTC.getText().toString());
                    float T1 = Float.parseFloat(eT1.getInput().toString());
                    float T2 = Float.parseFloat(eT2.getInput().toString());
                    float R1 = Float.parseFloat(eR1.getInput().toString());
                    float result = (T + T2) / (T + T1) * R1;
                    eR2.setText(""+ result);
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("MM-dd HH:mm");
                    String time = timeFormat.format(date);
                    resultInfo.setDate(time);
                    resultInfo.setResult(eR2.getText().toString());
                    resultInfo.save();
                    ResultList.add(0, resultInfo);
                    mAdapter.notifyDataSetChanged();
                    DrcRecyclerView.invalidate();
                }
                break;

            default:
                break;
        }
    }
}
