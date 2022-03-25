package com.gchn.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {
    private static final int REQUST_CODE_MENU = 101;
    Button button;

    // activityResultLauncher 객체 생성
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        init();
        initListener();
    }

    private void init(){
        button = findViewById(R.id.btn_startAct);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{
                    // onActivityResult 파라미터들을 이런식으로 접근한다.
                    int resultCode = result.getResultCode();
                    Intent data = result.getData();

                    // 응답 메시지 코드 확인
                    if(resultCode == RESULT_OK){
                        // 응답해온 데이터 중 name 으로 데이터를 가져온다.
                        String name = data.getStringExtra("name");
                        Toast.makeText(getApplicationContext(),
                                "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        MenuActivity.class);
                // 액티비티를 띄우면서 요청 코드 보내기
                startActivityForResult(intent, REQUST_CODE_MENU);
                //activityResultLauncher.launch(intent);
            }
        });
    }

    // 요청을 보낸 액티비티에서 돌아오면 자동 호출되는 메소드
    // 응답을 수신할 수 있다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 요청 코드 확인
        if(requestCode == REQUST_CODE_MENU){
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

