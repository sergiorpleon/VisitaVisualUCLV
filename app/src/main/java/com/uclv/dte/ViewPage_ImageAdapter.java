package com.uclv.dte;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by SERGIO-PC on 22/02/2019.
 */

public class ViewPage_ImageAdapter extends PagerAdapter{
  private Context context;

  public String[] images = new String[] {
          "slider/img/valla.jpg",
          "slider/img/marta.jpg",
          "slider/img/rectorado.jpg",
          "slider/img/policlinico.jpg",
          "slider/img/relaciones internacionales.jpg",
          "slider/img/Sala 35 aniversario.jpg",
          "slider/img/Recursos humanos.jpg",
          "slider/img/salahistoria/saladehistoria1.jpg",
          "slider/img/salahistoria/saladehistoria2.jpg",
          "slider/img/salahistoria/saladehistoria3.jpg",
          "slider/img/agropecuaria/ceed.jpg",
          "slider/img/agropecuaria/comedorcamilito.jpg",
          "slider/img/agropecuaria/hotelito.jpg",
          "slider/img/agropecuaria/IBP.jpg",
          "slider/img/agropecuaria/Residencia Estudiantil Camilito.jpg",
          "slider/img/areasdeportivas/SEDER.jpg",
          "slider/img/areasdeportivas/SEDER piscina.jpg",
          "slider/img/areasdeportivas/areasdeportivas.jpg",
          "slider/img/areasdeportivas/criollos1.jpg",
          "slider/img/areasdeportivas/criollos2.jpg",
          "slider/img/areasdeportivas/criollos3.jpg",
          "slider/img/areasdeportivas/criollos4.jpg",
          "slider/img/construccion/panaderia.jpg",
          "slider/img/cbq/CBQ.jpg",
          "slider/img/cbq/CBQ planta de produccion.jpg",
          "slider/img/cei/CEI.jpg",
          "slider/img/cei/CEI-int.jpg",
          "slider/img/construccion/Construcciones.jpg",
          "slider/img/construccion/Construcciones1.jpg",
          "slider/img/construccion/Construcciones2.jpg",
          "slider/img/coronado/coronado1.jpg",
          "slider/img/coronado/coronado2.jpg",
          "slider/img/coronado/coronado4.jpg",
          "slider/img/coronado/coronado5.jpg",
          "slider/img/economia/Ciencias Economicas.jpg",
          "slider/img/economia/Ciencias Economicas1.jpg",
          "slider/img/economia/Ciencias Economicas2.jpg",
          "slider/img/Electrica.jpg", "slider/img/electrica/elect1.jpg",
          "slider/img/electrica/elect2.jpg",
          "slider/img/electrica/elect3.jpg",
          "slider/img/electrica/FIE Grupo automatizacion, robotica y persepcion.jpg",
          "slider/img/electrica/FIE Laboratorio de electronica analogica.jpg",
          "slider/img/feu/Casa del Estudiante.jpg",
          "slider/img/feu/Casa estudiante 1.jpg",
          "slider/img/feu/Casa estudiante 2.jpg",
          "slider/img/feu/feu2.jpg",
          "slider/img/feu/feu3.jpg",
          "slider/img/feu/feu4.jpg",
          "slider/img/humanidades/Ciencias Sociales.jpg",
          "slider/img/humanidades/CentroEstudiosComunitarios.jpg",
          "slider/img/humanidades/hum1.jpg",
          "slider/img/humanidades/hum2.jpg",
          "slider/img/humanidades/hum3.jpg",
          "slider/img/humanidades/Humanidades.jpg",
          "slider/img/humanidades/soc1.jpg",
          "slider/img/humanidades/soc2.jpg",
          "slider/img/humanidades/soc3.jpg",
          "slider/img/jardin/cejb1.jpg",
          "slider/img/jardin/cejb2.jpg",
          "slider/img/jardin/cejb3.jpg",
          "slider/img/jardin/cejb4.jpg",
          "slider/img/farmacia/Quimica-Farmacia.jpg",
          "slider/img/farmacia/Quimica farmacia laboratorio.jpg",
          "slider/img/mecanica/Mecanica e Industrial.jpg",
          "slider/img/mecanica/mecaninca1.jpg",
          "slider/img/mecanica/Mecanica CISoldadura.jpg",
          "slider/img/mecanica/Mecanica Lab hidraulica.jpg",
          "slider/img/mecanica/Mecanica metrologia.jpg",
          "slider/img/mecanica/Mecanica Talleres.jpg",
          "slider/img/mecanica/taller de fundicion.jpg",
          "slider/img/mecanica/taller de motor2.jpg",
          "slider/img/mfc/Mat Fis y Comp.jpg",
          "slider/img/mfc/MFC ACM.jpg",
          "slider/img/mfc/MFC ACM1.jpg",
          "slider/img/mfc/MFC Lab computacion.jpg",
          "slider/img/mfc/MFC lab electromagnetismo.jpg",
          "slider/img/mfc/MFC lab electromagnetismo1.jpg",
          "slider/img/teatro/teatro1.jpg",
          "slider/img/teatro/teatro2.jpg",
          "slider/img/teatro/teatro3.jpg",
          "slider/img/teatro/teatro4.jpg",
          "slider/img/teatro/teatro5.jpg",
          "slider/img/Becas900.jpg",
          "pslider/img/estatuavarela.jpg",
          "pslider/img/mano.jpg",
          "pslider/img/media/arqueologia1.jpg",
          "pslider/img/media/labingles.jpg",
          "pslider/img/media/labquimica.jpg",
          "pslider/img/infantil/img.jpg",
          "fslider/img/cartelentrada.jpg",
          "fslider/img/salahistoria1.jpg",
          "fslider/img/volleyball.jpg" };

  public String[] titles;

  public ViewPage_ImageAdapter(Context paramContext) {
    this.context = paramContext;
    this.titles = new String[] {
            this.context.getString(R.string.img_1),
            this.context.getString(R.string.img_2),
            this.context.getString(R.string.img_3),
            this.context.getString(R.string.img_4),
            this.context.getString(R.string.img_5),
            this.context.getString(R.string.img_6),
            this.context.getString(R.string.img_7),
            this.context.getString(R.string.img_8),
            this.context.getString(R.string.img_9),
            this.context.getString(R.string.img_10),
            this.context.getString(R.string.img_11),
            this.context.getString(R.string.img_12),
            this.context.getString(R.string.img_13),
            this.context.getString(R.string.img_14),
            this.context.getString(R.string.img_15),
            this.context.getString(R.string.img_16),
            this.context.getString(R.string.img_17),
            this.context.getString(R.string.img_18),
            this.context.getString(R.string.img_19),
            this.context.getString(R.string.img_20),
            this.context.getString(R.string.img_21),
            this.context.getString(R.string.img_22),
            this.context.getString(R.string.img_23),
            this.context.getString(R.string.img_24),
            this.context.getString(R.string.img_25),
            this.context.getString(R.string.img_26),
            this.context.getString(R.string.img_27),
            this.context.getString(R.string.img_28),
            this.context.getString(R.string.img_29),
            this.context.getString(R.string.img_30),
            this.context.getString(R.string.img_31),
            this.context.getString(R.string.img_32),
            this.context.getString(R.string.img_33),
            this.context.getString(R.string.img_34),
            this.context.getString(R.string.img_35),
            this.context.getString(R.string.img_36),
            this.context.getString(R.string.img_37),
            this.context.getString(R.string.img_38),
            this.context.getString(R.string.img_39),
            this.context.getString(R.string.img_40),
            this.context.getString(R.string.img_41),
            this.context.getString(R.string.img_42),
            this.context.getString(R.string.img_43),
            this.context.getString(R.string.img_44),
            this.context.getString(R.string.img_45),
            this.context.getString(R.string.img_46),
            this.context.getString(R.string.img_47),
            this.context.getString(R.string.img_48),
            this.context.getString(R.string.img_49),
            this.context.getString(R.string.img_50),
            this.context.getString(R.string.img_51),
            this.context.getString(R.string.img_52),
            this.context.getString(R.string.img_53),
            this.context.getString(R.string.img_54),
            this.context.getString(R.string.img_55),
            this.context.getString(R.string.img_56),
            this.context.getString(R.string.img_57),
            this.context.getString(R.string.img_58),
            this.context.getString(R.string.img_59),
            this.context.getString(R.string.img_60),
            this.context.getString(R.string.img_61),
            this.context.getString(R.string.img_62),
            this.context.getString(R.string.img_63),
            this.context.getString(R.string.img_64),
            this.context.getString(R.string.img_65),
            this.context.getString(R.string.img_66),
            this.context.getString(R.string.img_67),
            this.context.getString(R.string.img_68),
            this.context.getString(R.string.img_69),
            this.context.getString(R.string.img_70),
            this.context.getString(R.string.img_71),
            this.context.getString(R.string.img_72),
            this.context.getString(R.string.img_73),
            this.context.getString(R.string.img_74),
            this.context.getString(R.string.img_75),
            this.context.getString(R.string.img_76),
            this.context.getString(R.string.img_77),
            this.context.getString(R.string.img_78),
            this.context.getString(R.string.img_79),
            this.context.getString(R.string.img_80),
            this.context.getString(R.string.img_81),
            this.context.getString(R.string.img_82),
            this.context.getString(R.string.img_83),
            this.context.getString(R.string.img_84),
            this.context.getString(R.string.img_85),
            this.context.getString(R.string.img_86),
            this.context.getString(R.string.img_87),
            this.context.getString(R.string.img_88),
            this.context.getString(R.string.img_89),
            this.context.getString(R.string.img_90),
            this.context.getString(R.string.img_91),
            this.context.getString(R.string.img_92),
            this.context.getString(R.string.img_93)
    };

  }

  @Override
  public int getCount() {
    return images.length;
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == ((View) object);
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View item = inflater.inflate(R.layout.activity_zoom, container, false);

    //---Accedo al campo title
    TextView lbltitle = (TextView) item.findViewById(R.id.idtitle);
    lbltitle.setText(titles[position]);

    //---Accedo al campo imagen
    TouchImageView imgview = (TouchImageView)item.findViewById(R.id.idzoomimg);
    //TouchImageView imgview = new TouchImageView(context);

    imgview.setImageResource(R.drawable.marta);
    InputStream in;
    try {
      String imagen = images[position]; //obtencion del nombre de la imagen
      //imagen = imagen.toLowerCase();
      in = context.getAssets().open(imagen); //obtencion de fichero input de la imagen a partir de su nombre
      Bitmap bitmap = BitmapFactory.decodeStream(in);
      imgview.setImageBitmap(bitmap);
    } catch (Exception e) {
      e.printStackTrace();
    }

    container.addView(item);
    return item;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object){
    ((ViewPager)container).removeView((View)object);
  }

}