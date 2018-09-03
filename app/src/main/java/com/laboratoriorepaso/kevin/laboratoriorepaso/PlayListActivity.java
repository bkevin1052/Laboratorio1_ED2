package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.laboratoriorepaso.adaptador.AdapterPlayList;
import com.laboratoriorepaso.clases.Cancion;

import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterPlayList adapterPlayList;

    TextView eliminar;
    public static List<Cancion> playList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        eliminar = (TextView)findViewById(R.id.eliminar);

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

    }
}
