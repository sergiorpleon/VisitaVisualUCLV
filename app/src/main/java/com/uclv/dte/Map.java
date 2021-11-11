package com.uclv.dte;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.util.AndroidUtil;
import org.mapsforge.map.android.view.MapView;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.overlay.Marker;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.rendertheme.InternalRenderTheme;
import org.mapsforge.map.rendertheme.XmlRenderTheme;

public class Map extends AppCompatActivity {
  GoogleMap map;
  
  private MapView mapView;
  
  Marker marker;
  
  private TileCache tileCache;
  
  private TileRendererLayer tileRendererLayer;
  
  public void irCentral(View paramView) {
    (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)15);
    (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4375939D, -79.8989822D));
  }
  
  public void irFajardo(View paramView) {
    (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)17);
    (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.40511D, -79.95183D));
  }
  
  public void irPedagogico(View paramView) {
    (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)17);
    (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.42335D, -79.95749D));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    AndroidGraphicFactory.createInstance(getApplication());
    setContentView(R.layout.activity_map);
    this.mapView = (MapView)findViewById(R.id.mapView);
    this.mapView.setLayerType(1, null);
    this.mapView.setClickable(true);
    this.tileCache = AndroidUtil.createTileCache((Context)this, "mapcache", (this.mapView.getModel()).displayModel.getTileSize(), 1.0F, (this.mapView.getModel()).frameBufferModel.getOverdrawFactor());
    File file = new File(getCacheDir() + "/sc5.map");
    try {
      InputStream inputStream = getAssets().open("sc5.map");
      byte[] arrayOfByte = new byte[inputStream.available()];
      inputStream.read(arrayOfByte);
      inputStream.close();
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write(arrayOfByte);
      fileOutputStream.close();
      this.tileRendererLayer = new TileRendererLayer(this.tileCache, (this.mapView.getModel()).mapViewPosition, false, (GraphicFactory)AndroidGraphicFactory.INSTANCE);
      this.tileRendererLayer.setMapFile(new File(file.getPath()));
      Log.d("PATH", file.getPath());
      Log.d("PATH", file.getTotalSpace() + "");
      Toast.makeText((Context)this, file.getPath(), Toast.LENGTH_SHORT);
      this.tileRendererLayer.setXmlRenderTheme((XmlRenderTheme)InternalRenderTheme.OSMARENDER);
      this.mapView.getLayerManager().getLayers().add((Layer)this.tileRendererLayer);
      this.mapView.setBuiltInZoomControls(true);
      this.mapView.getMapScaleBar().setVisible(true);
      this.mapView.getMapZoomControls().setZoomLevelMin((byte)12);
      this.mapView.getMapZoomControls().setZoomLevelMax((byte)20);
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)12);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.42465D, -79.92769D));
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.contrucciones_fill_1());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.construciones_stroke_1());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.contrucciones_fill_2());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.construciones_stroke_2());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.contrucciones_fill_3());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.construciones_stroke_3());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.economia_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.economia_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.mecanica_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.mecanica_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.humanidades_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.humanidades_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.electrica_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.electrica_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u1_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u1_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u2_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u2_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u3_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u3_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u5_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u5_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.novecientos_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.novecientos_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u10_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u10_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u11_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u11_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u12_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.u12_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c2_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c2_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c3_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c3_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c4_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c4_stroke());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c5_fill());
      this.mapView.getLayerManager().getLayers().add((Layer)MapBuilding.c5_stroke());
      MyMarker myMarker = new MyMarker((Context)this, new LatLong(22.44492D, -79.89491D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("fca");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.44428D, -79.89593D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("fca_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43831D, -79.89261D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("fc");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43858D, -79.89488D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("deporte");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43728D, -79.89757D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("becas");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43635D, -79.89794D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("comedor");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43627D, -79.89828D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("comedor_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43315D, -79.89569D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("jardin");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43655D, -79.89963D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("teatro");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43708D, -79.89941D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("teatro_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43575D, -79.90042D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("biblioteca");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43574D, -79.90098D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("biblioleca_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.4361D, -79.89987D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("ingreso");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43654D, -79.90073D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("rectorado");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43372D, -79.90052D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("electrica");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43525D, -79.90171D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("economia");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43529D, -79.90344D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("mecanica");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43624D, -79.90172D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("humanidades");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43579D, -79.90279D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("humanidades_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43624D, -79.9031D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("sala_historia");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43572D, -79.90444D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("mfc_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43572D, -79.90553D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("mfc");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.43735D, -79.90289D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_central_24dp)), 0, -20);
      myMarker.setPlace("entrada");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42465D, -79.95769D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pentrada");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42437D, -79.95785D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("psh_exterior");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42445D, -79.95785D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("psh");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42436D, -79.95776D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pfm");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42437D, -79.95761D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pfi");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.4244D, -79.95738D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pbiblioteca_ext");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42422D, -79.95749D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pbiblioteca");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42389D, -79.95781D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pcolegio");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42335D, -79.95749D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pcomedor");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42335D, -79.95824D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("pbeca");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.42232D, -79.95747D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_pedagogico_24dp)), 0, -20);
      myMarker.setPlace("psalida");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.40489D, -79.9525D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_fajardo_24dp)), 0, -20);
      myMarker.setPlace("fentrada");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.40511D, -79.95253D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_fajardo_24dp)), 0, -20);
      myMarker.setPlace("flobi");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.40535D, -79.95244D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_fajardo_24dp)), 0, -20);
      myMarker.setPlace("fplaza");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.40511D, -79.95183D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_fajardo_24dp)), 0, -20);
      myMarker.setPlace("fcruce");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.40512D, -79.95141D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_fajardo_24dp)), 0, -20);
      myMarker.setPlace("ftabloncillo");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      myMarker = new MyMarker((Context)this, new LatLong(22.40484D, -79.95103D), AndroidGraphicFactory.convertToBitmap(getResources().getDrawable(R.drawable.ic_place_fajardo_24dp)), 0, -20);
      myMarker.setPlace("fpista");
      this.mapView.getLayerManager().getLayers().add((Layer)myMarker);
      return;
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(R.menu.map, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    int i = paramMenuItem.getItemId();
    if (i == R.id.central_fmfc) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43572D, -79.90532D));
      Toast.makeText((Context)this, getText(R.string.title_activity_fmfc), Toast.LENGTH_SHORT);
    } 
    if (i == R.id.central_fh) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fh), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43585D, -79.90208D));
    } 
    if (i == R.id.central_fcs) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fcs), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43641D, -79.9021D));
    } 
    if (i == R.id.central_fqf) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fqf), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43523D, -79.90397D));
    } 
    if (i == R.id.central_fimi) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fimi), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43516D, -79.90325D));
    } 
    if (i == R.id.central_fce) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fce), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43511D, -79.90189D));
    } 
    if (i == R.id.central_fie) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fie), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4334D, -79.9003D));
    } 
    if (i == R.id.central_fc) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fc), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43887D, -79.89251D));
    } 
    if (i == R.id.central_fca) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fca), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.44513D, -79.8949D));
    } 
    if (i == R.id.pedagogico_fem) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fem), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.42411D, -79.95787D));
    } 
    if (i == R.id.pedagogico_fei) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_fei), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.42448D, -79.95761D));
    } 
    if (i == R.id.fajardo_fcf) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)18);
      Toast.makeText((Context)this, getText(R.string.title_activity_fcf), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.40519D, -79.95273D));
    } 
    if (i == R.id.central_ced) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_ced), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4443D, -79.89616D));
    } 
    if (i == R.id.central_cejb) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cejb), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43327D, -79.89546D));
    } 
    if (i == R.id.central_cemni) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cemni), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43418D, -79.90105D));
    } 
    if (i == R.id.central_ciap) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_ciap), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.44513D, -79.8949D));
    } 
    if (i == R.id.central_cidem) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cidem), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43887D, -79.89251D));
    } 
    if (i == R.id.central_cec) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cec), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43641D, -79.9021D));
    } 
    if (i == R.id.central_cee) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cee), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4334D, -79.9003D));
    } 
    if (i == R.id.central_cis) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cis), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43516D, -79.90325D));
    } 
    if (i == R.id.central_ceta) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_ceta), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43516D, -79.90325D));
    } 
    if (i == R.id.central_ceqa) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_ceqa), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43597D, -79.89169D));
    } 
    if (i == R.id.central_cei) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cei), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4352D, -79.90257D));
    } 
    if (i == R.id.pedagogico_ceed) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_ceed), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4443D, -79.89616D));
    } 
    if (i == R.id.fajardo_cecfd) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)18);
      Toast.makeText((Context)this, getText(R.string.title_activity_cecfd), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.40519D, -79.95273D));
    } 
    if (i == R.id.central_cbq) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_cbq), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43612D, -79.90408D));
    } 
    if (i == R.id.central_ibp) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_activity_ibp), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.44487D, -79.89397D));
    } 
    if (i == R.id.central_rectorado) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_toast_rectorado), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43674D, -79.90037D));
    } 
    if (i == R.id.central_internacionalizacion) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_dialog_rel_int), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43603D, -79.90046D));
    } 
    if (i == R.id.central_teatro) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_toast_teatro), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43657D, -79.89963D));
    } 
    if (i == R.id.central_salahistoria) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)20);
      Toast.makeText((Context)this, getText(R.string.title_toast_salahistoria), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43624D, -79.90306D));
    } 
    if (i == R.id.central_biblioteca) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_toast_biblioteca_int), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43574D, -79.90034D));
    } 
    if (i == R.id.central_comedor) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_toast_comedor_int), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.4364D, -79.89784D));
    } 
    if (i == R.id.central_feu) {
      (this.mapView.getModel()).mapViewPosition.setZoomLevel((byte)19);
      Toast.makeText((Context)this, getText(R.string.title_dialog_casafeu), Toast.LENGTH_SHORT);
      (this.mapView.getModel()).mapViewPosition.setCenter(new LatLong(22.43832D, -79.89612D));
    } 
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onZoomEvent() {
    Log.d("CAMERA", "zoom");
    Toast.makeText((Context)this, "change", Toast.LENGTH_SHORT);
  }
}


/* Location:              C:\Users\Usuario\Videos\Visita Virtual a la UCLV\classes-dex2jar.jar\\uclv\dte\visitavirtualalauclv\Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */