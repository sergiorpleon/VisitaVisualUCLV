package com.uclv.dte;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.util.Locale;

public class FajardoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  String current = "fentrada";
  
  Dialog dialogo1 = null;
  
  String last = "fentrada";
  
  String lenguage = "es";

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

    private void crearDialogoSlider(String paramString1, String paramString2) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
        WebView webView = new WebView((Context)this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        builder.setTitle(paramString1);
        webView.loadUrl("file:///android_asset/fslider/" + paramString2 + "_" + this.lenguage + ".html");
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


    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context param1Context, Intent param1Intent) {
            String str2 = param1Intent.getStringExtra("type");
            String str1 = param1Intent.getStringExtra("message");

            switch (str2) {
                case "pano":
                    current = str1;
                    switch (str1) {
                        case "back":
                            myBrowser.loadUrl("file:///android_asset/" + last + "_" + lenguage + ".html");
                            current = last;

                            FajardoActivity.this.last = str1;
                            FajardoActivity.this.myBrowser.loadUrl("file:///android_asset/" + str1 + "_" + FajardoActivity.this.lenguage + ".html");
                            str1 = "";
                            str2 = FajardoActivity.this.current;

                            break;
                        case "fmapa1":
                        case "fmapa2":
                        case "fmapa3":
                        case "fmapa4":
                        case "fmapa5":
                        case "fmapa6":
                            String num = str1.split("pa")[1];
                            //myBrowser.loadUrl("file:///android_asset/"+message+"_"+lenguage+".html");
                            myBrowser.loadUrl("file:///android_asset/fmapa_" + lenguage + ".html#" + num);

                            break;

                        default:
                            last = str1;
                            myBrowser.loadUrl("file:///android_asset/" + str1 + "_" + lenguage + ".html");
                            break;
                    }
                    String texttoast = "";
                    switch (current) {
                        case "fentrada":
                            texttoast = getString(R.string.title_toast_fentrada);
                            break;
                        case "flobi":
                            texttoast = getString(R.string.title_toast_flobi);
                            break;
                        case "fplaza":
                            texttoast = getString(R.string.title_toast_fplaza);
                            break;
                        case "fcruce":
                            texttoast = getString(R.string.title_toast_fcruce);
                            break;
                        case "fgimnasio":
                            texttoast = getString(R.string.title_toast_fgimnacio);
                            break;
                        case "fpista":
                            texttoast = getString(R.string.title_toast_fpista);
                            break;
                    }
                    if (texttoast.equalsIgnoreCase("")) {

                    } else {
                        Toast.makeText(param1Context, texttoast, Toast.LENGTH_SHORT).show();
                    }

                    break;
                case "imagen":
                    //Intent i = new Intent(context, ImageDialog.class);
                    switch (str1) {
                        case "fsitial":
                            crearDialogoSlider(getString(R.string.title_dialog_fsalahistoria), "fsitial");
                            break;
                        case "fterapeutica":
                            crearDialogoSlider(getString(R.string.title_toast_fgimnacio), "fterapeutica");
                            break;
                        case "ftenis":
                            crearDialogoSlider(getString(R.string.title_dialog_ftenis), "ftenis");
                            break;
                        case "fpiscina":
                            crearDialogoSlider(getString(R.string.title_dialog_fpiscina), "fpiscina");
                            break;
                        case "fbasque":
                            crearDialogoSlider(getString(R.string.title_dialog_fbasque), "fbasque");
                            break;
                        case "ffootball":
                            crearDialogoSlider(getString(R.string.title_dialog_ffootball), "ffootball");
                            break;
                        default:
                            //i.putExtra("url", 1);
                            break;
                    }
                    //startActivity(i);
                    break;
                case "slider":
                    //crearDialogoSlider();
                    break;
                case "info":
                    switch (str1) {
                        case "deporte":
                            Intent deporte = new Intent((Context) param1Context, FCFActivity.class);
                            startActivity(deporte);
                            break;
                        case "cecfd":
                            Intent cecfd = new Intent((Context) param1Context, CECFDActivity.class);
                            startActivity(cecfd);
                            break;
                        default:

                            break;
                    }
                    break;
                case "galeria":
                    Intent galeria = new Intent(param1Context, ViewPage_activity.class);
                    galeria.putExtra("id", Integer.parseInt(str1) / 2);
                    startActivity(galeria);

                    break;
                default:
                    Log.d("receiver", "Got message: " + str1);
                    //myBrowser.loadUrl("file:///android_asset/biblioteca.html");
                    crearDialogoAlerta();
                    break;
            }

        }
    };


  
  private void salir() {
    finish();
    super.onBackPressed();
  }
  
  public void onBackPressed() {
      DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
      if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
        drawerLayout.closeDrawer(GravityCompat.START);
        return;
      }
      String str1 = this.current;
      String str2 = this.last;
      switch (str2) {
          default:
            this.current = "fentrada";
              if (str1 == this.current && this.current == "fentrada")
                salir();
                this.myBrowser.loadUrl("file:///android_asset/fentrada_" + this.lenguage + ".html");
              break;
      case "fmapa1":
      case "fmapa2":
      case "fmapa3":
      case "fmapa4":
      case "fmapa5":
      case "fmapa6":
        this.myBrowser.loadUrl("file:///android_asset/" + this.last + "_" + this.lenguage + ".html");
        this.current = this.last;
        break;
      case "galeria":
        this.myBrowser.loadUrl("file:///android_asset/fentrada_" + this.lenguage + ".html");
        this.current = "fentrada";
      break;
      case "flobi":
        this.myBrowser.loadUrl("file:///android_asset/fentrada" + this.lenguage + ".html");
        this.current = "fentrada";
      case "fplaza":
        this.myBrowser.loadUrl("file:///android_asset/flobi_" + this.lenguage + ".html");
        this.current = "fentrada";
      case "fpista":
        this.myBrowser.loadUrl("file:///android_asset/flobi_" + this.lenguage + ".html");
        this.current = "flobi";
      case "fgimnacio":
        this.myBrowser.loadUrl("file:///android_asset/fcruce_" + this.lenguage + ".html");
        this.current = "fcruce";
      break;
    }
  }
  
  @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB_MR1)
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_fajardo);
    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    this.lenguage = (new Configuration(getResources().getConfiguration())).locale.getLanguage();
    DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle((Activity)this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawerLayout.setDrawerListener((DrawerLayout.DrawerListener)actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();
    ((NavigationView)findViewById(R.id.nav_view_fajardo)).setNavigationItemSelectedListener(this);
    this.myBrowser = (WebView)findViewById(R.id.mybrowserfajardo);
    WebSettings webSettings = this.myBrowser.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    Bundle bundle = getIntent().getExtras();
    if (bundle == null) {
      this.myBrowser.loadUrl("file:///android_asset/fentrada_" + this.lenguage + ".html");
    } else {
      String str = bundle.getString("pano", "fentrada");
      this.myBrowser.loadUrl("file:///android_asset/" + str + "_" + this.lenguage + ".html");
    } 
    this.myBrowser.addJavascriptInterface(new FIntermediario(this), "Android");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(R.menu.activity_main_drawer_fajardo, paramMenu);
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
    int i = paramMenuItem.getItemId();
    this.current = "";
    if (i == R.id.nav_visita) {
      salir();
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_deporte) {
      this.myBrowser.loadUrl("file:///android_asset/flobi_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_galeria) {
      this.current = "galeria";
      this.myBrowser.loadUrl("file:///android_asset/galeria_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_mapa)
      startActivity(new Intent((Context)this, Map.class)); 
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
    LocalBroadcastManager.getInstance((Context)this).registerReceiver(this.mMessageReceiver, new IntentFilter("my-event-f"));
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\FajardoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */