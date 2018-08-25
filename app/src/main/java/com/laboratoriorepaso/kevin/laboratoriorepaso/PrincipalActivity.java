package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.laboratoriorepaso.adaptador.AdapterCancion;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterCancion adapterCancion;
    Button playList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Indicando ID al objeto
        playList = (Button)findViewById(R.id.verPlaylist);
        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);

        //Creacion de canciones


        //configuracion del adapter y recyclerview
        recyclerViewCancion.setLayoutManager(new LinearLayoutManager(this));
        adapterCancion = new AdapterCancion(this, SplashScreenActivity.listaCanciones);
        recyclerViewCancion.setAdapter(adapterCancion);

        adapterCancion.setOnClickListener(view -> {
            PlayListActivity.playList.add(SplashScreenActivity.listaCanciones.get(SplashScreenActivity.llaves.get(recyclerViewCancion.getChildAdapterPosition(view))));
            Toast.makeText(getApplicationContext(),"Cancion agregada a Play List",Toast.LENGTH_SHORT).show();
        });

        //Boton ver Play list
        playList.setOnClickListener(view->{
            startActivity(new Intent(PrincipalActivity.this,PlayListActivity.class));
        });
    }
}
