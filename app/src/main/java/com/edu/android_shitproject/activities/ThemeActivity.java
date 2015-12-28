package com.edu.android_shitproject.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.edu.android_shitproject.MainActivity;
import com.edu.android_shitproject.R;

public class ThemeActivity extends AppCompatActivity implements Runnable {

    private static final String TAG = "ThemeActivity";
    private Thread thread = null;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            startActivity((Intent) msg.obj);
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 删除 消失电池  必须放在 onCreate 方法前
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_theme);
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            Intent intent = new Intent(this, MainActivity.class);
            Message msg = handler.obtainMessage();
            msg.obj = intent;
            handler.sendMessage(msg);
        } catch (InterruptedException e) {
            Log.i(TAG, "线程中断" + e.toString());
        }
    }
}
