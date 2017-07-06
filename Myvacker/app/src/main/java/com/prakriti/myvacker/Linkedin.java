package com.prakriti.myvacker;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Linkedin extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkedin);

        final ProgressDialog pd = ProgressDialog.show(Linkedin.this, "", "Please wait,Page is Loading...", true);

        webView  = (WebView)findViewById(R.id.linkwebsite);

        webView .getSettings().setJavaScriptEnabled(true); // enable javascript

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);


        webView .setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(Linkedin.this, "Network/Server Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                pd.show();
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();

                String webUrl = webView.getUrl();

            }



        });
        webView.loadUrl("https://www.linkedin.com/company/vacker-global");



    }
}
