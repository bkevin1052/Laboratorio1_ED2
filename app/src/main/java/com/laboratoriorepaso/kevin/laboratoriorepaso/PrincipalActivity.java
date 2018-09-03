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

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrincipalActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterCancion adapterCancion;
    Button playList,ordenarAscendenteN,ordenarDescendenteN,ordenarAscendenteD,ordenarDescendenteD;
    EditText buscador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Indicando ID al objeto
        playList = (Button)findViewById(R.id.verPlaylist);
        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);
        buscador = (EditText)findViewById(R.id.idBuscaListaB);
        ordenarAscendenteN = (Button)findViewById(R.id.OrdenarAscendentePorNombre);
        ordenarDescendenteN = (Button)findViewById(R.id.OrdenarDescendentePorNombre);
        ordenarAscendenteD = (Button)findViewById(R.id.OrdenarAscendentePorDuracion);
        ordenarDescendenteD = (Button)findViewById(R.id.OrdenarDescendentePorDuracion);


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

        ordenarDescendenteN.setOnClickListener(view ->{

            Map<String,Cancion> descendente = new LinkedHashMap<>();

            List<Map.Entry<String,Cancion>> listaDescendente = new LinkedList<>(SplashScreenActivity.listaCanciones.entrySet());

            Collections.sort(listaDescendente, (o1, o2) -> o1.getValue().getNombre().compareToIgnoreCase(o2.getValue().getNombre()));

            for(int i = listaDescendente.size()-1; i >= 0 ;i--){
                Map.Entry<String,Cancion> cancion = listaDescendente.get(i);
                descendente.put(cancion.getKey(),cancion.getValue());
            }

            SplashScreenActivity.llaves.clear();
            SplashScreenActivity.llaves.addAll(descendente.keySet());
            adapterCancion.filtrarLista(descendente);

        });

        ordenarAscendenteN.setOnClickListener(view ->{

            Map<String,Cancion> ascendente = new LinkedHashMap<>();

            List<Map.Entry<String,Cancion>> listaAscendente = new LinkedList<>(SplashScreenActivity.listaCanciones.entrySet());

            Collections.sort(listaAscendente, (o1, o2) -> o1.getValue().getNombre().compareToIgnoreCase(o2.getValue().getNombre()));

            for(Map.Entry<String,Cancion> cancion : listaAscendente){
                ascendente.put(cancion.getKey(),cancion.getValue());
            }

            SplashScreenActivity.llaves.clear();
            SplashScreenActivity.llaves.addAll(ascendente.keySet());
            adapterCancion.filtrarLista(ascendente);

        });


        //FALTA
        ordenarDescendenteD.setOnClickListener(view->{

            Map<String,Cancion> descendente = new LinkedHashMap<>();

            List<Map.Entry<String,Cancion>> listaDescendente = new LinkedList<>(SplashScreenActivity.listaCanciones.entrySet());

            Collections.sort(listaDescendente, (o1, o2) -> o1.getValue().getDuracion().compareToIgnoreCase(o2.getValue().getDuracion()));

            for(int i = listaDescendente.size()-1; i >= 0 ;i--){
                Map.Entry<String,Cancion> cancion = listaDescendente.get(i);
                descendente.put(cancion.getKey(),cancion.getValue());
            }

            SplashScreenActivity.llaves.clear();
            SplashScreenActivity.llaves.addAll(descendente.keySet());
            adapterCancion.filtrarLista(descendente);
        });

        //FALTA
        ordenarAscendenteD.setOnClickListener(view->{
            Map<String,Cancion> ascendente = new LinkedHashMap<>();

            List<Map.Entry<String,Cancion>> listaAscendente = new LinkedList<>(SplashScreenActivity.listaCanciones.entrySet());

            Collections.sort(listaAscendente, (o1, o2) -> o1.getValue().getDuracion().compareToIgnoreCase(o2.getValue().getDuracion()));

            for(Map.Entry<String,Cancion> cancion : listaAscendente){
                ascendente.put(cancion.getKey(),cancion.getValue());
            }

            SplashScreenActivity.llaves.clear();
            SplashScreenActivity.llaves.addAll(ascendente.keySet());
            adapterCancion.filtrarLista(ascendente);
        });

        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtro(s.toString());
            }
        });

        //Boton ver Play list
        playList.setOnClickListener(view->{
            startActivity(new Intent(PrincipalActivity.this,PlayListActivity.class));
        });
    }

    private void filtro(String texto){
        Map<String,Cancion> listaFiltrada = new HashMap<>();

        for(Cancion cancion : SplashScreenActivity.listaCanciones.values()){
            if(cancion.getNombre().toLowerCase().contains(texto.toLowerCase())){
                listaFiltrada.put(cancion.getNombre(),cancion);
            }
        }
        SplashScreenActivity.llaves.clear();
        SplashScreenActivity.llaves.addAll(listaFiltrada.keySet());
        adapterCancion.filtrarLista(listaFiltrada);
    }
}
