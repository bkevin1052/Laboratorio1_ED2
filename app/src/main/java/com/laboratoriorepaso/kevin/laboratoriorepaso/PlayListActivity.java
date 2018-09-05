package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.laboratoriorepaso.adaptador.AdapterPlayList;
import com.laboratoriorepaso.clases.Cancion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterPlayList adapterPlayList;
    TextView eliminar;

    Button btn1, btn2,btn3,btn4;
    public static List<Cancion> playList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eliminar = (TextView)findViewById(R.id.eliminar);
        btn1 = (Button)findViewById(R.id.DescendentePorDuracion);
        btn2 = (Button)findViewById(R.id.AscendentePorDuracion);
        btn3 = (Button)findViewById(R.id.DescendentePorNombre);
        btn4 = (Button)findViewById(R.id.AscendentePorNombre);

        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewPlayList);
        recyclerViewCancion.setLayoutManager(new LinearLayoutManager(this));
        adapterPlayList = new AdapterPlayList(this, playList);
        recyclerViewCancion.setAdapter(adapterPlayList);

        eliminar.setOnClickListener(view->{
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Esta seguro de eliminar la lista?");
            dlgAlert.setTitle("Eliminar Lista");
            dlgAlert.setPositiveButton("SI", (dialogInterface, i) -> {
                playList.clear();
                adapterPlayList.eliminar(playList);
                startActivity(new Intent(PlayListActivity.this,PrincipalActivity.class));
            });
            dlgAlert.setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.cancel());
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

        });

        adapterPlayList.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Reproduciendo cancion",Toast.LENGTH_SHORT).show();
        });

        btn1.setOnClickListener(view ->{
            Collections.sort(playList, (o1, o2) -> o2.getDuracion().compareToIgnoreCase(o1.getDuracion()));
            adapterPlayList.eliminar(playList);
        });

        btn2.setOnClickListener(view ->{
            Collections.sort(playList, (o1, o2) -> o1.getDuracion().compareToIgnoreCase(o2.getDuracion()));
            adapterPlayList.eliminar(playList);
        });

        btn3.setOnClickListener(view ->{
            Collections.sort(playList, (o1, o2) -> o2.getNombre().compareToIgnoreCase(o1.getNombre()));
            adapterPlayList.eliminar(playList);
        });

        btn4.setOnClickListener(view ->{
            Collections.sort(playList, (o1, o2) -> o1.getNombre().compareToIgnoreCase(o2.getNombre()));
            adapterPlayList.eliminar(playList);
        });


    }
}
