package com.xsinwa.scaleunit.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.adapter.ItcResultAdapter;
import com.xsinwa.scaleunit.db.ItcResultInfo;
import com.xsinwa.scaleunit.ui.MyEditText;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItcActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;

    private MyEditText hTemp;
    private MyEditText nTemp;
    private MyEditText arbTemp;
    private TextView difference;
    private Button ItcTranform;

    private RecyclerView ItcRecyclerView;
    private List<ItcResultInfo> ItcResultList = new ArrayList<ItcResultInfo>();
    private ItcResultAdapter itcResultAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itc);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
        layoutManager = new LinearLayoutManager(ItcActivity.this);
        ItcRecyclerView.setLayoutManager(layoutManager);
        initResults();
    }

    private void initResults() {
        ItcResultList.clear();
        List<ItcResultInfo> tempList = DataSupport.findAll(ItcResultInfo.class);
        for (ItcResultInfo itcResultInfo : tempList){
            ItcResultList.add(0, itcResultInfo);
        }
        itcResultAdapter = new ItcResultAdapter(this, ItcResultList);
        ItcRecyclerView.setAdapter(itcResultAdapter);
        itcResultAdapter.notifyDataSetChanged();
        ItcRecyclerView.invalidate();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("红外测温换算");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        hTemp = (MyEditText) findViewById(R.id.h_temp);
        nTemp = (MyEditText) findViewById(R.id.n_temp);
        arbTemp = (MyEditText) findViewById(R.id.arb_temp);
        difference = (TextView) findViewById(R.id.difference);
        ItcTranform = (Button) findViewById(R.id.Itc_transform);
        ItcTranform.setOnClickListener(this);

        ItcRecyclerView = (RecyclerView) findViewById(R.id.Itc_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.Itc_transform:
                ItcResultInfo itcResultInfo = new ItcResultInfo();
                if (TextUtils.isEmpty(hTemp.getInput())){
                    Toast.makeText(this,"请输入温度T1!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(nTemp.getInput())) {
                    Toast.makeText(this,"请输入温度T2!", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(arbTemp.getInput())){
                    Toast.makeText(this,"请输入T1下电阻值R1!", Toast.LENGTH_SHORT).show();
                }else {
                    float T1 = Float.parseFloat(hTemp.getInput().toString());
                    float T2 = Float.parseFloat(nTemp.getInput().toString());
                    float T0 = Float.parseFloat(arbTemp.getInput().toString());

                    float diff;
                    if ((T1 - T0) == 0){
                        Toast.makeText(this, "T1不能与T0相等！", Toast.LENGTH_SHORT).show();
                    }else {
                        diff = (T1 - T2) / (T1 - T0) * 100;
                        if (diff == 0){
                            difference.setText("0");
                        }else if (diff == 100){
                            difference.setText("1");
                        }else {
                            difference.setText(diff + "%");
                        }
                    }
                    itcResultInfo.setResults(difference.getText().toString());
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("MM-dd HH:mm");
                    String time = timeFormat.format(date);
                    itcResultInfo.setDate(time);
                    ItcResultList.add(0, itcResultInfo);
                    itcResultAdapter.notifyDataSetChanged();
                    ItcRecyclerView.invalidate();
                }
                break;

            default:
                break;
        }
    }
}
