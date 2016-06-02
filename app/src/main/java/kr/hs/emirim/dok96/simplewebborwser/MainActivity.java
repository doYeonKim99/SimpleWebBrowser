package kr.hs.emirim.dok96.simplewebborwser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editUrl;
    Button butMove,butPrev;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrl=(EditText)findViewById(R.id.edit_url);
        butMove=(Button)findViewById(R.id.but_move);
        butPrev=(Button)findViewById(R.id.but_prev);
        web=(WebView)findViewById(R.id.web);
        butMove.setOnClickListener(this);
        butPrev.setOnClickListener(this);
        web.setWebViewClient(new WebViewClient());
        WebSettings webSet=web.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);
        web.loadUrl("http://www.naver.com");

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.but_move:
                if(editUrl.getText().toString().contains("http://")) {
                    web.loadUrl(editUrl.getText().toString());
                }
                else{
                    web.loadUrl("http://"+editUrl.getText().toString());
                }
                break;
            case R.id.but_prev:
                web.goBack();
                break;
        }
    }
}
