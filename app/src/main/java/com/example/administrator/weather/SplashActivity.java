package com.example.administrator.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView mtv_versionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //初始化UI
        initUi();
        //初始化数据
        initData();
        //睡3秒之后进入主界面
        handler.sendEmptyMessageDelayed(0,3000);
    }

    /**
     * 跳转进主界面方法
     */
    private void showMainActivity() {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
    }

    /**
     * 创建一个消息处理对象，用于发送延迟进入主界面的消息
     */
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showMainActivity();
        }
    };

    /**
     *获取版本数据
     */
    @SuppressLint("SetTextI18n")
    private void initData() {
        //将返回的数据添加到TextView中
        mtv_versionName.setText("版本号：" + getVersionName());
    }

    /**
     * 获取版本名称
     * @return 应用版本名称，异常则返回null
     */
    private String getVersionName() {
        //获取包管理者
        PackageManager packageManager = getPackageManager();
        try {
            //flags为0表示获取基本信息
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            //返回版本名称
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化Ui方法
     */
    private void initUi() {
        mtv_versionName = findViewById(R.id.tv_versionName);
    }


}
