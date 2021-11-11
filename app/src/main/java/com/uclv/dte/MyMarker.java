package com.uclv.dte;

import android.content.Context;
import android.content.Intent;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.layer.overlay.Marker;

public class MyMarker extends Marker {
  private Context ctx;
  
  private String place;
  
  public MyMarker(Context paramContext, LatLong paramLatLong, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    super(paramLatLong, paramBitmap, paramInt1, paramInt2);
    this.ctx = paramContext;
  }
  
  public boolean onTap(LatLong paramLatLong, Point paramPoint1, Point paramPoint2) {
    Intent intent;
    if (contains(paramPoint1, paramPoint2)) {
      if (this.place == "entrada") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "entrada");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "mfc") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "mfc-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "mfc_ext") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "mfc-cruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "sala_historia") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "salahistoria");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "humanidades_ext") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "humanidades-cruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "biblioteca_ext") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "biblioteca-crucet");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "biblioteca") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "biblioteca-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "rectorado") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "rectorado");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "ingreso") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "ingreso");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "teatro") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "teatro");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "teatro_ext") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "teatro-cruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "jardin") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "jardin");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "comedor_ext") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "comedor-cruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "comedor") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "comedor-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "becas") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "comedor-ext");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "deporte") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "comedor-ext");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fca_ext") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "construcciones-cruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "humanidades") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "humanidades-cruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "mecanica") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "mecanica-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "economia") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "economia-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "electrica") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "electrica-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fc") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "construccion-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fca") {
        intent = new Intent(this.ctx, CentralActivity.class);
        intent.putExtra("pano", "agropecuaria-int");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pentrada") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pentrada");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "psh") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "psalahistoria");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "psh_exterior") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pexteriorsalahistoria");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pbiblioteca_ext") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pexteriorbiblioteca");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pbiblioteca") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pbiblioteca");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pfm") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pfacultadmedia");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pfi") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pfacultadinfantil");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pcolegio") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pcolegio");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pcomedor") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pcomedor");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "pbeca") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "pbeca");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "psalida") {
        intent = new Intent(this.ctx, PedagogicoActivity.class);
        intent.putExtra("pano", "psalida");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fentrada") {
        intent = new Intent(this.ctx, FajardoActivity.class);
        intent.putExtra("pano", "fentrada");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "flobi") {
        intent = new Intent(this.ctx, FajardoActivity.class);
        intent.putExtra("pano", "fentrada");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fplaza") {
        intent = new Intent(this.ctx, FajardoActivity.class);
        intent.putExtra("pano", "fplaza");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fcruce") {
        intent = new Intent(this.ctx, FajardoActivity.class);
        intent.putExtra("pano", "fcruce");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "ftabloncillo") {
        intent = new Intent(this.ctx, FajardoActivity.class);
        intent.putExtra("pano", "fgimnasio");
        this.ctx.startActivity(intent);
      } 
      if (this.place == "fpista") {
        intent = new Intent(this.ctx, FajardoActivity.class);
        intent.putExtra("pano", "fpista");
        this.ctx.startActivity(intent);
      } 
      return true;
    } 
    return super.onTap((LatLong)paramLatLong, paramPoint1, paramPoint2);
  }
  
  public void setPlace(String paramString) {
    this.place = paramString;
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\MyMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */