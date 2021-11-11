package com.uclv.dte;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AppWebClient extends WebViewClient {
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (Uri.parse(paramString).getHost().endsWith("indiependev.wordpress.com"))
      return false; 
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramWebView.getContext().startActivity(intent);
    return true;
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\AppWebClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */