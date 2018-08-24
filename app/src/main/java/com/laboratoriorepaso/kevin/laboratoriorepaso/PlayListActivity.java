package com.laboratoriorepaso.kevin.laboratoriorepaso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.laboratoriorepaso.adaptador.AdapterPlayList;
import com.laboratoriorepaso.clases.Cancion;

import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity {

    RecyclerView recyclerViewCancion;
    AdapterPlayList adapterPlayList;
    public static List<Cancion> playList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        recyclerViewCancion = (RecyclerView) findViewById(R.id.RecyclerViewVerTodas);
        recyclerViewCancion.setLayoutManager(new LinearLayoutManager(this));
        adapterPlayList = new AdapterPlayList(this, playList);
        recyclerViewCancion.setAdapter(adapterPlayList);

    }
}
