package com.uclv.dte;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class Intermediario {
  InicialActivity mContext;
  
  Intermediario(InicialActivity paramInicialActivity) {
    this.mContext = paramInicialActivity;
  }
  
  private void sendMessage(String paramString1, String paramString2) {
    Intent intent = new Intent("my-event-i");
    intent.putExtra("type", paramString1);
    intent.putExtra("message", paramString2);
    LocalBroadcastManager.getInstance((Context)this.mContext).sendBroadcast(intent);
  }
  
  @JavascriptInterface
  public void showSede(String paramString) {
    sendMessage("sede", paramString);
  }
  
  @JavascriptInterface
  public void showToast(String paramString) {
    Toast.makeText((Context)this.mContext, paramString, Toast.LENGTH_SHORT).show();
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\Intermediario.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */