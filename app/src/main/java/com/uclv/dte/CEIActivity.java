package com.uclv.dte;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import java.io.IOException;

public class CEIActivity extends AppCompatActivity {
  String lenguage = "es";
  
  WebView myBrowser;
  
  private void crearDialogoSlider() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    WebView webView = new WebView((Context)this);
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    builder.setTitle(getString(R.string.title_activity_cei));
    webView.loadUrl("file:///android_asset/slider/cei_" + this.lenguage + ".html");
    webView.setWebViewClient(new WebViewClient() {
          public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
            param1WebView.loadUrl(param1String);
            return true;
          }
        });
    builder.setView((View)webView);
    builder.setNegativeButton(getString(R.string.btn_regresar), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.dismiss();
          }
        });
    builder.show();
  }
  
  private Bitmap getBitmapFromAsset(String paramString) throws IOException {
    return BitmapFactory.decodeStream(getAssets().open(paramString));
  }
  
  protected void onCreate(Bundle paramBundle) {
    Bitmap bitmap = null;
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_cei);
    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            CEIActivity.this.onBackPressed();
          }
        });
    this.lenguage = (new Configuration(getResources().getConfiguration())).locale.getLanguage();
    toolbar = null;
    try {
      Bitmap bitmap1 = getBitmapFromAsset("slider/img/cei/CEI.jpg");
      bitmap = bitmap1;
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    ((ImageView)findViewById(R.id.backgroundProfileImage)).setImageBitmap(bitmap);
    ((FloatingActionButton)findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            CEIActivity.this.crearDialogoSlider();
          }
        });
    this.myBrowser = (WebView)findViewById(R.id.webview);
    WebSettings webSettings = this.myBrowser.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    this.myBrowser.loadUrl("file:///android_asset/info/cei.html");
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\CEIActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */