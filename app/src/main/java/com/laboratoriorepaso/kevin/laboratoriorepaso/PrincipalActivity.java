package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.laboratoriorepaso.adaptador.AdapterCancion;
import com.laboratoriorepaso.clases.Cancion;

import java.util.HashMap;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterCancion adapterCancion;
    Button playList;

    //declaracion de hash table
    HashMap<String,Cancion> listaCanciones = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Indicando ID al objeto
        playList = (Button)findViewById(R.id.verPlaylist);
        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);
        //Creacion de canciones
        getData();

        //configuracion del adapter y recyclerview
        recyclerViewCancion.setLayoutManager(new LinearLayoutManager(this));
        adapterCancion = new AdapterCancion(this, listaCanciones);
        recyclerViewCancion.setAdapter(adapterCancion);

        adapterCancion.setOnClickListener(view -> {
            PlayListActivity.playList.add(listaCanciones.get(recyclerViewCancion.getChildAdapterPosition(view)));
            Toast.makeText(getApplicationContext(),"Canciones agregada a Play List",Toast.LENGTH_SHORT).show();
        });


        //Boton ver Play list
        playList.setOnClickListener(view->{
            startActivity(new Intent(PrincipalActivity.this,PlayListActivity.class));
        });
    }

    private void getData(){
        listaCanciones.put("Es Por Ti",new Cancion("Es Por Ti","Pop Latino","Pa Dentro",500,R.drawable.cancion,"Juanes"));
        listaCanciones.put("Waiting For Love",new Cancion("Waiting For Love","Electronica","Stories",300,R.drawable.cancion2,"Avicii"));
        listaCanciones.put("The Nights",new Cancion("The Nights","Electronica","Stories",600,R.drawable.cancion3,"Avicii"));
        listaCanciones.put("Time On MyHands",new Cancion("Time On MyHands","Pop Rock","As Time Goes By",800,R.drawable.cancion4,"Bryan Ferry"));
        listaCanciones.put("Boulevard of Broken Dreams",new Cancion("Boulevard of Broken Dreams","Punk Rock","American Idiot",500,R.drawable.cancion5,"Green Day"));
        listaCanciones.put("Another Brick in the Wall",new Cancion("Another Brick in the Wall","Rock","The Wall",500,R.drawable.cancion6,"Pink Floyd"));
        listaCanciones.put("Bohemian Rhapsody",new Cancion("Bohemian Rhapsody","Rock","A Night at the Opera",500,R.drawable.cancion7,"Queen"));
        listaCanciones.put("Blitzkrieg Bop",new Cancion("Blitzkrieg Bop","Punk","Ramones",500,R.drawable.cancion8,"Ramones"));
        listaCanciones.put("Bella",new Cancion("Bella","Reggaeton","Bella",500,R.drawable.cancion9,"Maluma"));
        listaCanciones.put("Flojos de pantalón",new Cancion("Flojos de pantalón","Rock","Jugar al gua",500,R.drawable.cancion10,"Rosendo"));
        listaCanciones.put("A quién le importa",new Cancion("A quién le importa","Electronica","Operación Vodevil",500,R.drawable.cancion11,"Fangoria"));
    }
}
