package com.laboratoriorepaso.adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.laboratoriorepaso.clases.Cancion;
import com.laboratoriorepaso.kevin.laboratoriorepaso.R;
import com.laboratoriorepaso.kevin.laboratoriorepaso.SplashScreenActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AdapterCancion extends RecyclerView.Adapter<AdapterCancion.CancionViewHolder> implements View.OnClickListener{

    private Context miContexto;
    private Map<String,Cancion> listaCanciones;
    private View.OnClickListener listener;

    public AdapterCancion(Context miContexto, Map<String,Cancion> listaCanciones) {
        this.miContexto = miContexto;
        this.listaCanciones = listaCanciones;
    }

    public String getLlave(int position)
    {
        return (String) SplashScreenActivity.llaves.get(position);
    }


    @Override
    public CancionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(miContexto);
        View view = inflater.inflate(R.layout.costume_row_canciones,null);
        CancionViewHolder holder = new CancionViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    public void filtrarLista(Map<String,Cancion> lista){
            listaCanciones = lista;
            notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CancionViewHolder holder, int i) {
        String llave = getLlave(i);
        Cancion cancion = listaCanciones.get(llave);
        holder.textViewTitulo.setText(cancion.getNombre());
        holder.textViewDetalles.setText(cancion.getCategoria()+ "\n" +
                cancion.getAlbum() + "\n" + cancion.getDuracion());
        holder.imageView.setImageDrawable(miContexto.getResources().getDrawable(cancion.getImagen()));
    }

    @Override
    public int getItemCount() {
        return listaCanciones.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!= null){
            listener.onClick(view);
        }
    }

    class CancionViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitulo, textViewDetalles;
        ImageView imageView;

        public CancionViewHolder(View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.titulo);
            textViewDetalles = itemView.findViewById(R.id.detalles);
            imageView = itemView.findViewById(R.id.imagenCancion);
        }

    }
}
