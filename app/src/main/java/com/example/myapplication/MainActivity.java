package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //
    private BtnOnClick btnOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化一个监听器
        btnOnClick = new BtnOnClick();

        //查找到按钮并添加监听
        findViewById(R.id.btn1).setOnClickListener(btnOnClick);

    }

    class BtnOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v instanceof Button && v.getId() == R.id.btn1) {
                EditText editText = findViewById(R.id.editText);
                Editable text = editText.getText();
                String url = text.toString();
                if (url == null || "".equals(url.trim())) {
                    editText.setText("请在此填写推流地址");
                    return;
                }
                if (!url.startsWith("rtmp://")) {
                    editText.setText("您填写的地址不正确");
                    return;
                }


            }
        }
    }


}
