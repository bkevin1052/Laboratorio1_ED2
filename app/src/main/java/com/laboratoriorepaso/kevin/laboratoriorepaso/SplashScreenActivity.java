package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.laboratoriorepaso.clases.Cancion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SplashScreenActivity extends Activity {


    ImageView imagen;
    TextView superior,inferior;

    //declaracion de hash table
    public static Map<String,Cancion> listaCanciones = new HashMap<>();;
    public static ArrayList<String> llaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        superior = (TextView)findViewById(R.id.tituloBienvenido);
        inferior = (TextView)findViewById(R.id.tituloZuper);
        imagen = (ImageView)findViewById(R.id.logoImagen);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.up_to_down);

        imagen.setAnimation(animation);
        superior.setAnimation(animation);
        inferior.setAnimation(animation);
        setData();
        llaves = new ArrayList<>(listaCanciones.keySet());
        new Handler().postDelayed(() -> startActivity(new Intent(SplashScreenActivity.this,PrincipalActivity.class)),3500);
    }

    private void setData(){
        listaCanciones.put("Es por ti",new Cancion("Es por ti","Pop Latino","Pa Dentro","5:36",R.drawable.cancion,"Juanes"));
        listaCanciones.put("Waiting for love",new Cancion("Waiting for love","Electronica","Stories","3:56",R.drawable.cancion,"Avicii"));
        listaCanciones.put("The nights",new Cancion("The nights","Electronica","Stories","1:56",R.drawable.cancion,"Avicii"));
        listaCanciones.put("Time on myhands",new Cancion("Time on myhands","Pop Rock","As Time Goes By","2:56",R.drawable.cancion,"Bryan Ferry"));
        listaCanciones.put("Boulevard of broken dreams",new Cancion("Boulevard of broken dreams","Punk Rock","American Idiot","0:56",R.drawable.cancion,"Green Day"));
        listaCanciones.put("Another brick in the wall",new Cancion("Another brick in the wall","Rock","The Wall","2:53",R.drawable.cancion,"Pink Floyd"));
        listaCanciones.put("Bohemian rhapsody",new Cancion("Bohemian rhapsody","Rock","A Night at the Opera","0:30",R.drawable.cancion,"Queen"));
        listaCanciones.put("Blitzkrieg bop",new Cancion("Blitzkrieg bop","Punk","Ramones","6:55",R.drawable.cancion,"Ramones"));
        listaCanciones.put("Bella",new Cancion("Bella","Reggaeton","Bella","4:20",R.drawable.cancion,"Maluma"));
        listaCanciones.put("Flojos de pantalon",new Cancion("Flojos de pantalon","Rock","Jugar al gua","3:57",R.drawable.cancion,"Rosendo"));
        listaCanciones.put("A quien le importa",new Cancion("A quien le importa","Electronica","Operación Vodevil","5:57",R.drawable.cancion,"Fangoria"));
    }
}
