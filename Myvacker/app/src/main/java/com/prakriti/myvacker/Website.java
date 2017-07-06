package com.prakriti.myvacker;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Website extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        final ProgressDialog pd = ProgressDialog.show(Website.this, "", "Please wait,Page is Loading...", true);

        myWebView  = (WebView)findViewById(R.id.website);

        myWebView .getSettings().setJavaScriptEnabled(true); // enable javascript

        myWebView .getSettings().setLoadWithOverviewMode(true);
        myWebView .getSettings().setUseWideViewPort(true);
        myWebView .getSettings().setBuiltInZoomControls(true);


        myWebView .setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(Website.this, "Network/Server Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                pd.show();
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();

                String webUrl = myWebView.getUrl();

            }



        });
        myWebView.loadUrl("https://www.vackerglobal.com");
        /*myWebView = (WebView) findViewById(R.id.website);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);*/

        // myWebView.loadUrl("https://www.vackerglobal.com/");
        // myWebView.loadUrl(mPrefs.getString(PREF_STRING, "https://www.vackerglobal.com/"));
        String url = getIntent().getStringExtra("URL");

        myWebView.loadUrl(url);

        //  myWebView.setWebViewClient(new WebViewClient());
        // myWebView.setWebViewClient(new MyAppWebViewClient(ProgressBar));
        // myWebView.setWebViewClient(new MyAppWebViewClient(Progr));
        //myWebView.setWebViewClient(new MyAppWebViewClient());

    }
}
