package com.qcloud.popupwindow;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private PopupWindow mPopWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_pop);
        btn.setOnClickListener(this);
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_popupwindow, null);
        mPopWindow = new PopupWindow(contentView,
                500, ActionBar.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //设置各个控件的点击响应
        TextView tv1 = contentView.findViewById(R.id.pop_computer);
        TextView tv2 = contentView.findViewById(R.id.pop_financial);
        TextView tv3 = contentView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        //显示PopupWindow
        View rootview = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pop:
                showPopupWindow();
                break;
            case R.id.pop_computer:
                Toast.makeText(this,"clicked computer",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.pop_financial:
                Toast.makeText(this,"clicked financial",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.pop_manage:
                Toast.makeText(this,"clicked manage",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
        }
    }
}

