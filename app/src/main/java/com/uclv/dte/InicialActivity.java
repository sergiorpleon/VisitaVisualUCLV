package com.uclv.dte;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class InicialActivity extends AppCompatActivity {
  String lenguage = "es";

  WebView myBrowser;

  private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        param1Intent.getStringExtra("type");
        String str = param1Intent.getStringExtra("message");

        switch (str) {
              case "central":
                  Intent intentcentral = new Intent(param1Context, CentralActivity.class);
                  InicialActivity.this.startActivity(intentcentral);
                  break;
              case "pedagogico":
                  Intent intentpedagogico = new Intent((Context)param1Context, PedagogicoActivity.class);
                  InicialActivity.this.startActivity(intentpedagogico);
                  break;
              case "fajardo":
                  Intent intentfajardo = new Intent((Context)param1Context, FajardoActivity.class);
                  InicialActivity.this.startActivity(intentfajardo);
                  break;
              case "galeria":
                  Intent intentgaleria = new Intent((Context)param1Context, GaleriaActivity.class);
                  InicialActivity.this.startActivity(intentgaleria);
                  break;
              case "creditos":
                  Intent intentmap = new Intent((Context)param1Context, Map.class);
                  InicialActivity.this.startActivity(intentmap);
                break;
            }
      }
    };
  

  
  private void crearDialogoAlerta() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    builder.setView(getLayoutInflater().inflate(R.layout.layout_creditos, (ViewGroup)findViewById(R.id.lytLayout)));
    builder.setPositiveButton(getString(R.string.btn_regresar), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.cancel();
          }
        });
    builder.create().show();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_inicial);
    this.myBrowser = (WebView)findViewById(R.id.inicialbrowser);
    WebSettings webSettings = this.myBrowser.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    this.myBrowser.loadUrl("file:///android_asset/inicial_" + this.lenguage + ".html");
    this.myBrowser.addJavascriptInterface(new Intermediario(this), "AndroidInicial");
  }
  
  protected void onPause() {
    LocalBroadcastManager.getInstance((Context)this).unregisterReceiver(this.mMessageReceiver);
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    LocalBroadcastManager.getInstance((Context)this).registerReceiver(this.mMessageReceiver, new IntentFilter("my-event-i"));
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\InicialActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */