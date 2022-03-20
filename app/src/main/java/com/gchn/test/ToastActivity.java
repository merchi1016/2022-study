package com.gchn.test;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ToastActivity extends AppCompatActivity {
    ProgressDialog dialog;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_toast);

        init();
    }

    private void init(){
        progressBar = findViewById(R.id.progressBar);
        // 불확정적 상태표시를 설정함. 진행 상황을 명확히 알지 못하는 경우 설정
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);
    }

    public void onButtonToastClick(View view){
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.layout_toastborder,
                (ViewGroup) findViewById(R.id.ll_toast_layout));

        TextView text = layout.findViewById(R.id.tv_toast);

        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void onButtonSnackBarClick(View view){
        Snackbar.make(view, "스낵바입니다.", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "스낵바 클릭", Toast.LENGTH_SHORT).show();
                    }
                }
        ).show();
    }

    public void onButtonalertDialogClick(View view){
        // alertDialog 객체 생성, 제목, 내용, 아이콘 설정
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // alertDialog 예 버튼 클릭 이벤트
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "예 버튼이 눌렸습니다.";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        // alertDialog 아니오 버튼 클릭 이벤트
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "아니오 버튼이 눌렸습니다.";
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
            }
        });

        // alertDialog 취소 버튼 클릭 이벤트
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String message = "취소 버튼이 눌렸습니다.";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onButtonProgressBarClick(View view){
        dialog = new ProgressDialog(ToastActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("데이터를 확인하는 중입니다.");

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dialog.dismiss();
    }
}
