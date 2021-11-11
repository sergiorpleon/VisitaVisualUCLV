package com.uclv.dte;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;



import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class ImageDialog extends Activity {
  private ImageView mDialog;
  
  private WebView myBrowser;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.layout_imagen);
    Display display = getWindowManager().getDefaultDisplay();
    int i = display.getWidth();
    int j = display.getHeight();
    getIntent().getExtras();
    this.mDialog = (ImageView)findViewById(R.id.your_image);
    switch (getIntent().getIntExtra("url", 0)) {
    
    } 
    (this.mDialog.getLayoutParams()).height = j;
    (this.mDialog.getLayoutParams()).width = i;
    this.mDialog.setClickable(true);
    this.mDialog.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            ImageDialog.this.finish();
          }
        });
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\ImageDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */