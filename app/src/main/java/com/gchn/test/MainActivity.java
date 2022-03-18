package com.gchn.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_change;
    private Button btn_scroll;

    private ImageView iv_img;
    private ImageView iv_img2;

    // 현재 이미지를 표시하기 위함
    private int img_idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);

        init();
    }

    private void init() {
        btn_change = findViewById(R.id.btn_change_Img);
        btn_scroll = findViewById(R.id.btn_go_scrollView);
        iv_img = findViewById(R.id.iv_img);
        iv_img2 = findViewById(R.id.iv_img2);
    }

    public void onBtnChangeClick(View view) {
        changeImage();
    }

    private void changeImage(){
        if(img_idx == 0){
            iv_img.setVisibility(View.VISIBLE);
            iv_img2.setVisibility(View.INVISIBLE);
            img_idx = 1;
        }else{
            iv_img.setVisibility(View.INVISIBLE);
            iv_img2.setVisibility(View.VISIBLE);
            img_idx = 0;
        }
    }

    public void onClickGoScrollView(View view){
        Intent intent = new Intent(getApplicationContext(), ScrollViewActivity.class);
        startActivity(intent);
    }

    public void onClickGoTouchEventView(View view){
        Intent intent = new Intent(getApplicationContext(), TouchEventActivity.class);
        startActivity(intent);
    }

    public void onClickGoOriView(View view){
        Intent intent = new Intent(getApplicationContext(), OrientationActivity.class);
        startActivity(intent);
    }
}