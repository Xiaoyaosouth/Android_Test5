package com.xiaoyao.test5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
    }

    /**
     * 按钮控件初始化
     */
    private void initButton(){
        button1 = (Button)findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(this);
    }

    /**
     * 按钮事件处理统一管理
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:openFileStorageActivity();
                break;
            case R.id.btn2:openDataBaseStorageActivity();
                break;
            case R.id.btn3:openSharedPreferenceActivity();
                break;
            default:
        }
    }

    private void openFileStorageActivity(){
        Intent intent = new Intent(MainActivity.this, FileStorageActivity.class);
        startActivity(intent);
    }

    private void openDataBaseStorageActivity(){
        Intent intent = new Intent(MainActivity.this, DataBaseStorageActivity.class);
        startActivity(intent);
    }

    private void openSharedPreferenceActivity(){
        Intent intent = new Intent(MainActivity.this, SharedPreferenceActivity.class);
        startActivity(intent);
    }
}
