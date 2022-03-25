package com.gchn.test;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InflaterActivity extends AppCompatActivity {
    LinearLayout ll_container;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);

        init();
        inflateView();
    }

    private void init(){
        ll_container = findViewById(R.id.ll_container);
    }

    private void inflateView(){
        Button button = findViewById(R.id.btn_inflate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 시스템 서비스에서 제공되는 layoutinflater 객체 참조
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // 부분 뷰를 메인 레이아웃에 추가
                inflater.inflate(R.layout.layout_sub1, ll_container, true);
                // 체크 박스는 추가된 메인 레이아웃에서 찾을 수 있다.
                CheckBox checkBox = ll_container.findViewById(R.id.ch_sub);
                checkBox.setText("로딩 완료");
            }
        });
    }
}
