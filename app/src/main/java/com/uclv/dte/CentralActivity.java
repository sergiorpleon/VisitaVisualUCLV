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

public class CentralActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  String current = "entrada";
  
  Dialog dialogo1 = null;
  
  String last = "entrada";
  
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
        webView.loadUrl("file:///android_asset/slider/" + paramString2 + "_" + this.lenguage + ".html");
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
          switch (str2){
              case "pano":
                  current = str1;
                  switch (str1){
                      case "back":
                          myBrowser.loadUrl("file:///android_asset/"+last+"_"+lenguage+".html");
                          current = last;
                          break;
                      case "mapa1":
                      case "mapa2":
                      case "mapa3":
                      case "mapa4":
                      case "mapa5":
                      case "mapa6":
                      case "mapa7":
                      case "mapa8":
                      case "mapa9":
                      case "mapa10":
                      case "mapa11":
                      case "mapa12":
                      case "mapa13":
                      case "mapa14":
                      case "mapa15":
                      case "mapa16":
                      case "mapa17":
                      case "mapa18":
                      case "mapa19":
                      case "mapa20":
                      case "mapa21":
                      case "mapa22":
                      case "mapa23":
                          String num = str1.split("pa")[1];
                          //myBrowser.loadUrl("file:///android_asset/"+message+"_"+lenguage+".html");
                          myBrowser.loadUrl("file:///android_asset/mapa_"+lenguage+".html#"+num);
                          break;

                      default:
                          last = str1;
                          myBrowser.loadUrl("file:///android_asset/"+str1+"_"+lenguage+".html");
                          break;
                  }
                  String texttoast = "";
                switch (current) {
                    case "agropecuaria-cruce":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_agropecuaria_ext);
                        break;
                    case "agropecuaria-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fca);
                        break;
                    case "biblioteca-cruce":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_biblioteca_ext);
                        break;
                    case "biblioteca-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_biblioteca_int);
                        break;
                    case "comedor-cruce":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_comedor_cruce);
                        break;
                    case "comedor-ext":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_comedor_ext);
                        break;
                    case "comedor-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_comedor_int);
                        break;
                    case "construccion-cruce":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_construccion_ext);
                        break;
                    case "construccion-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fc);
                        break;
                    case "economia-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fce);
                        break;
                    case "electrica-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fie);
                        break;
                    case "entrada":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_entrada);
                        break;
                    case "humanidades-ext":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_humanidades_ext);
                        break;
                    case "humanidades-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fhcs);
                        break;
                    case "jardin":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_jardin);
                        break;
                    case "mfc-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fmfc);
                        break;
                    case "mecanica-int":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fimifq);
                        break;
                    case "mfc-cruce":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_mfc_ext);
                        break;
                    case "rectorado":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_rectorado);
                        break;
                    case "salahistoria":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_salahistoria);
                        break;
                    case "teatro-cruce":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_teatro);
                        break;
                    case "pentrada":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_pentrada);
                        break;
                    case "pexteriorsalahistoria":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_pexteriorsalahistoria);
                        break;
                    case "pfacultadmedia":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fem);
                        break;
                    case "pbiblioteca":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_pbiblioteca);
                        break;
                    case "pfacultadinfantil":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fei);
                        break;
                    case "pcolegio":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_pcolegio);
                        break;
                    case "pbeca":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_pbeca);
                        break;
                    case "pcomedor":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_pcomedor);
                        break;
                    case "fentrada":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_fentrada);
                        break;
                    case "flobi":
                        texttoast = CentralActivity.this.getString(R.string.title_toast_flobi);
                        break;
                    case "fplaza":
                        break;
                    case "fcruce":
                        break;
                    case "fgimnacio":
                                break;
                            }

                  if(texttoast.equalsIgnoreCase("")){

                  }else{
                      Toast.makeText(param1Context, texttoast, Toast.LENGTH_SHORT).show();
                  }

                  break;
              case "imagen":
                  //Intent i = new Intent(context, ImageDialog.class);
                  switch (str1) {
                      case "areasdeportivas":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_areas_dep), "areasdeportivas");
                          break;
                      case "becas900":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_res_est_900), "becas900");
                          break;
                      case "becasc":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_res_est_camilito), "becasc");
                          break;
                      case "becasu":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_res_est_u), "becasu");
                          break;
                      case "boladecannon":
                          CentralActivity.this.crearDialogoSlider("", "jardinarbolbolacannon");
                          break;
                      case "cartel":
                          CentralActivity.this.crearDialogoSlider("", "ent_valla");
                          break;
                      case "ceed":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_activity_cee), "ceed");
                          break;
                      case "ceiba":
                          CentralActivity.this.crearDialogoSlider("", "jardinceiba");
                          break;
                      case "centralito":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_centralito), "centralito");
                          break;
                      case "comedorcamilito":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_comedor_camilito), "comedorcamilito");
                          break;
                      case "comunicacion":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_comunicacion), "comunicacion");
                          break;
                      case "coronado":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_coronado), "coronado");
                          break;
                      case "direccione":
                          CentralActivity.this.crearDialogoSlider("", "ent_direccione");
                          break;
                      case "feu":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_casafeu), "casafeu");
                          break;
                      case "florbrasilenna":
                          CentralActivity.this.crearDialogoSlider("", "jardinflorbrasilenna");
                          break;
                      case "florguinea":
                          CentralActivity.this.crearDialogoSlider("", "jardinflorguinea");
                          break;
                      case "hotelito":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_hotelito), "hotelito");
                          break;
                      case "ingreso":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_ingreso), "ingreso");
                          break;
                      case "jardinbambu":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_toast_jardin), "jardinbambu");
                          break;
                      case "jardincartel":
                          CentralActivity.this.crearDialogoSlider("", "jardincartel");
                          break;
                      case "marta":
                          CentralActivity.this.crearDialogoSlider("", "ecultura_marta");
                          break;
                      case "muralh":
                          CentralActivity.this.crearDialogoSlider("", "human_mural");
                          break;
                      case "panaderia":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_panaderia), "panaderia");
                          break;
                      case "elect_paneles":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_paneles), "elect_paneles");
                          break;
                      case "pisoh":
                          CentralActivity.this.crearDialogoSlider("", "human_piso");
                          break;
                      case "policlinico":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_policlinico), "policlinico");
                          break;
                      case "rectorado":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_rectorado), "rectorado");
                          break;
                      case "rechum":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_rec_hum), "recursoshumanos");
                          break;
                      case "relint":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_rel_int), "rel_internacionales");
                          break;
                      case "salahist_placa":
                          CentralActivity.this.crearDialogoSlider("", "salahist_placa");
                          break;
                      case "salahistoria":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_sala_hist), "salahistoria");
                          break;
                      case "salchicha":
                          CentralActivity.this.crearDialogoSlider("", "jardinarbolsalchicha");
                          break;
                      case "tarjah":
                          CentralActivity.this.crearDialogoSlider("", "human_placa");
                          break;
                      case "tarjash":
                          CentralActivity.this.crearDialogoSlider("", "sala_historia");
                          break;
                      case "teatro":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_toast_teatro), "teatro");
                          break;
                      case "transporte":
                          CentralActivity.this.crearDialogoSlider(CentralActivity.this.getString(R.string.title_dialog_transporte), "transporte");
                          break;
                      case "trepadora":
                          CentralActivity.this.crearDialogoSlider("", "jardintrepadora");
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
                      case "agropecuaria":
                          Intent infoagropecuaria = new Intent(param1Context, FCAActivity.class);
                          CentralActivity.this.startActivity(infoagropecuaria);
                          break;
                      case "cbq":
                          Intent infocbq = new Intent((Context)param1Context, CBQActivity.class);
                          CentralActivity.this.startActivity(infocbq);
                          break;
                      case "cec":
                          Intent infocec = new Intent((Context)param1Context, CECActivity.class);
                          CentralActivity.this.startActivity(infocec);
                          break;
                      case "ced":
                          Intent infoced = new Intent((Context)param1Context, CEDActivity.class);
                          CentralActivity.this.startActivity(infoced);
                          break;
                      case "ceed":
                          Intent infoceed = new Intent((Context)param1Context, CEEDActivity.class);
                          CentralActivity.this.startActivity(infoceed);
                          break;
                      case "cee":
                          Intent infocee = new Intent((Context)param1Context, CEEActivity.class);
                          CentralActivity.this.startActivity(infocee);
                          break;
                      case "ceqa":
                          Intent infoceqa = new Intent((Context)param1Context, CEQAActivity.class);
                          CentralActivity.this.startActivity(infoceqa);
                          break;
                      case "ceta":
                          Intent infoceta = new Intent((Context)param1Context, CETAActivity.class);
                          CentralActivity.this.startActivity(infoceta);
                          break;
                      case "ciap":
                          Intent infociap = new Intent((Context)param1Context, CIAPActivity.class);
                          CentralActivity.this.startActivity(infociap);
                          break;
                      case "cidema":
                          Intent infocidema = new Intent((Context)param1Context, CIDEMActivity.class);
                          CentralActivity.this.startActivity(infocidema);
                          break;
                      case "cis":
                          Intent infocis = new Intent((Context)param1Context, CISActivity.class);
                          CentralActivity.this.startActivity(infocis);
                          break;
                      case "ibp":
                          Intent infoibp = new Intent((Context)param1Context, IBPActivity.class);
                          CentralActivity.this.startActivity(infoibp);
                          break;
                      case "cei":
                          Intent infocei = new Intent((Context)param1Context, CEIActivity.class);
                          CentralActivity.this.startActivity(infocei);
                          break;
                      case "construccion":
                          Intent infoconstruccion = new Intent((Context)param1Context, FCActivity.class);
                          CentralActivity.this.startActivity(infoconstruccion);
                          break;
                      case "economia":
                          Intent infoeconomia = new Intent((Context)param1Context, FCEActivity.class);
                          CentralActivity.this.startActivity(infoeconomia);
                          break;
                      case "electrica":
                          Intent infoelectrica = new Intent((Context)param1Context, FIEActivity.class);
                          CentralActivity.this.startActivity(infoelectrica);
                          break;
                      case "farmacia":
                          Intent infofarmacia = new Intent((Context)param1Context, FQFActivity.class);
                          CentralActivity.this.startActivity(infofarmacia);
                          break;
                      case "humanidades":
                          Intent infohumanidades = new Intent((Context)param1Context, FHActivity.class);
                          CentralActivity.this.startActivity(infohumanidades);
                          break;
                      case "jardin":
                          Intent infojardin = new Intent((Context)param1Context, JardinActivity.class);
                          CentralActivity.this.startActivity(infojardin);
                          break;
                      case "mecanica":
                          Intent infomecanica = new Intent((Context)param1Context, FIMIActivity.class);
                          CentralActivity.this.startActivity(infomecanica);
                          break;
                      case "mfc":
                          Intent infomfc = new Intent((Context)param1Context, FMFCActivity.class);
                          CentralActivity.this.startActivity(infomfc);
                          break;
                      case "planetario":
                          Intent infoplanetario = new Intent((Context)param1Context, CEMNIActivity.class);
                          CentralActivity.this.startActivity(infoplanetario);
                          break;
                      case "sociales":
                          Intent infosociales = new Intent((Context)param1Context, FCSActivity.class);
                          CentralActivity.this.startActivity(infosociales);
                          break;
                  }
                  break;
              case "galeria":
                  Intent galeria = new Intent(param1Context, ViewPage_activity.class);
                  galeria.putExtra("id", Integer.parseInt(str1)/2);
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
    byte b = -1;
    switch (str2) {
      default:
        this.current = "entrada";
            if (str1 == this.current && this.current == "entrada")
              salir(); 
            this.myBrowser.loadUrl("file:///android_asset/entrada_" + this.lenguage + ".html");
            break;
          case "mapa1":
          case "mapa2":
          case "mapa3":
          case "mapa4":
          case "mapa5":
          case "mapa6":
          case "mapa7":
          case "mapa8":
          case "mapa9":
          case "mapa10":
          case "mapa11":
          case "mapa12":
          case "mapa13":
          case "mapa14":
          case "mapa15":
          case "mapa16":
          case "mapa17":
          case "mapa18":
          case "mapa19":
          case "mapa20":
          case "mapa21":
          case "mapa22":
          case "mapa23":
            this.myBrowser.loadUrl("file:///android_asset/" + this.last + "_" + this.lenguage + ".html");
            this.current = this.last;
            break;
          case "galeria":
            this.myBrowser.loadUrl("file:///android_asset/" + this.last + "_" + this.lenguage + ".html");
            this.current = this.last;
            break;
          case "comedor-int":
            this.myBrowser.loadUrl("file:///android_asset/comedor-cruce_" + this.lenguage + ".html");
            this.current = "comedor-cruce";
            break;
          case "electrica-int":
            this.myBrowser.loadUrl("file:///android_asset/biblioteca-cruce_" + this.lenguage + ".html");
            this.current = "biblioteca-cruce";
            break;
          case "biblioteca-int":
            this.myBrowser.loadUrl("file:///android_asset/biblioteca-cruce_" + this.lenguage + ".html");
            this.current = "biblioteca-cruce";
            break;
          case "economia-int":
            this.myBrowser.loadUrl("file:///android_asset/biblioteca-cruce_" + this.lenguage + ".html");
            this.current = "biblioteca-cruce";
            break;
          case "agropecuaria-int":
            this.myBrowser.loadUrl("file:///android_asset/agropecuaria-cruce_" + this.lenguage + ".html");
            this.current = "agropecuaria-cruce";
            break;
          case "construccion-int":
            this.myBrowser.loadUrl("file:///android_asset/construccion-cruce_" + this.lenguage + ".html");
            this.current = "construccion-cruce";
            break;
          case "humanidades-int":
            this.myBrowser.loadUrl("file:///android_asset/rectorado_" + this.lenguage + ".html");
            this.current = "entrada";
            break;
          case "mfc-int":
            this.myBrowser.loadUrl("file:///android_asset/mfc-cruce_" + this.lenguage + ".html");
            this.current = "mfc-cruce";
            break;
          case "jardin":
            this.myBrowser.loadUrl("file:///android_asset/comedor-cruce_" + this.lenguage + ".html");
            this.current = "comedor-cruce";
            break;
          case "mecanica-int":
            this.myBrowser.loadUrl("file:///android_asset/humanidades-cruce_" + this.lenguage + ".html");
            this.current = "humanidades-cruce";
            break;
          case "teatro":
            this.myBrowser.loadUrl("file:///android_asset/teatro-cruce_" + this.lenguage + ".html");
            this.current = "teatro-cruce";
            break;
          case "ingreso":
            this.myBrowser.loadUrl("file:///android_asset/rectorado_" + this.lenguage + ".html");
            this.current = "rectorado";
            break;
          case "salahistoria":
            this.myBrowser.loadUrl("file:///android_asset/entrada_" + this.lenguage + ".html");
            this.current = "entrada";
            break;
          case "jardin2":
          case "jardin4":
            this.myBrowser.loadUrl("file:///android_asset/jardin_" + this.lenguage + ".html");
            this.current = "jardin";
            break;
          case "salahistoria1":
          case "salahistoria2":
          case "salahistoria3":
            this.myBrowser.loadUrl("file:///android_asset/salahistoria_" + this.lenguage + ".html");
            this.current = "entrada";
            break;
    }
  }
  
  @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB_MR1)
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    this.lenguage = (new Configuration(getResources().getConfiguration())).locale.getLanguage();
    DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle((Activity)this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawerLayout.setDrawerListener((DrawerLayout.DrawerListener)actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();
    ((NavigationView)findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
    this.myBrowser = (WebView)findViewById(R.id.mybrowser);
    WebSettings webSettings = this.myBrowser.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    Bundle bundle = getIntent().getExtras();
    if (bundle == null) {
      this.myBrowser.loadUrl("file:///android_asset/entrada_" + this.lenguage + ".html");
    } else {
      String str = bundle.getString("pano", "entrada");
      this.myBrowser.loadUrl("file:///android_asset/" + str + "_" + this.lenguage + ".html");
    } 
    this.myBrowser.addJavascriptInterface(new CIntermediario(this), "Android");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(R.menu.activity_main_drawer, paramMenu);
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
    if (i == R.id.nav_agropecuaria) {
      this.myBrowser.loadUrl("file:///android_asset/agropecuaria-int_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_computacion) {
      this.myBrowser.loadUrl("file:///android_asset/mfc-int_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_construccion) {
      this.myBrowser.loadUrl("file:///android_asset/construccion-int_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_economia) {
      this.myBrowser.loadUrl("file:///android_asset/economia-int_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_electrica) {
      this.myBrowser.loadUrl("file:///android_asset/electrica-int_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_farmacia) {
      this.myBrowser.loadUrl("file:///android_asset/mecanica-int_" + this.lenguage + ".html");
      ((DrawerLayout)findViewById(R.id.drawer_layout)).closeDrawer(GravityCompat.START);
      return true;
    } 
    if (i == R.id.nav_humanidades) {
      this.myBrowser.loadUrl("file:///android_asset/humanidades-int_" + this.lenguage + ".html");
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
    LocalBroadcastManager.getInstance((Context)this).registerReceiver(this.mMessageReceiver, new IntentFilter("my-event-c"));
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\CentralActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */