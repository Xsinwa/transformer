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

public class Page110KV extends Fragment implements View.OnClickListener {
    private LinearLayout resultTransform110;
    private MyEditText ratedVoltage110;//额定电压
    private Spinner csSpinner110;
    private MyEditText unitCap110;//单位电容量
    private MyEditText DRSR110;//单台电抗器直阻
    private MyEditText Isr110; //电抗器电感
    private Spinner ReactorConnMode110; //电抗器连接方式
    private MyEditText tEVHV110;
    private MyEditText tEVLV110; //励磁变低压抽头
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

    private String[] csItems;
    private String[] IsrItems;
    private String[] unitCapItems;
    private String[] reactorItems;
    private ArrayAdapter<String> csAdapter;
    private ArrayAdapter<String> IsrAdapter;
    private ArrayAdapter<String> ReactorAdapter;
    private int reactor110Position = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View page110KV = inflater.inflate(R.layout.page_110kv, null);
        initView(page110KV);
        return page110KV;
    }

    private void initView(View page110KV) {
        csItems = getResources().getStringArray(R.array.cs110_array);
        unitCapItems = getResources().getStringArray(R.array.unitCap110_array);
        reactorItems = getResources().getStringArray(R.array.ReactorConnMode110_array);
        resultTransform110 = (LinearLayout) page110KV.findViewById(R.id.result_transform);
        resultTransform110.setVisibility(View.GONE);
        csSpinner110 = (Spinner) page110KV.findViewById(R.id.spinner_cs);
        csAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, csItems);
        csSpinner110.setAdapter(csAdapter);
        csSpinner110.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitCap110(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tEVHV110 = (MyEditText) page110KV.findViewById(R.id.Evhvt);
        tEVLV110 = (MyEditText) page110KV.findViewById(R.id.Evlvt);
        ratedVoltage110 = (MyEditText) page110KV.findViewById(R.id.rated_vol);
        ratedVoltage110.setInput("64");
        unitCap110 = (MyEditText) page110KV.findViewById(R.id.unitcap);
        DRSR110 = (MyEditText) page110KV.findViewById(R.id.drsr);
        DRSR110.setInput("327.8");
        Isr110 = (MyEditText) page110KV.findViewById(R.id.tISR);
        Isr110.setInput("142");
        ReactorConnMode110 = (Spinner) page110KV.findViewById(R.id.reactor_conn_mode);
        ReactorAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, reactorItems);
        ReactorConnMode110.setAdapter(ReactorAdapter);
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
    }

    private void setUnitCap110(int position) {
        if (unitCapItems != null){
            unitCap110.setInput("" + unitCapItems[position]);
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
            case R.id.cable_transform:
                if (TextUtils.isEmpty(cableLength110.getInput())|| TextUtils.isEmpty(Isr110.getInput()) || TextUtils.isEmpty(unitCap110.getInput())
                        || TextUtils.isEmpty(ratedVoltage110.getInput()) || TextUtils.isEmpty(DRSR110.getInput())
                        || TextUtils.isEmpty(tEVHV110.getInput())  || TextUtils.isEmpty(tEVLV110.getInput())){
                    Toast.makeText(getContext(), "请输入数据！", Toast.LENGTH_SHORT).show();
                }else {
                    resultTransform110.setVisibility(View.VISIBLE);
                    if (reactor110Position == 0){
                        esl = Double.parseDouble(Isr110.getInput());
                        edr = Double.parseDouble(DRSR110.getInput());
                    }else if (reactor110Position == 1){
                        esl = Double.parseDouble(Isr110.getInput()) / 2;
                        edr = Double.parseDouble(DRSR110.getInput()) / 2;
                    }

                    maxLen = 1 / (39.4784 * 30 * 30 * esl * Double.parseDouble(unitCap110.getInput()) * 0.000001);
                    capa = Double.parseDouble(unitCap110.getInput()) * Double.parseDouble(cableLength110.getInput().toString());
                    fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
                    hv = 2 * Double.parseDouble(ratedVoltage110.getInput()) * 1000 * fre * capa * 0.000001*2*3.14;
                    evhv = Double.parseDouble(tEVHV110.getInput());
                    evlv = Double.parseDouble(tEVLV110.getInput());
                    testCapa = Math.pow(2 * Double.parseDouble(ratedVoltage110.getInput()) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
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
        }
    }
}
