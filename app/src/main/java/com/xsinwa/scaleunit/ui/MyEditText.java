package com.xsinwa.scaleunit.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xsinwa.scaleunit.R;

/**
 * Created by Xsinwa on 2017/10/3.
 */

public class MyEditText extends LinearLayout implements View.OnClickListener {
    private EditText input;
    private ImageView delet;

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.custom_edit_text, this, true);
        input = (EditText) findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(input.getText().toString().replace(" ",""))){
                    delet.setVisibility(View.GONE);
                }else {
                    delet.setVisibility(View.VISIBLE);
                }
            }
        });
        delet = (ImageView) findViewById(R.id.delet);
        delet.setOnClickListener(this);
    }

    public void setInput(String text){
        input.setText(text);
    }

    public String getInput(){
        return input.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.delet:
                input.setText("");
                break;
        }
    }

//    public void setTextChangeListener(){
//        input.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
}
