package com.xsinwa.scaleunit.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.adapter.TransformerAdapter;
import com.xsinwa.scaleunit.ui.CustomeItem;
import com.xsinwa.scaleunit.ui.MyEditText;

import java.util.ArrayList;
import java.util.List;

public class TransformerClass extends AppCompatActivity implements View.OnClickListener {
    private TextView topTitle;
    private LinearLayout Backward;

    private LinearLayout temperature;
    private LinearLayout connMode;

    private RadioGroup transMode;
    private RadioButton Drc;
    private RadioButton Bbrc;
    private RadioButton Trans;

    private RadioGroup windConnMode;
    private RadioButton YMode;
    private RadioButton TMode;

    private MyEditText tempT1;
    private MyEditText tempT2;

    private CustomeItem Item1;
    private CustomeItem Item2;
    private CustomeItem Item3;
    private CustomeItem Item4;
    private CustomeItem Item5;
    private CustomeItem Item6;
    private CustomeItem Item7;
    private CustomeItem Item8;
    private CustomeItem Item9;
    private CustomeItem Item10;
    private CustomeItem Item11;
    private CustomeItem Item12;
    private CustomeItem Item13;
    private CustomeItem Item14;
    private CustomeItem Item15;
    private CustomeItem Item16;
    private CustomeItem Item17;

    private List<CustomeItem> ItemList = new ArrayList<CustomeItem>();

    private Button Transformer;
    private int mCheckId;

    private String input;

    private String mInput1;
    private String mInput2;
    private String mInput3;

    private List<String> input1List = new ArrayList<String>();
    private List<String> input2List = new ArrayList<String>();
    private List<String> input3List = new ArrayList<String>();

    private static List<String> tempList1 = new ArrayList<String>();
    private static List<String> tempList2 = new ArrayList<String>();
    private static List<String> tempList3 = new ArrayList<String>();

    private List<String> output1List = new ArrayList<String>();
    private List<String> output2List = new ArrayList<String>();
    private List<String> output3List = new ArrayList<String>();
    private List<String> outputList = new ArrayList<String>();
    private int flag1;
    private int flag2;
    private int flag3;
    private int connCheckId;
    private static int list1;
    private static int list2;
    private static int list3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformer);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
    }

    private void initView() {
        topTitle = (TextView) findViewById(R.id.top_title);
        topTitle.setText("数据输入");

        Backward = (LinearLayout) findViewById(R.id.backward);
        Backward.setOnClickListener(this);

        temperature = (LinearLayout) findViewById(R.id.temperature);
        connMode = (LinearLayout) findViewById(R.id.conn_mode);

        transMode = (RadioGroup) findViewById(R.id.trans_mode);
        transMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mCheckId = checkedId;
                setTempVisibility(checkedId);
            }
        });
        Drc = (RadioButton) findViewById(R.id.Drc);
        Drc.setChecked(true);
        Bbrc = (RadioButton) findViewById(R.id.Bbrc);
        Trans = (RadioButton) findViewById(R.id.trans);

        windConnMode = (RadioGroup) findViewById(R.id.wind_conn_mode);
        windConnMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                connCheckId = checkedId;
            }
        });
        YMode = (RadioButton) findViewById(R.id.YMode);
        YMode.setChecked(true);
        TMode = (RadioButton) findViewById(R.id.TMode);

        tempT1 = (MyEditText) findViewById(R.id.input_T1);
        tempT2 = (MyEditText) findViewById(R.id.input_T2);


        Transformer = (Button) findViewById(R.id.transformer);
        Transformer.setOnClickListener(this);

        Item1 = (CustomeItem) findViewById(R.id.item1);
        Item1.setNumber("1");
        Item2 = (CustomeItem) findViewById(R.id.item2);
        Item2.setNumber("2");
        Item3 = (CustomeItem) findViewById(R.id.item3);
        Item3.setNumber("3");
        Item4 = (CustomeItem) findViewById(R.id.item4);
        Item4.setNumber("4");
        Item5 = (CustomeItem) findViewById(R.id.item5);
        Item5.setNumber("5");
        Item6 = (CustomeItem) findViewById(R.id.item6);
        Item6.setNumber("6");
        Item7 = (CustomeItem) findViewById(R.id.item7);
        Item7.setNumber("7");
        Item8 = (CustomeItem) findViewById(R.id.item8);
        Item8.setNumber("8");
        Item9 = (CustomeItem) findViewById(R.id.item9);
        Item9.setNumber("9");
        Item10 = (CustomeItem) findViewById(R.id.item10);
        Item10.setNumber("10");
        Item11 = (CustomeItem) findViewById(R.id.item11);
        Item11.setNumber("11");
        Item12 = (CustomeItem) findViewById(R.id.item12);
        Item12.setNumber("12");
        Item13 = (CustomeItem) findViewById(R.id.item13);
        Item13.setNumber("13");
        Item14 = (CustomeItem) findViewById(R.id.item14);
        Item14.setNumber("14");
        Item15 = (CustomeItem) findViewById(R.id.item15);
        Item15.setNumber("15");
        Item16 = (CustomeItem) findViewById(R.id.item16);
        Item16.setNumber("16");
        Item17 = (CustomeItem) findViewById(R.id.item17);
        Item17.setNumber("17");

        ItemList.add(0, Item1);
        ItemList.add(1, Item2);
        ItemList.add(2, Item3);
        ItemList.add(3, Item4);
        ItemList.add(4, Item5);
        ItemList.add(5, Item6);
        ItemList.add(6, Item7);
        ItemList.add(7, Item8);
        ItemList.add(8, Item9);
        ItemList.add(9, Item10);
        ItemList.add(10, Item11);
        ItemList.add(11, Item12);
        ItemList.add(12, Item13);
        ItemList.add(13, Item14);
        ItemList.add(14, Item15);
        ItemList.add(15, Item16);
        ItemList.add(16, Item17);
    }

    private void setTempVisibility(int checkedId) {
        if (checkedId == R.id.Drc){
            temperature.setVisibility(View.VISIBLE);
            connMode.setVisibility(View.GONE);
        }else if (checkedId == R.id.Bbrc){
            temperature.setVisibility(View.GONE);
            connMode.setVisibility(View.GONE);
        }else if (checkedId == R.id.trans){
            temperature.setVisibility(View.GONE);
            connMode.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
//        setInput1List(flag1);
//        setInput2List(flag2);
//        setInput3List(flag3);
//        getRealSize();

        getData();
        setTempList(input1List, input2List, input3List);
        switch(v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.transformer:
                if (!isOrderInput()){
                    Toast.makeText(this, "请按顺序输入！", Toast.LENGTH_SHORT).show();
                }else {
                    getRealSize();
                    if (mCheckId == R.id.Drc) {
                        if (TextUtils.isEmpty(input) || TextUtils.isEmpty(tempT1.getInput()) || TextUtils.isEmpty(tempT2.getInput())) {
                            Toast.makeText(this, "请输入数据！", Toast.LENGTH_SHORT).show();
                        } else {
                            for (int i = 0; i < list1; i++) {
                                if (!TextUtils.isEmpty(tempList1.get(i))) {
                                    double ab = (Double.parseDouble(tempT2.getInput().toString()) + 235) / (Double.parseDouble(tempT1.getInput().toString()) + 235) * Double.parseDouble(tempList1.get(i));
                                    output1List.add(ab + "");
                                }
                            }
                            for (int i = 0; i < list2; i++) {
                                if (!TextUtils.isEmpty(tempList2.get(i))) {
                                    double bc = (Double.parseDouble(tempT2.getInput().toString()) + 235) / (Double.parseDouble(tempT1.getInput().toString()) + 235) * Double.parseDouble(tempList2.get(i));
                                    output2List.add(bc + "");
                                }
                            }
                            for (int i = 0; i < list3; i++) {
                                if (!TextUtils.isEmpty(tempList3.get(i))) {
                                    double ca = (Double.parseDouble(tempT2.getInput().toString()) + 235) / (Double.parseDouble(tempT1.getInput().toString()) + 235) * Double.parseDouble(tempList3.get(i));
                                    output3List.add(ca + "");
                                }
                            }
                            intent = new Intent(this, DrcTransActivity.class);
                            intent.putStringArrayListExtra("output1", (ArrayList<String>) output1List);
                            intent.putStringArrayListExtra("output2", (ArrayList<String>) output2List);
                            intent.putStringArrayListExtra("output3", (ArrayList<String>) output3List);
                            startActivity(intent);
                        }
                    } else if (mCheckId == R.id.Bbrc) {
                        int minSize = Math.min(Math.min(list1, list2), Math.min(list1, list3));
                        if (minSize == 0) {
                            Toast.makeText(this, "请输入数据！", Toast.LENGTH_SHORT).show();
                        } else {
                            for (int i = 0; i < minSize; i++) {
                                double max1 = Math.max(Double.parseDouble(tempList1.get(i).toString()), Double.parseDouble(tempList2.get(i).toString()));
                                double max2 = Math.max(Double.parseDouble(tempList1.get(i).toString()), Double.parseDouble(tempList3.get(i).toString()));
                                double min1 = Math.min(Double.parseDouble(tempList1.get(i).toString()), Double.parseDouble(tempList2.get(i).toString()));
                                double min2 = Math.min(Double.parseDouble(tempList1.get(i).toString()), Double.parseDouble(tempList3.get(i).toString()));
                                double max = Math.max(max1, max2);
                                double min = Math.min(min1, min2);
                                double aver = (Double.parseDouble(tempList1.get(i).toString()) + Double.parseDouble(tempList2.get(i).toString()) + Double.parseDouble(tempList3.get(i).toString())) / 3;
                                double result = (max - min) / aver;
                                outputList.add(result + "");
                            }
                            intent = new Intent(this, BbrcTransActivity.class);
                            intent.putStringArrayListExtra("output", (ArrayList<String>) outputList);
                            startActivity(intent);
                        }

                    } else if (mCheckId == R.id.trans) {
                        int minSize = Math.min(Math.min(list1, list2), Math.min(list1, list3));
                        if (minSize == 0) {
                            Toast.makeText(this, "请输入数据！", Toast.LENGTH_SHORT).show();
                        } else {
                            if (connCheckId == R.id.YMode) {
                                for (int i = 0; i < minSize; i++) {
                                    double ab = Double.parseDouble(tempList1.get(i));
                                    double bc = Double.parseDouble(tempList2.get(i));
                                    double ca = Double.parseDouble(tempList3.get(i));
                                    double Ra = (ab + ca - bc) / 2;
                                    double Rb = (ab + bc - ca) / 2;
                                    double Rc = (bc + ca - ab) / 2;
                                    output1List.add(Ra + "");
                                    output2List.add(Rb + "");
                                    output3List.add(Rc + "");
                                }

                            } else if (connCheckId == R.id.TMode) {
                                for (int i = 0; i < minSize; i++) {
                                    double ab = Double.parseDouble(tempList1.get(i));
                                    double bc = Double.parseDouble(tempList2.get(i));
                                    double ca = Double.parseDouble(tempList3.get(i));
                                    double Ra = (ca - (ab + bc + ca) / 2) - ab * bc / (ca - (ab + bc + ca) / 2);
                                    double Rb = (ab - (ab + bc + ca) / 2) - ca * bc / (ab - (ab + bc + ca) / 2);
                                    double Rc = (bc - (ab + bc + ca) / 2) - ca * ab / (bc - (ab + bc + ca) / 2);
                                    output1List.add(Ra + "");
                                    output2List.add(Rb + "");
                                    output3List.add(Rc + "");
                                }
                            }
                            intent = new Intent(this, TTransActivity.class);
                            intent.putStringArrayListExtra("output1", (ArrayList<String>) output1List);
                            intent.putStringArrayListExtra("output2", (ArrayList<String>) output2List);
                            intent.putStringArrayListExtra("output3", (ArrayList<String>) output3List);
                            startActivity(intent);
                        }
                    }
                }
                break;

            default:
                break;
        }
    }

    private void getData() {
        input1List.clear();
        input2List.clear();
        input3List.clear();
        output1List.clear();
        output2List.clear();
        output3List.clear();
        outputList.clear();
        for (int i = 0; i < ItemList.size(); i++){
            if (i == 0)
                input = ItemList.get(i).getRab();
            if (!TextUtils.isEmpty(ItemList.get(i).getRab())){
                input1List.add(i, ItemList.get(i).getRab());
            }else {
                input1List.add(i, "");
            }
            if (!TextUtils.isEmpty(ItemList.get(i).getRbc())){
                input2List.add(i, ItemList.get(i).getRbc());
            }else {
                input2List.add(i, "");
            }
            if (!TextUtils.isEmpty(ItemList.get(i).getRca())){
                input3List.add(i, ItemList.get(i).getRca());
            }else {
                input3List.add(i, "");
            }
        }
    }

    public Boolean isOrderInput(){
        boolean flag = true;
        for (int i = 0; i < tempList1.size()-1; i++){
            if (TextUtils.isEmpty(tempList1.get(i)) && !TextUtils.isEmpty(tempList1.get(i + 1))){
                flag = false;
                break;
            }
        }

        for (int i = 0; i < tempList2.size()-1; i++){
            if (TextUtils.isEmpty(tempList2.get(i)) && !TextUtils.isEmpty(tempList2.get(i + 1))){
                flag = false;
                break;
            }
        }

        for (int i = 0; i < tempList3.size()-1; i++){
            if (TextUtils.isEmpty(tempList3.get(i)) && !TextUtils.isEmpty(tempList3.get(i + 1))){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void setTempList(List<String> input1List, List<String> input2List, List<String> input3List) {
        if (input1List.size() >0 ){
            tempList1 = input1List;
        }
        if (input2List.size() > 0) {
            tempList2 = input2List;
        }
        if (input3List.size() > 0) {
            tempList3 = input3List;
        }
    }

    private void getRealSize() {
        for (int i = 0; i < tempList1.size(); i++){
            if (TextUtils.isEmpty(tempList1.get(i))) {
                list1 = i;
                break;
            }else {
                list1++;
            }
        }
        for (int i = 0; i < tempList2.size(); i++){
            if (TextUtils.isEmpty(tempList2.get(i))) {
                list2 = i;
                break;
            }else {
                list2++;
            }
        }
        for (int i = 0; i < tempList3.size(); i++){
            if (TextUtils.isEmpty(tempList3.get(i))) {
                list3 = i;
                break;
            }else {
                list3++;
            }
        }
    }

//    @Override
//    public void onInputOneFill(int position, String s) {
//        try{
//            if (position == 0){
//                input = s;
//            }
//            input1List.add(position, s);
//            flag1 = position;
//            Transformer.setClickable(true);
//        }catch (Exception e){
//            Toast.makeText(this, "请按顺序输入！", Toast.LENGTH_SHORT).show();
//            Transformer.setClickable(false);
//        }
//    }
//
//    @Override
//    public void onInputTwoFill(int position, String s) {
//        try {
//            input2List.add(position, s);
//            flag2 = position;
//        }catch (Exception e){
//            Toast.makeText(this, "请按顺序输入！", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onInputThreeFill(int position, String s) {
//        try{
//
//            input3List.add(position, s);
//            flag3 = position;
//        }catch (Exception e){
//            Toast.makeText(this, "请按顺序输入！", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void setInput1List(int position) {
//        for (int i = position + 1; i < input1List.size(); i++){
//            input1List.set(i, "");
//        }
//    }
//
//    public void setInput2List(int position) {
//        for (int i = position + 1; i < input2List.size(); i++){
//            input2List.set(i, "");
//        }
//    }
//
//    public void setInput3List(int position) {
//        for (int i = position + 1; i < input3List.size(); i++){
//            input3List.set(i, "");
//        }
//    }

    @Override
    protected void onResume() {
        if (tempList1.size() >0){
            for (int i =0; i < tempList1.size(); i++){
                ItemList.get(i).setRab(tempList1.get(i));
            }
        }
        if (tempList2.size() >0){
            for (int i =0; i < tempList2.size(); i++){
                ItemList.get(i).setRbc(tempList2.get(i));
            }
        }
        if (tempList3.size() >0){
            for (int i =0; i < tempList3.size(); i++){
                ItemList.get(i).setRca(tempList3.get(i));
            }
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
//        Log.d("Trans","here");
//        tempList1.clear();
//        tempList2.clear();
//        tempList3.clear();
        super.onDestroy();
    }
}
