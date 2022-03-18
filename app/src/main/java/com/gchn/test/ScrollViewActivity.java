package com.gchn.test;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScrollViewActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private Button btn_changeImg;
    private ImageView iv_img;
    private BitmapDrawable bitmap;

    private int imgNum = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_scrollview);

        init();
        changeImg(imgNum);
    }

    private void init(){
        scrollView = findViewById(R.id.scrollView);
        btn_changeImg = findViewById(R.id.btn_change);
        iv_img = findViewById(R.id.iv_scroll_img);

        // 수평 스크롤바 사용 기능 설정
        scrollView.setHorizontalScrollBarEnabled(true);
    }

    // 실제 이미지 크기 설정하기
    private void changeImg(int num){
        // Drawable 리소스 이미지 참조
        Resources res = getResources();
        if(num == 1){
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
            imgNum = 2;
        }else{
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
            imgNum = 1;
        }

        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        iv_img.setImageDrawable(bitmap);
        iv_img.getLayoutParams().width = bitmapWidth;
        iv_img.getLayoutParams().height = bitmapHeight;
    }

    public void onImgBtnClick(View view){
        changeImg(imgNum);
    }


}
