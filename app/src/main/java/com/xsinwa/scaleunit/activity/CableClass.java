package com.xsinwa.scaleunit.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.xsinwa.scaleunit.adapter.MyPagerAdpter;
import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.ui.MyEditText;

import java.util.ArrayList;
import java.util.List;

public class CableClass extends AppCompatActivity implements View.OnClickListener {
    private TextView t10KV;
    private TextView t35KV;
    private TextView t110KV;
    private TextView t220KV;

    private View page10KV, page35KV, page110KV, page220KV;
    private ViewPager cViewPager;
    private List<View> pageList = new ArrayList<View>();
    private MyPagerAdpter myPagerAdpter;
    private TextView topTitle;
    private LinearLayout Backward;

    private LinearLayout resultTransform10;
    private LinearLayout resultTransform35;
    private LinearLayout resultTransform110;
    private LinearLayout resultTransform220;

    private String[] mItems;
    private ArrayAdapter<String> adapter;
    private String[] rvItems;
    private ArrayAdapter<String> rvAdapter;
    private String[] uItems;//单位电容量
    private ArrayAdapter<String> uAdapter;

    private String[] rItems10;
    private String[] rItems35;
    private ArrayAdapter<String> rAdapter10;
    private ArrayAdapter<String> rAdapter35;

    private Spinner csSpinner;
    private Spinner rv10Spinner;
    private TextView unitCap10;
    private Spinner cs35Spinner;
    private Spinner rv35Spinner;
    private TextView unitCap35;
    private Spinner reactor10Spinner;
    private Spinner reactor35Spinner;

    private Button c10Transform;
    private MyEditText cableLength10;
    private TextView ESL10;
    private TextView cableMaxLen10;
    private TextView cableCapa10;
    private TextView frequence10;
    private TextView EDR10;
    private TextView hvCurrent10;
    private TextView EVHV10;
    private TextView EVLV10;
    private TextView testCapa10;
    private TextView Qvalue10;
    private TextView EVR10;
    private TextView InCurrent10;
    private TextView OutVoltage10;
    private TextView InVoltage10;
    private TextView powerCapa10;
    private TextView fcPowerCapa10;
    private TextView powerInCurrent10;
    private Spinner EvhvSpinner10;

    private String[] uItems35;//单位电容量
     private ArrayAdapter<String> uAdapter35;
    private Button c35Transform;
    private MyEditText cableLength35;
    private TextView ESL35;
    private TextView cableMaxLen35;
    private TextView cableCapa35;
    private TextView frequence35;
    private TextView EDR35;
    private TextView hvCurrent35;
    private TextView EVHV35;
    private TextView EVLV35;
    private TextView testCapa35;
    private TextView Qvalue35;
    private TextView EVR35;
    private TextView InCurrent35;
    private TextView OutVoltage35;
    private TextView InVoltage35;
    private TextView powerCapa35;
    private TextView fcPowerCapa35;
    private TextView powerInCurrent35;
    private Spinner EvhvSpinner35;

    private String[] csItems;
    private String[] IsrItems;
    private String[] unitCapItems;
    private String[] reactorItems;
    private ArrayAdapter<String> csAdapter;
    private ArrayAdapter<String> IsrAdapter;
    private ArrayAdapter<String> ReactorAdapter;
    private TextView ratedVoltage110;
    private Spinner csSpinner110;
    private TextView unitCap110;
    private TextView DRSR110;//单台电抗器直阻
    private Spinner Isr110; //电抗器电感
    private Spinner ReactorConnMode110; //电抗器连接方式
    private Spinner EVHVSpinner110;
    private Spinner EVLVSpinner110; //励磁变低压抽头
    private Button c110Transform;
    private MyEditText cableLength110;
    private TextView ESL110; //等效电感
    private TextView cableMaxLen110; //电缆最大长度
    private TextView cableCapa110;
    private TextView frequence110;
    private TextView EDR110;
    private TextView hvCurrent110;
    private TextView EVHV110;
    private TextView EVLV110;
    private TextView testCapa110;
    private TextView Qvalue110;
    private TextView EVR110;
    private TextView InCurrent110;
    private TextView OutVoltage110;
    private TextView InVoltage110;
    private TextView powerCapa110;
    private TextView fcPowerCapa110;
    private TextView powerInCurrent110;



    private Spinner csSpinner220;
    private TextView ratedVoltage220;
    private TextView unitCap220;
    private TextView DRSR220;
    private Spinner Isr220;
    private Spinner ReactorConnMode220; //电抗器连接方式
    private Spinner EVHVSpinner220;
    private Spinner EVLVSpinner220; //励磁变低压抽头
    private Button c220Transform;
    private MyEditText cableLength220;
    private TextView ESL220; //等效电感
    private TextView cableMaxLen220; //电缆最大长度
    private TextView cableCapa220;
    private TextView frequence220;
    private TextView EDR220;
    private TextView hvCurrent220;
    private TextView EVHV220;
    private TextView EVLV220;
    private TextView testCapa220;
    private TextView Qvalue220;
    private TextView EVR220;
    private TextView InCurrent220;
    private TextView OutVoltage220;
    private TextView InVoltage220;
    private TextView powerCapa220;
    private TextView fcPowerCapa220;
    private TextView powerInCurrent220;

    private int reactor10Position = 0;
    private int unitCapPosition = 0;
    private int rv10Position = 0;
    private int evhvPosition = 0;
    private int reactor35Position = 0;
    private int unitCap35Position = 0;
    private int evhv35Position = 0;
    private int rv35Position = 0;
    private int cs110Position = 0;
    private int cs22oPosition = 0;
    private int reactor110Position = 0;
    private int reactor220Postion = 0;
    private int isr220Position = 0;
    private int evhv110Position = 0;
    private int evhv220Position = 0;
    private int evlv110Position = 0;
    private int evlv220Position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cable_class);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("电缆类");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        t10KV = (TextView) findViewById(R.id.t_10KV);
        t10KV.setBackgroundColor(Color.parseColor("#E0FFFF"));

        t35KV = (TextView) findViewById(R.id.t_35KV);
        t35KV.setBackgroundColor(Color.parseColor("#EBEBEB"));

        t110KV = (TextView) findViewById(R.id.t_110KV);
        t110KV.setBackgroundColor(Color.parseColor("#EBEBEB"));

        t220KV = (TextView) findViewById(R.id.t_220KV);
        t220KV.setBackgroundColor(Color.parseColor("#EBEBEB"));

        cViewPager = (ViewPager) findViewById(R.id.cViewPager);
        LayoutInflater inflater = getLayoutInflater();
        page10KV = inflater.inflate(R.layout.page_10kv,null);
        page35KV = inflater.inflate(R.layout.page_35kv,null);
        page110KV = inflater.inflate(R.layout.page_110kv,null);
        page220KV = inflater.inflate(R.layout.page_220kv,null);
        pageList.add(page10KV);
        pageList.add(page35KV);
        pageList.add(page110KV);
        pageList.add(page220KV);

        myPagerAdpter = new MyPagerAdpter(pageList);
        cViewPager.setAdapter(myPagerAdpter);
        cViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Message msg = new Message();
                msg.what = position;
                handler.sendMessage(msg);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //10kv
        resultTransform10 = (LinearLayout) page10KV.findViewById(R.id.result_transform);
        resultTransform10.setVisibility(View.GONE);
        csSpinner = (Spinner) page10KV.findViewById(R.id.spinner_cs);
        csSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitCapItems(position, rv10Position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rv10Spinner = (Spinner) page10KV.findViewById(R.id.spinner_rv);
        mItems = getResources().getStringArray(R.array.cs10_array6);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        csSpinner.setAdapter(adapter);
        rvItems = getResources().getStringArray(R.array.rv10_array);
        rvAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rvItems);
        rv10Spinner.setAdapter(rvAdapter);
        rv10Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rv10Position = position;
                setCsItems(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        reactor10Spinner = (Spinner) page10KV.findViewById(R.id.reactor_conn_mode);
        rItems10 = getResources().getStringArray(R.array.ReactorConnMode_array);
        rAdapter10 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,rItems10);
        reactor10Spinner.setAdapter(rAdapter10);
        reactor10Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reactor10Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        unitCap10 = (TextView) page10KV.findViewById(R.id.t_unitCap);
        uItems = getResources().getStringArray(R.array.unitCap6_array);
        uAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, uItems);
        c10Transform = (Button) page10KV.findViewById(R.id.c_transform);
        c10Transform.setOnClickListener(this);
        cableLength10 = (MyEditText) page10KV.findViewById(R.id.cable_len);
        ESL10 = (TextView) page10KV.findViewById(R.id.ESL);
        cableMaxLen10 = (TextView) page10KV.findViewById(R.id.max_len);
        cableCapa10 = (TextView) page10KV.findViewById(R.id.cable_capa);
        frequence10 = (TextView) page10KV.findViewById(R.id.frequency);
        EDR10 = (TextView) page10KV.findViewById(R.id.EDR);
        hvCurrent10 = (TextView) page10KV.findViewById(R.id.hv_current);
        EVHV10 = (TextView) page10KV.findViewById(R.id.EVHV);
        EvhvSpinner10 = (Spinner) page10KV.findViewById(R.id.EVHV_spinner);
        EvhvSpinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evhvPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EVLV10 = (TextView) page10KV.findViewById(R.id.EVLV);
        testCapa10 = (TextView) page10KV.findViewById(R.id.test_capa);
        Qvalue10 = (TextView) page10KV.findViewById(R.id.Qvalue);
        EVR10 = (TextView) page10KV.findViewById(R.id.EVR);
        InCurrent10 = (TextView) page10KV.findViewById(R.id.in_current);
        OutVoltage10 = (TextView) page10KV.findViewById(R.id.out_voltage);
        InVoltage10 = (TextView) page10KV.findViewById(R.id.in_voltage);
        powerCapa10 = (TextView) page10KV.findViewById(R.id.power_capa);
        fcPowerCapa10 = (TextView) page10KV.findViewById(R.id.fc_power_capa);
        powerInCurrent10 = (TextView) page10KV.findViewById(R.id.power_in_current);

        //35kv
        resultTransform35 = (LinearLayout) page35KV.findViewById(R.id.result_transform);
        resultTransform35.setVisibility(View.GONE);
        cs35Spinner = (Spinner) page35KV.findViewById(R.id.spinner_cs);
        cs35Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitCap35Items(position, rv35Position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rv35Spinner = (Spinner) page35KV.findViewById(R.id.spinner_rv);
        rv35Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rv35Position = position;
                set35CsItmes(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        reactor35Spinner = (Spinner) page35KV.findViewById(R.id.reactor_conn_mode);
        rItems35 = getResources().getStringArray(R.array.ReactorConnMode35_array);
        rAdapter35 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,rItems35);
        reactor35Spinner.setAdapter(rAdapter35);
        reactor35Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reactor35Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        unitCap35 = (TextView) page35KV.findViewById(R.id.t_unitCap);
        cableLength35 = (MyEditText) page35KV.findViewById(R.id.cable_len);
        ESL35 = (TextView) page35KV.findViewById(R.id.ESL);
        cableMaxLen35 = (TextView) page35KV.findViewById(R.id.max_len);
        cableCapa35 = (TextView) page35KV.findViewById(R.id.cable_capa);
        frequence35 = (TextView) page35KV.findViewById(R.id.frequency);
        EDR35 = (TextView) page35KV.findViewById(R.id.EDR);
        hvCurrent35 = (TextView) page35KV.findViewById(R.id.hv_current);
        EVHV35 = (TextView) page35KV.findViewById(R.id.EVHV);
        EvhvSpinner35 = (Spinner) page35KV.findViewById(R.id.EVHV_spinner);
        EvhvSpinner35.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evhv35Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EVLV35 = (TextView) page35KV.findViewById(R.id.EVLV);
        testCapa35 = (TextView) page35KV.findViewById(R.id.test_capa);
        Qvalue35 = (TextView) page35KV.findViewById(R.id.Qvalue);
        EVR35 = (TextView) page35KV.findViewById(R.id.EVR);
        InCurrent35 = (TextView) page35KV.findViewById(R.id.in_current);
        OutVoltage35 = (TextView) page35KV.findViewById(R.id.out_voltage);
        InVoltage35 = (TextView) page35KV.findViewById(R.id.in_voltage);
        powerCapa35 = (TextView) page35KV.findViewById(R.id.power_capa);
        fcPowerCapa35 = (TextView) page35KV.findViewById(R.id.fc_power_capa);
        powerInCurrent35 = (TextView) page35KV.findViewById(R.id.power_in_current);
        c35Transform = (Button) page35KV.findViewById(R.id.c_transform);
        c35Transform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickProcess35();
            }
        });

        //110kv
        resultTransform110 = (LinearLayout) page110KV.findViewById(R.id.result_transform);
        resultTransform110.setVisibility(View.GONE);
        csSpinner110 = (Spinner) page110KV.findViewById(R.id.spinner_cs);
        csSpinner110.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitCap110(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EVHVSpinner110 = (Spinner) page110KV.findViewById(R.id.Evhvt);
        EVHVSpinner110.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evhv110Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EVLVSpinner110 = (Spinner) page110KV.findViewById(R.id.Evlvt);
        EVLVSpinner110.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evlv110Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ratedVoltage110 = (TextView) page110KV.findViewById(R.id.rated_vol);
        unitCap110 = (TextView) page110KV.findViewById(R.id.unitcap);
        DRSR110 = (TextView) page110KV.findViewById(R.id.drsr);
        Isr110 = (Spinner) page110KV.findViewById(R.id.isr_spinner);
        ReactorConnMode110 = (Spinner) page110KV.findViewById(R.id.reactor_conn_mode);
        ReactorConnMode110.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reactor110Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        c110Transform = (Button) page110KV.findViewById(R.id.cable_transform);
        c110Transform.setOnClickListener(this);
        cableLength110 = (MyEditText) page110KV.findViewById(R.id.cable_len);
        ESL110 = (TextView) page110KV.findViewById(R.id.ESL);
        cableMaxLen110 = (TextView) page110KV.findViewById(R.id.max_len);
        cableCapa110 = (TextView) page110KV.findViewById(R.id.cable_capa);
        frequence110 = (TextView) page110KV.findViewById(R.id.frequency);
        EDR110 = (TextView) page110KV.findViewById(R.id.EDR);
        hvCurrent110 = (TextView) page110KV.findViewById(R.id.hv_current);
        EVHV110 = (TextView) page110KV.findViewById(R.id.EVHV);
        EVLV110 = (TextView) page110KV.findViewById(R.id.EVLV);
        testCapa110 = (TextView) page110KV.findViewById(R.id.test_capa);
        Qvalue110 = (TextView) page110KV.findViewById(R.id.Qvalue);
        EVR110 = (TextView) page110KV.findViewById(R.id.EVR);
        InCurrent110 = (TextView) page110KV.findViewById(R.id.in_current);
        OutVoltage110 = (TextView) page110KV.findViewById(R.id.out_voltage);
        InVoltage110 = (TextView) page110KV.findViewById(R.id.in_voltage);
        powerCapa110 = (TextView) page110KV.findViewById(R.id.power_capa);
        powerInCurrent110 = (TextView) page110KV.findViewById(R.id.power_in_current);
        fcPowerCapa110 = (TextView) page110KV.findViewById(R.id.fc_power_capa);

        //220kv
        resultTransform220 = (LinearLayout) page220KV.findViewById(R.id.result_transform);
        resultTransform220.setVisibility(View.GONE);
        csSpinner220 = (Spinner) page220KV.findViewById(R.id.spinner_cs);
        csSpinner220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitCap220(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ratedVoltage220 = (TextView) page220KV.findViewById(R.id.rated_vol);
        unitCap220 = (TextView) page220KV.findViewById(R.id.unitcap);
        DRSR220 = (TextView) page220KV.findViewById(R.id.drsr);
        Isr220 = (Spinner) page220KV.findViewById(R.id.isr_spinner);
        Isr220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setDRSR220(position);
                isr220Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ReactorConnMode220 = (Spinner) page220KV.findViewById(R.id.reactor_conn_mode);
        ReactorConnMode220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reactor220Postion = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EVHVSpinner220 = (Spinner) page220KV.findViewById(R.id.Evhvt);
        EVHVSpinner220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evhv220Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EVLVSpinner220 = (Spinner) page220KV.findViewById(R.id.Evlvt);
        EVLVSpinner220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evlv220Position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        c220Transform = (Button) page220KV.findViewById(R.id.cable_transform);
        c220Transform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResultTransform();
            }
        });
        cableLength220 = (MyEditText) page220KV.findViewById(R.id.cable_len);
        ESL220 = (TextView) page220KV.findViewById(R.id.ESL);
        cableMaxLen220 = (TextView) page220KV.findViewById(R.id.max_len);
        cableCapa220 = (TextView) page220KV.findViewById(R.id.cable_capa);
        frequence220 = (TextView) page220KV.findViewById(R.id.frequency);
        EDR220 = (TextView) page220KV.findViewById(R.id.EDR);
        hvCurrent220 = (TextView) page220KV.findViewById(R.id.hv_current);
        EVHV220 = (TextView) page220KV.findViewById(R.id.EVHV);
        EVLV220 = (TextView) page220KV.findViewById(R.id.EVLV);
        testCapa220 = (TextView) page220KV.findViewById(R.id.test_capa);
        Qvalue220 = (TextView) page220KV.findViewById(R.id.Qvalue);
        EVR220 = (TextView) page220KV.findViewById(R.id.EVR);
        InCurrent220 = (TextView) page220KV.findViewById(R.id.in_current);
        OutVoltage220 = (TextView) page220KV.findViewById(R.id.out_voltage);
        InVoltage220 = (TextView) page220KV.findViewById(R.id.in_voltage);
        powerCapa220 = (TextView) page220KV.findViewById(R.id.power_capa);
        powerInCurrent220 = (TextView) page220KV.findViewById(R.id.power_in_current);
        fcPowerCapa220 = (TextView) page220KV.findViewById(R.id.fc_power_capa);
    }

    private void set35CsItmes(int position) {
        mItems = getResources().getStringArray(R.array.cs35_array);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        cs35Spinner.setAdapter(adapter);
    }

    private void setCsItems(int position) {
        if (position == 0){
            mItems = getResources().getStringArray(R.array.cs10_array6);
        }else if (position == 1){
            mItems = getResources().getStringArray(R.array.cs10_array8);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        csSpinner.setAdapter(adapter);
    }


    private void setDRSR220(int position) {
        if(position == 0){
            DRSR220.setText("327.8");
        }else if (position == 1){
            DRSR220.setText("3170");
        }

    }

    private void setUnitCap220(int position) {
        if (unitCapItems != null){
            unitCap220.setText("" + unitCapItems[position]);
        }
    }

    private void setUnitCap110(int cs110Position) {
        if (unitCapItems != null){
            unitCap110.setText("" + unitCapItems[cs110Position]);
        }
    }

    private void setUnitCap35Items(int position, int rv35Position) {
        if (rv35Position == 0){
            unitCap35.setText(getResources().getStringArray(R.array.unitCap35_array21)[position]);
        }else if (rv35Position == 1){
            unitCap35.setText(getResources().getStringArray(R.array.unitCap35_array26)[position]);
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setItems(msg.what);
            switch (msg.what){
                case 0:
                    t10KV.setBackgroundColor(Color.parseColor("#E0FFFF"));
                    t35KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t110KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t220KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    break;

                case 1:
                    t10KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t35KV.setBackgroundColor(Color.parseColor("#E0FFFF"));
                    t110KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t220KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    break;

                case 2:
                    t10KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t35KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t110KV.setBackgroundColor(Color.parseColor("#E0FFFF"));
                    t220KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    break;

                case 3:
                    t10KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t35KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t110KV.setBackgroundColor(Color.parseColor("#EBEBEB"));
                    t220KV.setBackgroundColor(Color.parseColor("#E0FFFF"));
                    break;
                default:
                    break;
            }
        }
    };

    private void setItems(int position) {
        if (position == 0){
            rvItems = getResources().getStringArray(R.array.rv10_array);
            rvAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rvItems);
            rv10Spinner.setAdapter(rvAdapter);
            rv10Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    setUnitCapItems(position,rv10Position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }else if (position == 1){
            rvItems = getResources().getStringArray(R.array.rv35_array);
            rvAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rvItems);
            rv35Spinner.setAdapter(rvAdapter);
        }else if (position == 2){
            csItems = getResources().getStringArray(R.array.cs110_array);
            csAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, csItems);
            csSpinner110.setAdapter(csAdapter);

            ratedVoltage110.setText("64");
            DRSR110.setText("327.8");
            unitCapItems = getResources().getStringArray(R.array.unitCap110_array);

            IsrItems = getResources().getStringArray(R.array.Isr_array110);
            IsrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, IsrItems);
            Isr110.setAdapter(IsrAdapter);

            reactorItems = getResources().getStringArray(R.array.ReactorConnMode110_array);
            ReactorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, reactorItems);
            ReactorConnMode110.setAdapter(ReactorAdapter);
        }else if (position == 3){
            csItems = getResources().getStringArray(R.array.cs220_array);
            csAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, csItems);
            csSpinner220.setAdapter(csAdapter);

            ratedVoltage220.setText("128");
            unitCapItems = getResources().getStringArray(R.array.unitCap220_array);

            IsrItems = getResources().getStringArray(R.array.Isr_array220);
            IsrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, IsrItems);
            Isr220.setAdapter(IsrAdapter);

            reactorItems = getResources().getStringArray(R.array.ReactorConnMode220_array);
            ReactorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, reactorItems);
            ReactorConnMode220.setAdapter(ReactorAdapter);
        }

    }

    private void setUnitCapItems(int position, int rv10Position) {
        if (rv10Position == 0){
            unitCap10.setText(getResources().getStringArray(R.array.unitCap6_array)[position]);
        }else if (rv10Position ==1){
            unitCap10.setText(getResources().getStringArray(R.array.unitCap8_array)[position]);
        }
    }

    double esl; //等效电感
    double maxLen; //电缆最大长度
    double capa; //电缆容量
    double fre; //谐振频率
    double edr; //电抗器等效直阻
    double hv; //高压一次电流
    float rv; //额定电压
    int evhv; //励磁变高压抽头
    int evlv;
    double testCapa; //所需试验容量
    double qValue; //Q值
    double evr; //励磁变变比
    double inCurrent; //励磁变输入电流
    double outVoltage; //励磁变输出电压
    double inVoltage;// 励磁变输入电压
    double pCapa; //电源容量
    double piCurrent; //电源测输入电流
    double fc; //变频电源容量
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.c_transform:
                if (TextUtils.isEmpty(cableLength10.getInput())){
                    Toast.makeText(this, "请输入电缆实际长度！", Toast.LENGTH_SHORT).show();
                }else {
                    resultTransform10.setVisibility(View.VISIBLE);

                    if (reactor10Position == 0){
                        esl =  45.49;
                        edr = 250.7;
                    }else if (reactor10Position == 1){
                        esl = 45.49 * 3;
                        edr = 250.7 * 3;
                    }

                    if (evhvPosition ==0){
                        evhv = 2400;
                    }else if (evhvPosition == 1){
                        evhv = 1200;
                    }
                    maxLen = 1 / (39.4784 * 30 * 30 * esl * Double.parseDouble(unitCap10.getText().toString()) * 0.000001);
                    ESL10.setText("" + esl);
                    capa = Double.parseDouble(unitCap10.getText().toString()) * Double.parseDouble(cableLength10.getInput().toString());
                    fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
                    hv = 2 * Double.parseDouble(rvItems[rv10Position]) * 1000 * fre * capa * 0.000001*2*3.14;
                    testCapa = Math.pow(2 * Double.parseDouble(rvItems[rv10Position]) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
                    qValue = fre * 2 * 3.14 * esl / edr;
                    evr = evhv / 200;
                    inCurrent = hv * evr;
                    outVoltage = edr * hv;
                    inVoltage = outVoltage / evr ;
                    pCapa = inCurrent * inVoltage * 0.001;
                    piCurrent = pCapa / Math.sqrt(3) / 380 * 1000;
                    fc = Math.sqrt(3) * 380 * piCurrent * 0.001;
                    cableMaxLen10.setText("" + maxLen);
                    cableCapa10.setText("" + capa);
                    frequence10.setText("" + fre);
                    EDR10.setText("" + edr);
                    hvCurrent10.setText("" + hv);
                    EVHV10.setText("" + evhv);
                    EVLV10.setText("200");
                    testCapa10.setText("" + testCapa);
                    Qvalue10.setText("" + qValue);
                    EVR10.setText("" + evr);
                    InCurrent10.setText("" + inCurrent);
                    OutVoltage10.setText("" + outVoltage);
                    InVoltage10.setText("" + inVoltage);
                    powerCapa10.setText("" + pCapa);
                    powerInCurrent10.setText("" +piCurrent);
                    fcPowerCapa10.setText("" + fc);
                }
                break;

            case R.id.cable_transform:
                if (TextUtils.isEmpty(cableLength110.getInput())){
                    Toast.makeText(this, "请输入电缆实际长度！", Toast.LENGTH_SHORT).show();
                }else {
                    resultTransform110.setVisibility(View.VISIBLE);
                    if (reactor110Position == 0){
                        esl = 142;
                        edr = Double.parseDouble(DRSR110.getText().toString());
                    }else if (reactor110Position == 1){
                        esl = 142 / 2;
                        edr = Double.parseDouble(DRSR110.getText().toString()) / 2;
                    }

                    maxLen = 1 / (39.4784 * 30 * 30 * esl * Double.parseDouble(unitCap110.getText().toString()) * 0.000001);
                    capa = Double.parseDouble(unitCap110.getText().toString()) * Double.parseDouble(cableLength110.getInput().toString());
                    fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
                    hv = 2 * Double.parseDouble(ratedVoltage110.getText().toString()) * 1000 * fre * capa * 0.000001*2*3.14;
                    evhv = Integer.parseInt(getResources().getStringArray(R.array.Evhvt_array)[evhv110Position]);
                    evlv = Integer.parseInt(getResources().getStringArray(R.array.Evlvt_array)[evlv110Position]);
                    testCapa = Math.pow(2 * Double.parseDouble(ratedVoltage110.getText().toString()) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
                    qValue = fre * 2 * 3.14 * esl / edr;
                    evr = (double)evhv /evlv;
                    inCurrent = hv * evr;
                    outVoltage = edr * hv;
                    inVoltage = outVoltage / evr;
                    pCapa = inCurrent * inVoltage * 0.001;
                    piCurrent = pCapa / Math.sqrt(3) / 380 * 1000;
                    fc = Math.sqrt(3) * 380 * piCurrent * 0.001;
                    ESL110.setText("" + esl);
                    cableMaxLen110.setText("" + maxLen);
                    cableCapa110.setText("" + capa);
                    frequence110.setText("" + fre);
                    EDR110.setText("" + edr);
                    hvCurrent110.setText("" + hv);
                    EVHV110.setText("" + evhv);
                    EVLV110.setText("" + evlv);
                    testCapa110.setText("" + testCapa);
                    Qvalue110.setText("" + qValue);
                    EVR110.setText("" + evr);
                    InCurrent110.setText("" + inCurrent);
                    OutVoltage110.setText("" + outVoltage);
                    InVoltage110.setText("" + inVoltage);
                    powerCapa110.setText("" + pCapa);
                    powerInCurrent110.setText("" + piCurrent);
                    fcPowerCapa110.setText("" + fc);
                }
                break;

            default:
                break;
        }
    }

    private void displayResultTransform() {
        if (TextUtils.isEmpty(cableLength220.getInput())){
            Toast.makeText(this, "请输入电缆实际长度！", Toast.LENGTH_SHORT).show();
        }else {
            resultTransform220.setVisibility(View.VISIBLE);
            if (reactor220Postion == 0){
                esl = Integer.parseInt(IsrItems[isr220Position]);
                edr = Double.parseDouble(DRSR220.getText().toString());
            }else if (reactor220Postion == 1){
                esl = Integer.parseInt(IsrItems[isr220Position]) * 2;
                edr = Double.parseDouble(DRSR220.getText().toString()) * 2;
            }
            double aa= Double.parseDouble(unitCap220.getText().toString());
            maxLen = 1 / (39.4784 * 30 * 30 * esl * aa * 0.000001);
            capa = Double.parseDouble(unitCap220.getText().toString()) * Double.parseDouble(cableLength220.getInput().toString());
            fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
            hv = 2 * Double.parseDouble(ratedVoltage220.getText().toString()) * 1000 * fre * capa * 0.000001*2*3.14;
            evhv = Integer.parseInt(getResources().getStringArray(R.array.Evhvt_array)[evhv220Position]);
            evlv = Integer.parseInt(getResources().getStringArray(R.array.Evlvt_array)[evlv220Position]);
            testCapa = Math.pow(2 * Double.parseDouble(ratedVoltage220.getText().toString()) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
            qValue = fre * 2 * 3.14 * esl / edr;
            evr = (double) evhv /evlv;
            inCurrent = hv * evr;
            outVoltage = edr * hv;
            inVoltage = outVoltage / evr;
            pCapa = inCurrent * inVoltage * 0.001;
            piCurrent = pCapa / Math.sqrt(3) / 380 * 1000;
            fc = Math.sqrt(3) * 380 * piCurrent * 0.001;
            ESL220.setText("" + esl);
            cableMaxLen220.setText("" + maxLen);
            cableCapa220.setText("" + capa);
            EDR220.setText("" + edr);
            hvCurrent220.setText("" + hv);
            frequence220.setText("" + fre);
            EVHV220.setText("" + evhv);
            EVLV220.setText("" + evlv);
            testCapa220.setText("" + testCapa);
            Qvalue220.setText("" + qValue);
            EVR220.setText("" + evr);
            InCurrent220.setText("" + inCurrent);
            OutVoltage220.setText("" + outVoltage);
            InVoltage220.setText("" + inVoltage);
            powerCapa220.setText("" + pCapa);
            powerInCurrent220.setText("" + piCurrent);
            fcPowerCapa220.setText("" + fc);
        }

    }

    private void clickProcess35() {
        if (TextUtils.isEmpty(cableLength35.getInput())){
            Toast.makeText(this, "请输入电缆实际长度！", Toast.LENGTH_SHORT).show();
        }else {
            resultTransform35.setVisibility(View.VISIBLE);
            if (reactor35Position == 0){
                esl = 45.49;
                edr = 250.7;
            }else if (reactor35Position == 1){
                esl = 45.49 / 2;
                edr = 250.7 / 2;
            }else if (reactor35Position == 2){
                esl = 45.49 / 3;
                edr = 250.7 / 3;
            }else if (reactor35Position == 3){
                esl = 45.49 /4;
                edr = 250.7 / 4;
            }
            if (evhv35Position == 0){
                evhv = 2400;
            }else if (evhv35Position == 1){
                evhv = 1200;
            }
            maxLen = 1 / (39.4784 * 30 * 30 * esl * Double.parseDouble(unitCap35.getText().toString()) * 0.000001);
            capa = Double.parseDouble(unitCap35.getText().toString()) * Double.parseDouble(cableLength35.getInput().toString());
            fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
            hv = 2 * Double.parseDouble(rvItems[rv10Position]) * 1000 * fre * capa * 0.000001*2*3.14;
            testCapa = Math.pow(2 * Double.parseDouble(rvItems[rv35Position]) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
            qValue = fre * 2 * 3.14 * esl / edr;
            evr = evhv / 200;
            inCurrent = hv * evr;
            outVoltage = edr * hv;
            inVoltage = outVoltage / evr ;
            pCapa = inCurrent * inVoltage * 0.001;
            piCurrent = pCapa / Math.sqrt(3) / 380 * 1000;
            fc = Math.sqrt(3) * 380 * piCurrent * 0.001;
            ESL35.setText("" + esl);
            cableMaxLen35.setText("" + maxLen);
            cableCapa35.setText("" + capa);
            frequence35.setText("" + fre);
            EDR35.setText("" + edr);
            hvCurrent35.setText("" + hv);
            EVHV35.setText("" + evhv);
            EVLV35.setText("200");
            testCapa35.setText("" + testCapa);
            Qvalue35.setText("" + qValue);
            EVR35.setText("" + evr);
            InCurrent35.setText("" + inCurrent);
            OutVoltage35.setText("" + outVoltage);
            InVoltage35.setText("" + inVoltage);
            powerCapa35.setText("" + pCapa);
            powerInCurrent35.setText("" +piCurrent);
            fcPowerCapa35.setText("" + fc);
        }
    }

    public int getPosition(int position) {
        return position;
    }
}
