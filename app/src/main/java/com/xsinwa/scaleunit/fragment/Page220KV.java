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

public class Page220KV extends Fragment implements View.OnClickListener {
    private LinearLayout resultTransform220;
    private Spinner csSpinner220;
    private MyEditText ratedVoltage220;
    private MyEditText unitCap220;
    private MyEditText DRSR220;//单台电抗器直阻
    private MyEditText Isr220;//电抗器电感
    private Spinner ReactorConnMode220; //电抗器连接方式
    private MyEditText tEVHV220;
    private MyEditText tEVLV220; //励磁变低压抽头
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

    private String[] csItems;
    private int reactor220Postion = 0;
    private String[] unitCapItems;
    private ArrayAdapter<String> csAdapter;
    private String[] reactorItems;
    private ArrayAdapter<String> ReactorAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View page220KV = inflater.inflate(R.layout.page_220kv, null);
        initView(page220KV);
        return page220KV;
    }

    private void initView(View page220KV) {
        csItems = getResources().getStringArray(R.array.cs220_array);
        unitCapItems = getResources().getStringArray(R.array.unitCap220_array);

        reactorItems = getResources().getStringArray(R.array.ReactorConnMode220_array);
        resultTransform220 = (LinearLayout) page220KV.findViewById(R.id.result_transform);
        resultTransform220.setVisibility(View.GONE);
        csSpinner220 = (Spinner) page220KV.findViewById(R.id.spinner_cs);
        csAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, csItems);
        csSpinner220.setAdapter(csAdapter);
        csSpinner220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitCap220(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ratedVoltage220 = (MyEditText) page220KV.findViewById(R.id.rated_vol);
        ratedVoltage220.setInput("128");
        unitCap220 = (MyEditText) page220KV.findViewById(R.id.unitcap);
        DRSR220 = (MyEditText) page220KV.findViewById(R.id.drsr);
        DRSR220.setInput("327.8");
        Isr220 = (MyEditText) page220KV.findViewById(R.id.tISR);
        Isr220.setInput("142");
        ReactorConnMode220 = (Spinner) page220KV.findViewById(R.id.reactor_conn_mode);
        ReactorAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, reactorItems);
        ReactorConnMode220.setAdapter(ReactorAdapter);
        ReactorConnMode220.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reactor220Postion = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tEVHV220 = (MyEditText) page220KV.findViewById(R.id.Evhvt);
        tEVLV220 = (MyEditText) page220KV.findViewById(R.id.Evlvt);
        c220Transform = (Button) page220KV.findViewById(R.id.cable_transform);
        c220Transform.setOnClickListener(this);
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

    private void setUnitCap220(int position) {
        if (unitCapItems != null){
            unitCap220.setInput("" + unitCapItems[position]);
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
                if (TextUtils.isEmpty(cableLength220.getInput())|| TextUtils.isEmpty(Isr220.getInput()) || TextUtils.isEmpty(unitCap220.getInput())
                        || TextUtils.isEmpty(ratedVoltage220.getInput()) || TextUtils.isEmpty(DRSR220.getInput())
                        || TextUtils.isEmpty(tEVHV220.getInput())  || TextUtils.isEmpty(tEVLV220.getInput())){
                    Toast.makeText(getActivity(), "请输入数据！", Toast.LENGTH_SHORT).show();
                }else {
                    resultTransform220.setVisibility(View.VISIBLE);
                    if (reactor220Postion == 0){
                        esl = Double.parseDouble(Isr220.getInput());
                        edr = Double.parseDouble(DRSR220.getInput());
                    }else if (reactor220Postion == 1){
                        esl = Double.parseDouble(Isr220.getInput()) * 2;
                        edr = Double.parseDouble(DRSR220.getInput()) * 2;
                    }
                    double aa= Double.parseDouble(unitCap220.getInput());
                    maxLen = 1 / (39.4784 * 30 * 30 * esl * aa * 0.000001);
                    capa = Double.parseDouble(unitCap220.getInput()) * Double.parseDouble(cableLength220.getInput().toString());
                    fre = 1 / (2 * 3.14 * Math.sqrt(esl * capa * 0.000001));
                    hv = 2 * Double.parseDouble(ratedVoltage220.getInput()) * 1000 * fre * capa * 0.000001*2*3.14;
                    evhv = Double.parseDouble(tEVHV220.getInput());
                    evlv = Double.parseDouble(tEVLV220.getInput());
                    testCapa = Math.pow(2 * Double.parseDouble(ratedVoltage220.getInput()) * 1000, 2) * fre * capa * 0.000001 * 0.001 * 2 * 3.14;
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
                break;
        }
    }
}
