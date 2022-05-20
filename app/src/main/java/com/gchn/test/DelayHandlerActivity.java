package com.gchn.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

// 일정 시간 후에 실행하기
public class DelayHandlerActivity extends AppCompatActivity {
    private TextView tv_message;
    private Button btn_delayHandler;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_handler);

        init();
        initListener();
    }

    private void init(){
        tv_message = findViewById(R.id.tv_message);
        btn_delayHandler = findViewById(R.id.btn_delay_handler);
    }

    private void initListener(){
        btn_delayHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request();
            }
        });
    }

    private void request(){
        String title = "원격 요청";
        String message = "데이터를 요청하시겠습니까?";
        String titleButtonYes = "예";
        String titleButtonNo = "아니오";
        AlertDialog dialog = makeRequestDialog(title, message, titleButtonYes, titleButtonNo);
        dialog.show();

        tv_message.setText("대화상자 표시중..");
    }

    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message,
                                          CharSequence titleButtonYes, CharSequence titleButtonNo){
        AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
        requestDialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(titleButtonYes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv_message.setText("5초 후에 결과 표시됨");

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tv_message.setText("요청 완료됨");
                            }
                        }, 5000);
                    }
                })
                .setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv_message.setText("");
                    }
                });

        return requestDialog.create();
    }
}
