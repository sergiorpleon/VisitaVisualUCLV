package com.uclv.dte;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by SERGIO-PC on 15/02/2019.
 */

public class SliderDialog extends Activity {
  private WebView mDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.layout_galery);

    Display display = getWindowManager().getDefaultDisplay();
    int width = display.getWidth();
    int height = display.getHeight();




    mDialog = (WebView) findViewById(R.id.galeria_image);
//activamos javascript
    WebSettings settings = mDialog.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setDomStorageEnabled(true);


    Bundle bundle = getIntent().getExtras();



    switch (getIntent().getIntExtra("url", 0)){
      case 1:
        mDialog.loadUrl("file:///android_asset/slider/indexgaleria.html");
        break;
      default:
        mDialog.loadUrl("file:///android_asset/slider/indexgaleria.html");
        break;
    }



    mDialog.getLayoutParams().height = height;
    mDialog.getLayoutParams().width = width;
    mDialog.setClickable(true);

    //finish the activity (dismiss the image dialog) if the user clicks
    //anywhere on the image
    mDialog.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

  }
}