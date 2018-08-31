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
        new Handler().postDelayed(() -> startActivity(new Intent(SplashScreenActivity.this,PrincipalActivity.class)),5300);
    }

    private void setData(){
        listaCanciones.put("Es Por Ti",new Cancion("Es Por Ti","Pop Latino","Pa Dentro",500,R.drawable.cancion,"Juanes"));
        listaCanciones.put("Waiting For Love",new Cancion("Waiting For Love","Electronica","Stories",300,R.drawable.cancion,"Avicii"));
        listaCanciones.put("The Nights",new Cancion("The Nights","Electronica","Stories",600,R.drawable.cancion,"Avicii"));
        listaCanciones.put("Time On MyHands",new Cancion("Time On MyHands","Pop Rock","As Time Goes By",800,R.drawable.cancion,"Bryan Ferry"));
        listaCanciones.put("Boulevard of Broken Dreams",new Cancion("Boulevard of Broken Dreams","Punk Rock","American Idiot",500,R.drawable.cancion,"Green Day"));
        listaCanciones.put("Another Brick in the Wall",new Cancion("Another Brick in the Wall","Rock","The Wall",500,R.drawable.cancion,"Pink Floyd"));
        listaCanciones.put("Bohemian Rhapsody",new Cancion("Bohemian Rhapsody","Rock","A Night at the Opera",500,R.drawable.cancion,"Queen"));
        listaCanciones.put("Blitzkrieg Bop",new Cancion("Blitzkrieg Bop","Punk","Ramones",500,R.drawable.cancion,"Ramones"));
        listaCanciones.put("Bella",new Cancion("Bella","Reggaeton","Bella",500,R.drawable.cancion,"Maluma"));
        listaCanciones.put("Flojos de pantalón",new Cancion("Flojos de pantalón","Rock","Jugar al gua",500,R.drawable.cancion,"Rosendo"));
        listaCanciones.put("A quién le importa",new Cancion("A quién le importa","Electronica","Operación Vodevil",500,R.drawable.cancion,"Fangoria"));
    }
}
