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
import com.xsinwa.scaleunit.adapter.IrcResultAdapter;
import com.xsinwa.scaleunit.db.IrcResultInfo;
import com.xsinwa.scaleunit.ui.MyEditText;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IrcActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;

    private MyEditText eT1;
    private MyEditText eT2;
    private MyEditText eR1;
    private TextView eR2;
    private Button IrcTranform;

    private RecyclerView IrcRecyclerView;
    private List<IrcResultInfo> IrcResultInfoList = new ArrayList<IrcResultInfo>();
    private IrcResultAdapter mAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irc);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
        layoutManager = new LinearLayoutManager(IrcActivity.this);
        IrcRecyclerView.setLayoutManager(layoutManager);
        initResults();
    }

    private void initResults() {
        IrcResultInfoList.clear();
        List<IrcResultInfo> tempList = DataSupport.findAll(IrcResultInfo.class);
        for (IrcResultInfo ircResultInfo : tempList){
            IrcResultInfoList.add(0, ircResultInfo);
        }
        mAdapter = new IrcResultAdapter(this, IrcResultInfoList);
        IrcRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        IrcRecyclerView.invalidate();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("绝缘电阻换算");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        eT1 = (MyEditText) findViewById(R.id.T1);
        eT2 = (MyEditText) findViewById(R.id.T2);
        eR1 = (MyEditText) findViewById(R.id.R1);
        eR2 = (TextView) findViewById(R.id.R2);
        IrcTranform = (Button) findViewById(R.id.irc_transform);
        IrcTranform.setOnClickListener(this);

        IrcRecyclerView = (RecyclerView) findViewById(R.id.Irc_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.irc_transform:
                IrcResultInfo ircResultInfo = new IrcResultInfo();
                if (TextUtils.isEmpty(eT1.getInput())){
                    Toast.makeText(this,"请输入温度T1!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(eT2.getInput())) {
                    Toast.makeText(this,"请输入温度T2!", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(eR1.getInput())){
                    Toast.makeText(this,"请输入T1下电阻值R1!", Toast.LENGTH_SHORT).show();
                }else {
                    float T1 = Float.parseFloat(eT1.getInput().toString());
                    float T2 = Float.parseFloat(eT2.getInput().toString());
                    float R1 = Float.parseFloat(eR1.getInput().toString());

                    float R2;
                    R2 = (float) (R1 * Math.pow(1.5, (T2 - T1) / 10));
                    eR2.setText("" + R2);
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("MM-dd HH:mm");
                    String time = timeFormat.format(date);
                    ircResultInfo.setDate(time);
                    ircResultInfo.setResults(eR2.getText().toString());
                    IrcResultInfoList.add(0, ircResultInfo);
                    mAdapter.notifyDataSetChanged();
                    IrcRecyclerView.invalidate();
                }
                break;

            default:
                break;
        }
    }
}
