package com.gchn.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExtraActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        init();
        initListener();
    }

    private void init(){
        button = findViewById(R.id.btn_startMenu);
    }

    private void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ExtraMenuActivity.class);
                // SimpleData 객체 생성
                SimpleData data = new SimpleData(100, "Hello Android!");
                // 인텐트에 부가 데이터 넣기
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }

    // 요청을 보낸 액티비티에서 돌아오면 자동 호출되는 메소드
    // 응답을 수신할 수 있다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 요청 코드 확인
        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),
                    "onActivityResult 메소드 호출됨. 요청 코드 : " + requestCode +
                            ", 결과 코드 " + requestCode, Toast.LENGTH_SHORT).show();

            // 응답 메시지 코드 확인
            if(resultCode == RESULT_OK){
                // 응답해온 데이터 중 name 으로 데이터를 가져온다.
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(),
                        "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT).show();
            }
        }
    }
}