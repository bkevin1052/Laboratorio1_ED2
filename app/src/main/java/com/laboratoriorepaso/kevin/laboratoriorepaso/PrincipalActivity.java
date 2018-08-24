package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.laboratoriorepaso.adaptador.AdapterCancion;
import com.laboratoriorepaso.clases.Cancion;

import java.util.HashMap;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterCancion adapterCancion;
    Button playList;
    HashMap<String,Cancion> listaCanciones = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Creacion de canciones



        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);
        recyclerViewCancion.setLayoutManager(new LinearLayoutManager(this));
        adapterCancion = new AdapterCancion(this, listaCanciones);
        recyclerViewCancion.setAdapter(adapterCancion);

    }
}
