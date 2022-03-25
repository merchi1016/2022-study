package com.gchn.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
        initListener();
    }

    private void init(){
        button = findViewById(R.id.btn_back);
    }

    private void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 객체 생성
                Intent intent = new Intent();
                // 인텐트에 부가 데이터 추가
                intent.putExtra("name", "mike");
                // 이전 액티비티로 응답 보내기
                setResult(RESULT_OK, intent);
                // 현재 액티비티 제거하기
                finish();
            }
        });
    }
}
