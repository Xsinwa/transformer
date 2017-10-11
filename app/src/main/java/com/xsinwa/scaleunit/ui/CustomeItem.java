package com.xsinwa.scaleunit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xsinwa.scaleunit.R;

/**
 * Created by Xsinwa on 2017/10/10.
 */

public class CustomeItem extends LinearLayout {
    private TextView number;
    private EditText eRab;
    private EditText eRbc;
    private EditText eRca;


    public CustomeItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        intitView(context);
    }

    private void intitView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_transformer, this, true);
        number = (TextView) findViewById(R.id.number);
        eRab = (EditText) findViewById(R.id.input1);
        eRbc = (EditText) findViewById(R.id.input2);
        eRca = (EditText) findViewById(R.id.input3);
    }

    public void setNumber(String s){
        number.setText(s);
    }

    public void setRab(String s){
        eRab.setText(s);
    }

    public String getRab(){
        return eRab.getText().toString();
    }

    public void setRbc(String s){
        eRbc.setText(s);
    }

    public String getRbc(){
        return eRbc.getText().toString();
    }

    public void setRca(String s){
        eRca.setText(s);
    }

    public String getRca(){
        return eRca.getText().toString();
    }
}
