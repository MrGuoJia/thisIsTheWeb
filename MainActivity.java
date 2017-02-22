package com.example.yls.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mWebView= (WebView) findViewById(R.id.WebView);
        mWebView.loadUrl("http://www.baidu.com");
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                view.loadUrl(request);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
               if(newProgress==100){
                   Toast.makeText(MainActivity.this,"加载成功",Toast.LENGTH_SHORT).show();

               } else{
                   Toast.makeText(MainActivity.this,"加载中....",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(mWebView.canGoBack()){
                mWebView.canGoBack();
                return true;
            }else{
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
