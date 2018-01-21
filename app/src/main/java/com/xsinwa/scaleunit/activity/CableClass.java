package com.xsinwa.scaleunit.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import com.xsinwa.scaleunit.adapter.MyFragmentPageAdapter;
import com.xsinwa.scaleunit.adapter.MyPagerAdpter;
import com.xsinwa.scaleunit.R;
import com.xsinwa.scaleunit.fragment.Page10KV;
import com.xsinwa.scaleunit.fragment.Page110KV;
import com.xsinwa.scaleunit.fragment.Page220KV;
import com.xsinwa.scaleunit.fragment.Page35KV;
import com.xsinwa.scaleunit.ui.MyEditText;

import java.util.ArrayList;
import java.util.List;

public class CableClass extends AppCompatActivity implements View.OnClickListener {
    private TextView t10KV;
    private TextView t35KV;
    private TextView t110KV;
    private TextView t220KV;

    private ViewPager cViewPager;
    private List<Fragment> pageList = new ArrayList<Fragment>();
    private MyFragmentPageAdapter myPagerAdpter;
    private TextView topTitle;
    private LinearLayout Backward;

    private static final int PAGE_10KV_FRAGMENT = 0;
    private static final int PAGE_35KV_FRAGMENT = 1;
    private static final int PAGE_110KV_FRAGMENT = 2;
    private static final int PAGE_220KV_FRAGMENT = 3;

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
        t10KV.setOnClickListener(this);
        t10KV.setBackgroundColor(Color.parseColor("#E0FFFF"));

        t35KV = (TextView) findViewById(R.id.t_35KV);
        t35KV.setOnClickListener(this);
        t35KV.setBackgroundColor(Color.parseColor("#EBEBEB"));

        t110KV = (TextView) findViewById(R.id.t_110KV);
        t110KV.setOnClickListener(this);
        t110KV.setBackgroundColor(Color.parseColor("#EBEBEB"));

        t220KV = (TextView) findViewById(R.id.t_220KV);
        t220KV.setOnClickListener(this);
        t220KV.setBackgroundColor(Color.parseColor("#EBEBEB"));

        cViewPager = (ViewPager) findViewById(R.id.cViewPager);
        initViewPager();

    }

    private void initViewPager() {
        pageList.add(new Page10KV());
        pageList.add(new Page35KV());
        pageList.add(new Page110KV());
        pageList.add(new Page220KV());

        FragmentManager fragmentManager = getSupportFragmentManager();
        myPagerAdpter = new MyFragmentPageAdapter(fragmentManager, pageList);
        cViewPager.setAdapter(myPagerAdpter);
        cViewPager.setCurrentItem(0);
        cViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCurrentPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setCurrentPosition(int position) {
        Message msg = new Message();
        msg.what = position;
        handler.sendMessage(msg);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backward:
                finish();
                break;

            case R.id.t_10KV:
                setCurrentPosition(PAGE_10KV_FRAGMENT);
                cViewPager.setCurrentItem(PAGE_10KV_FRAGMENT);
                break;

            case R.id.t_35KV:
                setCurrentPosition(PAGE_35KV_FRAGMENT);
                cViewPager.setCurrentItem(PAGE_35KV_FRAGMENT);
                break;

            case R.id.t_110KV:
                setCurrentPosition(PAGE_110KV_FRAGMENT);
                cViewPager.setCurrentItem(PAGE_110KV_FRAGMENT);
                break;

            case R.id.t_220KV:
                setCurrentPosition(PAGE_220KV_FRAGMENT);
                cViewPager.setCurrentItem(PAGE_220KV_FRAGMENT);
                break;

            default:
                break;
        }
    }


}
