package com.xsinwa.scaleunit.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xsinwa.scaleunit.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Transformer;
    private Button Cable;
    private Button DRC;
    private Button DLC;
    private Button IRC;
    private Button ITC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
    }

    private void initView() {
        Transformer = (Button) findViewById(R.id.transformer);
        Transformer.setOnClickListener(this);

        Cable = (Button) findViewById(R.id.cable);
        Cable.setOnClickListener(this);

        DRC = (Button) findViewById(R.id.DRC);
        DRC.setOnClickListener(this);

        DLC = (Button) findViewById(R.id.DLC);
        DLC.setOnClickListener(this);

        IRC = (Button) findViewById(R.id.IRC);
        IRC.setOnClickListener(this);

        ITC = (Button) findViewById(R.id.ITC);
        ITC.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.transformer:
                intent = new Intent(this, TransformerClass.class);
                startActivity(intent);
                break;

            case R.id.cable:
                intent = new Intent(this, CableClass.class);
                startActivity(intent);
                break;

            case R.id.DLC:
                intent = new Intent(this, DlcActivity.class);
                startActivity(intent);
                break;

            case R.id.DRC:
                intent = new Intent(this, DrcAcitivity.class);
                startActivity(intent);
                break;

            case R.id.IRC:
                intent = new Intent(this, IrcActivity.class);
                startActivity(intent);
                break;

            case R.id.ITC:
                intent = new Intent(this, ItcActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}