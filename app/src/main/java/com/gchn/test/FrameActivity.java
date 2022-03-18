package com.gchn.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {
    private Button btn_change;
    private ImageView img_dog;
    private ImageView img_yoshi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);

        init();
    }

    private void init(){
        btn_change = findViewById(R.id.btn_change_Img);
        img_dog = findViewById(R.id.iv_img);
        img_yoshi = findViewById(R.id.iv_img2);
    }

    public void onBtnChangeClick(View view){
        changeImage();
    }

    private void changeImage(){
        // 강아지 사진이 보여지고 있는 경우
        if(img_dog.getVisibility() == View.VISIBLE){
            img_dog.setVisibility(View.INVISIBLE);
            img_yoshi.setVisibility(View.VISIBLE);
        }else{
            img_dog.setVisibility(View.VISIBLE);
            img_yoshi.setVisibility(View.INVISIBLE);
        }
    }
}
