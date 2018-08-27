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

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterCancion adapterCancion;
    Button playList;
    EditText buscador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Indicando ID al objeto
        playList = (Button)findViewById(R.id.verPlaylist);
        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);
        buscador = (EditText)findViewById(R.id.idBuscaListaB);

        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filtro(editable.toString());
            }
        });

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

    //Metodo para poder realizar busqueda dentro del diccionario, asi mismo ingresar texto
    private void filtro(String text){
        HashMap<String,Cancion> listaFiltrada = new HashMap<>();

        for(Cancion item: SplashScreenActivity.listaCanciones.values()){
            if(item.getNombre().toLowerCase().contains(text.toLowerCase()))
                listaFiltrada.put(item.getNombre(), item);
        }

        adapterCancion.filtrarLista(listaFiltrada);
    }
}
