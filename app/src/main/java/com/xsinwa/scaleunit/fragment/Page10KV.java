package com.xsinwa.scaleunit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.ui.MyEditText;

/**
 * Created by Xsinwa on 2018/1/20.
 */

public class Page10KV extends Fragment implements View.OnClickListener {
    private LinearLayout resultTransform10;
    private Spinner rv10Spinner;
    private Spinner reactor10Spinner;
    private Spinner csSpinner;
    private Button c10Transform;
    private MyEditText cableLength10;
    private MyEditText UnitCap10;
    private MyEditText ReactorInduc10;
    private MyEditText IOSR10;
    private MyEditText tEVHV10;
    private MyEditText tEVLV10;
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

    private String[] rItems10;
    private String[] mItems;
    private String[] rvItems;
    private String[] uItems;//单位电容量
    private ArrayAdapter<String> rAdapter10;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> rvAdapter;
    private ArrayAdapter<String> uAdapter;
    private int rv10Position = 0;
    private int reactor10Position = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View Page10View = inflater.inflate(R.layout.page_10kv, null);
        initView(Page10View);
        return Page10View;
    }

    private void initView(View page10KV) {
        rvItems = getResources().getStringArray(R.array.rv10_array);
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
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mItems);
        csSpinner.setAdapter(adapter);
        rvItems = getResources().getStringArray(R.array.rv10_array);
        rvAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, rvItems);
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
        rAdapter10 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,rItems10);
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

        uItems = getResources().getStringArray(R.array.unitCap6_array);
        uAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, uItems);
        c10Transform = (Button) page10KV.findViewById(R.id.c_transform);
        c10Transform.setOnClickListener(this);
        cableLength10 = (MyEditText) page10KV.findViewById(R.id.cable_len);
        UnitCap10  = (MyEditText) page10KV.findViewById(R.id.t_unitCap);
        ReactorInduc10 = (MyEditText) page10KV.findViewById(R.id.reactor_induc);
        ReactorInduc10.setInput("45.49");
        IOSR10 = (MyEditText) page10KV.findViewById(R.id.tIOSR);
        IOSR10.setInput("250.7");
        tEVHV10 = (MyEditText) page10KV.findViewById(R.id.tEVHV);
        tEVLV10 = (MyEditText) page10KV.findViewById(R.id.tEVLV);
        ESL10 = (TextView) page10KV.findViewById(R.id.ESL);
        cableMaxLen10 = (TextView) page10KV.findViewById(R.id.max_len);
        cableCapa10 = (TextView) page10KV.findViewById(R.id.cable_capa);
        frequence10 = (TextView) page10KV.findViewById(R.id.frequency);
        EDR10 = (TextView) page10KV.findViewById(R.id.EDR);
        hvCurrent10 = (TextView) page10KV.findViewById(R.id.hv_current);
        EVHV10 = (TextView) page10KV.findViewById(R.id.EVHV);
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
    }

    private void setCsItems(int position) {
        if (position == 0){
            mItems = getResources().getStringArray(R.array.cs10_array6);
        }else if (position == 1){
            mItems = getResources().getStringArray(R.array.cs10_array8);
        }
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mItems);
        csSpinner.setAdapter(adapter);
    }

    private void setUnitCapItems(int position, int rv10Position) {
        if (rv10Position == 0){
            UnitCap10.setInput(getResources().getStringArray(R.array.unitCap6_array)[position]);
        }else if (rv10Position ==1){
            UnitCap10.setInput(getResources().getStringArray(R.array.unitCap8_array)[position]);
        }
    }

    double esl; //等效电感
    double maxLen; //电缆最大长度
    double capa; //电缆容量
    double fre; //谐振频率
    double edr; //电抗器等效直阻
    double hv; //高压一次电流
    float rv; //额定电压
    double evhv; //励磁变高压抽头
    double evlv;
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
           case R.id.c_transform:
               if (TextUtils.isEmpty(cableLength10.getInput()) || TextUtils.isEmpty(tEVHV10.getInput()) || TextUtils.isEmpty(tEVLV10.getInput())){
                   Toast.makeText(getActivity(), "请输入数据！", Toast.LENGTH_SHORT).show();
               }else {
                   resultTransform10.setVisibility(View.VISIBLE);
                   if (reactor10Position == 0){
                       esl = Double.parseDouble(ReactorInduc10.getInput());
                       edr = Double.parseDouble(IOSR10.getInput());
                   }else if (reactor10Position == 1){
                       esl = Double.parseDouble(ReactorInduc10.getInput()) / 2;
                       edr = Double.parseDouble(IOSR10.getInput()) / 2;
                   }else if (reactor10Position == 2){
                       esl = Double.parseDouble(ReactorInduc10.getInput()) / 3;
                       edr = Double.parseDouble(IOSR10.getInput()) / 3;
                   }else if (reactor10Position == 3){
                       esl = Double.parseDouble(ReactorInduc10.getInput()) /4;
                       edr = Double.parseDouble(IOSR10.getInput()) / 4;
                   }

                   evhv = Double.parseDouble(tEVHV10.getInput());
                   evlv = Double.parseDouble(tEVLV10.getInput());
                   maxLen = 1 / (39.4784 * 30 * 30 * esl * Double.parseDouble(UnitCap10.getInput()) * 0.000001);
                   ESL10.setText("" + esl);
                   capa = Double.parseDouble(UnitCap10.getInput()) * Double.parseDouble(cableLength10.getInput().toString());
                   fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
                   hv = 2 * Double.parseDouble(rvItems[rv10Position]) * 1000 * fre * capa * 0.000001*2*3.14;
                   testCapa = Math.pow(2 * Double.parseDouble(rvItems[rv10Position]) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
                   qValue = fre * 2 * 3.14 * esl / edr;
                   evr = evhv / evlv;
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
                   EVLV10.setText(evlv + "");
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
        }
    }
}
