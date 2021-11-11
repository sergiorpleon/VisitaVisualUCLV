package com.uclv.dte;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.uclv.dte.GaleriaActivity;

public class GIntermediario {
  GaleriaActivity mContext;
  
  GIntermediario(GaleriaActivity paramGaleriaActivity) {
    this.mContext = paramGaleriaActivity;
  }
  
  private void sendMessage(String paramString1, String paramString2) {
    Intent intent = new Intent("my-event-g");
    intent.putExtra("type", paramString1);
    intent.putExtra("message", paramString2);
    //Toast.makeText((Context)this.mContext, "send: "+paramString2, Toast.LENGTH_SHORT).show();
    LocalBroadcastManager.getInstance((Context)this.mContext).sendBroadcast(intent);
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


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\GIntermediario.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */