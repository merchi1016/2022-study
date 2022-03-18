package com.gchn.test;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OrientationActivity extends AppCompatActivity {
    String name;

    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_orientation);
        showToast("onCreate 호출됨");

        init();
        initListener();

        if(savedInstanceState != null){
            name = savedInstanceState.getString("name");
            showToast("복원된 값 : " + name);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestory 호출됨");
    }

    private void init(){
        editText = findViewById(R.id.et_data);
        button = findViewById(R.id.btn_confirm);
    }

    private void initListener(){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                showToast("입력된 값을 변수에 저장 : " + name);
            }
        });
    }

    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // 가로 방향 전환시 처리
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            showToast("방향 : ORIENTATION_LANDSCAPE");
        // 세로 방향 전환시 처리
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            showToast("방향 : ORIENTATION_PORTRAIT");
        }
    }
}
