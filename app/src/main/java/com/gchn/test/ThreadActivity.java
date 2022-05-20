package com.gchn.test;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadActivity extends AppCompatActivity {
    private Button btn_startThread;
    private Button btn_stopThread;
    private TextView tv_value;

    int value = 0;
    BackgroundThread thread;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        init();
        initListener();
    }

    private void init(){
        btn_startThread = findViewById(R.id.btn_start_thread);
        btn_stopThread = findViewById(R.id.btn_stop_thread);
        tv_value = findViewById(R.id.tv_threadValue);
    }

    private void initListener(){
        btn_startThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thread == null){
                    thread = new BackgroundThread();
                    thread.start();
                }else{
                    Toast.makeText(getApplicationContext(), R.string.running_thread, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_stopThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(thread != null && thread.isAlive()){
                        Thread.sleep(1000);
                        thread.interrupt();
                    }
                }catch(InterruptedException e){
                    Toast.makeText(getApplicationContext(), R.string.stop_thread, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class BackgroundThread extends Thread {
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                value += 1;
                Log.d("Thread", "value:" + value);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_value.setText("value 값: " + value);
                    }
                });
            }
        }
    }
}
