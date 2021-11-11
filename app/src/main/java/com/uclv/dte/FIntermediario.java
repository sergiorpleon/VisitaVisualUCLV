package com.uclv.dte;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class FIntermediario {
  FajardoActivity mContext;
  
  FIntermediario(FajardoActivity paramFajardoActivity) {
    this.mContext = paramFajardoActivity;
  }
  
  private void sendMessage(String paramString1, String paramString2) {
    Intent intent = new Intent("my-event-f");
    intent.putExtra("type", paramString1);
    intent.putExtra("message", paramString2);
    LocalBroadcastManager.getInstance((Context)this.mContext).sendBroadcast(intent);
  }
  
  @JavascriptInterface
  public void showDialog(String paramString) {
    sendMessage("", paramString);
  }
  
  @JavascriptInterface
  public void showImagen(String paramString) {
    sendMessage("imagen", paramString);
  }
  
  @JavascriptInterface
  public void showInfo(String paramString) {
    sendMessage("info", paramString);
  }
  
  @JavascriptInterface
  public void showPano(String paramString) {
    sendMessage("pano", paramString);
  }
  
  @JavascriptInterface
  public void showToast(String paramString) {
    Toast.makeText((Context)this.mContext, paramString, Toast.LENGTH_SHORT).show();
  }
  
  @JavascriptInterface
  public void showofGaleria(String paramString) {
    sendMessage("galeria", paramString);
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\FIntermediario.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */