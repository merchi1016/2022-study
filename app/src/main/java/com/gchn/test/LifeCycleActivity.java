package com.gchn.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        init();
        initListener();
        println("onCreate 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("onStart 호출됨");
    }

    @Override
    protected void onResume(){
        super.onResume();
        println("onResume 호출됨");
        restoreState();
    }

    @Override
    protected void onPause(){
        super.onPause();
        println("onPause 호출됨");
        saveState();
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("onDestory 호출됨");
    }

    private void init(){
        button = findViewById(R.id.btn_menu);
        editText = findViewById(R.id.et_cycle_data);
    }

    private void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void println(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Log.d("Main", data);
    }


    // 데이터 저장하기
    private void saveState(){
        // pref 라는 이름으로 저장소 생성
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString());
        editor.commit();
    }

    // 데이터 복구하기
    private void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref != null) && (pref.contains("name"))){
            String name = pref.getString("name", "");
            editText.setText(name);
        }
    }

    // 데이터 초기화하기
    private void clearState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}