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
    public static Map<String,Cancion> listaCanciones = new TreeMap<>();;
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
        new Handler().postDelayed(() -> startActivity(new Intent(SplashScreenActivity.this,PrincipalActivity.class)),4500);
    }

    private void setData(){
        listaCanciones.put("es por ti",new Cancion("es por ti","Pop Latino","Pa Dentro",500,R.drawable.cancion,"Juanes"));
        listaCanciones.put("waiting for love",new Cancion("waiting for love","Electronica","Stories",300,R.drawable.cancion,"Avicii"));
        listaCanciones.put("the nights",new Cancion("the nights","Electronica","Stories",600,R.drawable.cancion,"Avicii"));
        listaCanciones.put("time on myhands",new Cancion("time on myhands","Pop Rock","As Time Goes By",800,R.drawable.cancion,"Bryan Ferry"));
        listaCanciones.put("boulevard of broken dreams",new Cancion("boulevard of broken dreams","Punk Rock","American Idiot",500,R.drawable.cancion,"Green Day"));
        listaCanciones.put("another brick in the wall",new Cancion("another brick in the wall","Rock","The Wall",500,R.drawable.cancion,"Pink Floyd"));
        listaCanciones.put("bohemian rhapsody",new Cancion("bohemian rhapsody","Rock","A Night at the Opera",500,R.drawable.cancion,"Queen"));
        listaCanciones.put("blitzkrieg bop",new Cancion("blitzkrieg bop","Punk","Ramones",500,R.drawable.cancion,"Ramones"));
        listaCanciones.put("bella",new Cancion("bella","Reggaeton","Bella",500,R.drawable.cancion,"Maluma"));
        listaCanciones.put("flojos de pantalon",new Cancion("flojos de pantalon","Rock","Jugar al gua",500,R.drawable.cancion,"Rosendo"));
        listaCanciones.put("a quien le importa",new Cancion("a quien le importa","Electronica","Operación Vodevil",500,R.drawable.cancion,"Fangoria"));
    }
}
