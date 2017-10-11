package com.xsinwa.scaleunit.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.xsinwa.scaleunit.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private final static String USER_NAME = "hongwh3514";
    private final static String PASSWORDS = "xssh4232";
    private EditText userName;
    private EditText passwords;
    private Button Login;
    private CheckBox remPassword;
    private CheckBox autoLogin;
    private String account;
    private String password;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
    }

    private void initView() {
        userName = (EditText) findViewById(R.id.user_name);
        passwords = (EditText) findViewById(R.id.passwords);
        Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(this);

        remPassword = (CheckBox) findViewById(R.id.checkbox_rem_password);
        remPassword.setOnCheckedChangeListener(this);

        autoLogin = (CheckBox) findViewById(R.id.checkbox_auto_login);
        autoLogin.setOnCheckedChangeListener(this);
        if (autoLogin.isChecked()){
            remPassword.setChecked(true);
        }

        preferences = getSharedPreferences("login_info", MODE_PRIVATE);
        if(preferences.getBoolean("REM_PASSWORD_STATE", false)){
            remPassword.setChecked(true);
            userName.setText(preferences.getString("ACCOUNT", ""));
            passwords.setText(preferences.getString("PASSWORD", ""));

            if(preferences.getBoolean("AUTO_LOGIN_STATE", false)){
                autoLogin.setChecked(true);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Login:
                if (TextUtils.isEmpty(userName.getText())){
                    Toast.makeText(this,"请输入账号！", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (TextUtils.isEmpty(passwords.getText())){
                    Toast.makeText(this,"请输入密码！", Toast.LENGTH_SHORT).show();
                    break;
                }
                account = userName.getText().toString();
                password = passwords.getText().toString();
                if(USER_NAME.equals(userName.getText().toString()) && PASSWORDS.equals(passwords.getText().toString())){
                    if(remPassword.isChecked()){
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("ACCOUNT", account);
                        editor.putString("PASSWORD", password);
                        editor.commit();
                    }
                    Intent mainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mainActivityIntent);
                    finish();
                    break;
                }else {
                    if (!USER_NAME.equals(userName.getText().toString())){
                        Toast.makeText(this, "账号不存在！", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "账号与密码不匹配！", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }

            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        switch (button.getId()){
            case R.id.checkbox_rem_password:
                if(remPassword.isChecked()){
                    preferences.edit().putBoolean("REM_PASSWORD_STATE", true).commit();
                }else {
                    preferences.edit().putBoolean("REM_PASSWORD_STATE", false).commit();
                }
                break;
            case R.id.checkbox_auto_login:
                if(remPassword.isChecked()){
                    preferences.edit().putBoolean("AUTO_LOGIN_STATE", true).commit();
                }else {
                    preferences.edit().putBoolean("AUTO_LOGIN_STATE", false).commit();
                }
                break;
            default:
                break;
        }
    }

}
