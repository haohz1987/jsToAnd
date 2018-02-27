package com.hhz.js;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {

    private WebView mWebView;
    private TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_status = findViewById(R.id.tv_status);
        if (getIntent()!=null){
            tv_status.setText("状态标志位:"+getIntent().getStringExtra("bindstatus"));
        }

    }
}
