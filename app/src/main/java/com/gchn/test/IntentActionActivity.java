package com.gchn.test;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActionActivity extends AppCompatActivity {
    private static int REQUST_CODE_MENU = 101;
    EditText et_phone;
    Button button;
    Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_action);

        init();
        initListener();
    }

    private void init(){
        et_phone = findViewById(R.id.et_phone);
        button = findViewById(R.id.btn_call);
        button2 = findViewById(R.id.btn_component);
    }

    private void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et_phone.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.gchn.test",
                        "com.gchn.test.MenuActivity");
                intent.setComponent(name);
                startActivityForResult(intent, REQUST_CODE_MENU);
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
