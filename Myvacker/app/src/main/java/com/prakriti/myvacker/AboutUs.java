package com.prakriti.myvacker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
    TextView textView, txtcopy;
    WebView webView;
    ImageView imgcopy, imgvg_grup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        final ProgressDialog pd = ProgressDialog.show(AboutUs.this, "", "Please wait,Page is Loading...", true);
        pd.show();

        WebView view = new WebView(this);
      //  view.setVerticalScrollBarEnabled(false);

        ((WebView)findViewById(R.id.vg)).addView(view);

        WebSettings mWebSettings = view.getSettings();
        view.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        view.setScrollbarFadingEnabled(false);
        view.loadData(getString(R.string.text), "text/html; charset=utf-8", "utf-8");
        pd.dismiss();


        txtcopy = (TextView) findViewById(R.id.txtcopy);
        imgcopy = (ImageView) findViewById(R.id.copyryt);
        imgvg_grup = (ImageView) findViewById(R.id.vg_grup);
    }
}

