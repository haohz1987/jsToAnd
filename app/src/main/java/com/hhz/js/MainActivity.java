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
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webView);
        tv_status = findViewById(R.id.tv_status);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.loadUrl("file:///android_asset/jstoandroid.html");
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {

                Uri uri = Uri.parse(url);
                if(uri.getScheme().equals("js")){
                    if(uri.getAuthority().equals("hyqbwebview")){
                        HashMap<String,String> params = new HashMap<>();
                        Set<String> coll = uri.getQueryParameterNames();
                        String status = uri.getQueryParameter("bindstatus");
                        LogT.w("coll="+coll.toString()+";status="+status);
                        tv_status.setText("调用android需要的方法");
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("bindstatus",status);
                        startActivity(intent);
                        finish();
                    }
                }
                super.onLoadResource(view, url);
            }
        });
    }
}
