package com.uclv.dte;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.Locale;

public class GaleriaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  String current = "entrada";
  
  Dialog dialogo1 = null;
  
  String last = "entrada";
  
  String lenguage = "es";
  
  private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        String str2 = param1Intent.getStringExtra("type");
        String str1 = param1Intent.getStringExtra("message");
        switch (str2) {
            case "galeria":
                Intent intent = new Intent(param1Context, ViewPage_activity.class);
                intent.putExtra("id", Integer.parseInt(str1)/2);
                GaleriaActivity.this.startActivity(intent);
                break;
            default:
                GaleriaActivity.this.crearDialogoAlerta();
                break;

        }
      }
    };
  
  WebView myBrowser;
  
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
  
  private void crearDialogoIdioma() {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
    builder.setView(getLayoutInflater().inflate(R.layout.layout_idioma, (ViewGroup)findViewById(R.id.lytLayout)));
    this.dialogo1 = (Dialog)builder.create();
    this.dialogo1.show();
  }
  
  private void salir() {
    onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_galeria);
    getSupportActionBar().setHomeButtonEnabled(true);
    this.lenguage = (new Configuration(getResources().getConfiguration())).locale.getLanguage();
    this.myBrowser = (WebView)findViewById(R.id.mybrowser);
    WebSettings webSettings = this.myBrowser.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    getIntent().getExtras();
    this.myBrowser.loadUrl("file:///android_asset/galeria_" + this.lenguage + ".html");
    this.myBrowser.addJavascriptInterface(new GIntermediario(this), "Android");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(R.menu.main, paramMenu);
    return true;
  }
  
  public void onEspannol(View paramView) {
    Configuration configuration = new Configuration(getResources().getConfiguration());
    configuration.locale = Locale.getDefault();
    getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    this.lenguage = "es";
    this.dialogo1.dismiss();
  }
  
  public void onIngles(View paramView) {
    Configuration configuration = new Configuration(getResources().getConfiguration());
    configuration.locale = Locale.ENGLISH;
    getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    this.lenguage = "en";
    this.dialogo1.dismiss();
  }
  
  public boolean onNavigationItemSelected(MenuItem paramMenuItem) {
    ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    if (paramMenuItem.getItemId() == R.id.action_settings) {
      crearDialogoAlerta();
      return true;
    } 
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause() {
    LocalBroadcastManager.getInstance((Context)this).unregisterReceiver(this.mMessageReceiver);
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    LocalBroadcastManager.getInstance((Context)this).registerReceiver(this.mMessageReceiver, new IntentFilter("my-event-g"));
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\GaleriaActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */