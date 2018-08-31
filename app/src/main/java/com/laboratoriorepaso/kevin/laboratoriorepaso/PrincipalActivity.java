package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.laboratoriorepaso.adaptador.AdapterCancion;
import com.laboratoriorepaso.clases.Cancion;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterCancion adapterCancion;
    Button playList,buscar,verTodas;
    EditText buscador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Indicando ID al objeto
        playList = (Button)findViewById(R.id.verPlaylist);
        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);
        buscador = (EditText)findViewById(R.id.idBuscaListaB);
        verTodas = (Button)findViewById(R.id.verTodasCanciones);
        buscar = (Button)findViewById(R.id.buscar);

        //Configuracion del adapter y recyclerview
        recyclerViewCancion.setLayoutManager(new LinearLayoutManager(this));
        adapterCancion = new AdapterCancion(this, SplashScreenActivity.listaCanciones);
        recyclerViewCancion.setAdapter(adapterCancion);
        SplashScreenActivity.llaves.clear();
        SplashScreenActivity.llaves.addAll(SplashScreenActivity.listaCanciones.keySet());

        adapterCancion.setOnClickListener(view -> {
            PlayListActivity.playList.add(SplashScreenActivity.listaCanciones.get(SplashScreenActivity.llaves.get(recyclerViewCancion.getChildAdapterPosition(view))));
            Toast.makeText(getApplicationContext(),"Cancion agregada a Play List",Toast.LENGTH_SHORT).show();
        });

        buscar.setOnClickListener(view ->{
            String texto = buscador.getText().toString();
            Map<String,Cancion> listaFiltrada = new TreeMap<>();
            try {
                Cancion item = SplashScreenActivity.listaCanciones.get(texto);
                listaFiltrada.put(item.getNombre(), item);
                SplashScreenActivity.llaves.clear();
                SplashScreenActivity.llaves.addAll(listaFiltrada.keySet());
                adapterCancion.filtrarLista(listaFiltrada);
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),"No se pudo encontrar la cancion",Toast.LENGTH_SHORT).show();
            }
        });

        verTodas.setOnClickListener(view ->{
            SplashScreenActivity.llaves.clear();
            SplashScreenActivity.llaves.addAll(SplashScreenActivity.listaCanciones.keySet());
            adapterCancion.filtrarLista(SplashScreenActivity.listaCanciones);
        });

        //Boton ver Play list
        playList.setOnClickListener(view->{
            startActivity(new Intent(PrincipalActivity.this,PlayListActivity.class));
        });
    }
}
