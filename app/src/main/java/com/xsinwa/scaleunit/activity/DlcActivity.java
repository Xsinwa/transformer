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
import com.xsinwa.scaleunit.adapter.ResultDisplayAdapter;
import com.xsinwa.scaleunit.db.ResultInfo;
import com.xsinwa.scaleunit.ui.MyEditText;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DlcActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;

    private MyEditText eT1;
    private MyEditText eT2;
    private MyEditText DielLoss1;
    private TextView DielLoss2;
    private Button DielLossTransform;

    private RecyclerView DlcRecyclerView;
    private List<ResultInfo> ResultList = new ArrayList<ResultInfo>();
    private ResultDisplayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlc);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Connector.getDatabase();
        initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(DlcActivity.this);
        DlcRecyclerView.setLayoutManager(layoutManager);
        initResults();
    }

    private void initResults() {
        ResultList.clear();
        List<ResultInfo> templist = DataSupport.findAll(ResultInfo.class);
        for (ResultInfo resultInfo: templist){
            ResultList.add(0,resultInfo);
        }
        mAdapter = new ResultDisplayAdapter(this, ResultList);
        DlcRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        DlcRecyclerView.invalidate();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("介损换算");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        eT1 = (MyEditText) findViewById(R.id.T1);
        eT2 = (MyEditText) findViewById(R.id.T2);
        DielLoss1 = (MyEditText) findViewById(R.id.Diel_loss1);
        DielLoss2 = (TextView) findViewById(R.id.Diel_loss2);
        DielLossTransform = (Button) findViewById(R.id.Diel_transform);
        DielLossTransform.setOnClickListener(this);

        DlcRecyclerView = (RecyclerView) findViewById(R.id.Dlc_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.Diel_transform:
                ResultInfo resultInfo = new ResultInfo();
                if (TextUtils.isEmpty(eT1.getInput())){
                    Toast.makeText(this,"请输入温度T1!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(eT2.getInput())) {
                    Toast.makeText(this,"请输入温度T2!", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(DielLoss1.getInput())){
                    Toast.makeText(this,"请输入T1下介损值tanδ1!", Toast.LENGTH_SHORT).show();
                }else {
                    float T1 = Float.parseFloat(eT1.getInput().toString());
                    float T2 = Float.parseFloat(eT2.getInput().toString());
                    float tan1 = Float.parseFloat(DielLoss1.getInput().toString());
                    float tan2;
                    tan2 = (float) (tan1 * Math.pow(1.3, (T2 - T1) / 10));
                    DielLoss2.setText("" + tan2);
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("MM-dd HH:mm");
                    String time = timeFormat.format(date);
                    resultInfo.setDate(time);
                    resultInfo.setResult(DielLoss2.getText().toString());
                    ResultList.add(0, resultInfo);
                    mAdapter.notifyDataSetChanged();
                    DlcRecyclerView.invalidate();
                }
                break;

            default:
                break;
        }
    }
}
