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

public class Page35KV extends Fragment implements View.OnClickListener {
    private LinearLayout resultTransform35;
    private Spinner cs35Spinner;
    private Spinner rv35Spinner;
    private Spinner reactor35Spinner;
    private Button c35Transform;
    private MyEditText cableLength35;
    private MyEditText UnitCap35;
    private MyEditText ReactorInduc35;
    private MyEditText IOSR35;
    private MyEditText tEVHV35;
    private MyEditText tEVLV35;
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
    
    private ArrayAdapter<String> rAdapter35;
    private String[] rItems35;
    private String[] uItems35;//单位电容量
    private ArrayAdapter<String> uAdapter35;
    private int rv35Position = 0;
    private int reactor35Position = 0;
    private String[] mItems;
    private ArrayAdapter<String> adapter;
    private String[] rvItems;
    private ArrayAdapter<String> rvAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View page35KV = inflater.inflate(R.layout.page_35kv, null);
        initView(page35KV);
        return page35KV;
    }

    private void initView(View page35KV) {
        rvItems = getResources().getStringArray(R.array.rv35_array);
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
        rvAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, rvItems);
        rv35Spinner.setAdapter(rvAdapter);
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
        rAdapter35 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, rItems35);
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
        cableLength35 = (MyEditText) page35KV.findViewById(R.id.cable_len);
        UnitCap35 = (MyEditText) page35KV.findViewById(R.id.t_unitCap);
        ReactorInduc35 = (MyEditText) page35KV.findViewById(R.id.reactor_induc);
        ReactorInduc35.setInput("45.49");
        IOSR35 = (MyEditText) page35KV.findViewById(R.id.tIOSR);
        IOSR35.setInput("250.7");
        tEVHV35 = (MyEditText) page35KV.findViewById(R.id.tEVHV);
        tEVLV35 = (MyEditText) page35KV.findViewById(R.id.tEVLV);
        ESL35 = (TextView) page35KV.findViewById(R.id.ESL);
        cableMaxLen35 = (TextView) page35KV.findViewById(R.id.max_len);
        cableCapa35 = (TextView) page35KV.findViewById(R.id.cable_capa);
        frequence35 = (TextView) page35KV.findViewById(R.id.frequency);
        EDR35 = (TextView) page35KV.findViewById(R.id.EDR);
        hvCurrent35 = (TextView) page35KV.findViewById(R.id.hv_current);
        EVHV35 = (TextView) page35KV.findViewById(R.id.EVHV);
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
        c35Transform.setOnClickListener(this);
    }



    private void set35CsItmes(int position) {
        mItems = getResources().getStringArray(R.array.cs35_array);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mItems);
        cs35Spinner.setAdapter(adapter);
    }

    private void setUnitCap35Items(int position, int rv35Position) {
        if (rv35Position == 0){
            UnitCap35.setInput(getResources().getStringArray(R.array.unitCap35_array21)[position]);
        }else if (rv35Position == 1){
            UnitCap35.setInput(getResources().getStringArray(R.array.unitCap35_array26)[position]);
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
                if (TextUtils.isEmpty(cableLength35.getInput())|| TextUtils.isEmpty(tEVHV35.getInput()) || TextUtils.isEmpty(tEVLV35.getInput())){
                    Toast.makeText(getActivity(), "请输入数据！", Toast.LENGTH_SHORT).show();
                }else {
                    resultTransform35.setVisibility(View.VISIBLE);
                    if (reactor35Position == 0){
                        esl =  Double.parseDouble(ReactorInduc35.getInput());
                        edr = Double.parseDouble(IOSR35.getInput());
                    }else if (reactor35Position == 1){
                        esl = Double.parseDouble(ReactorInduc35.getInput()) * 3;
                        edr = Double.parseDouble(IOSR35.getInput()) * 3;
                    }
                    evhv = Double.parseDouble(tEVHV35.getInput());
                    evlv = Double.parseDouble(tEVLV35.getInput());
                    maxLen = 1 / (39.4784 * 30 * 30 * esl * Double.parseDouble(UnitCap35.getInput()) * 0.000001);
                    capa = Double.parseDouble(UnitCap35.getInput()) * Double.parseDouble(cableLength35.getInput().toString());
                    fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
                    hv = 2 * Double.parseDouble(rvItems[rv35Position]) * 1000 * fre * capa * 0.000001*2*3.14;
                    testCapa = Math.pow(2 * Double.parseDouble(rvItems[rv35Position]) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
                    qValue = fre * 2 * 3.14 * esl / edr;
                    evr = evhv / evlv;
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
                    EVLV35.setText("" + evlv);
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
                break;
        }
    }
}
