package com.laboratoriorepaso.adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.laboratoriorepaso.clases.Cancion;
import com.laboratoriorepaso.kevin.laboratoriorepaso.R;

import java.util.List;

public class AdapterPlayList extends RecyclerView.Adapter<AdapterPlayList.PlayListViewHolder> implements View.OnClickListener{

    private Context miContexto;
    private List<Cancion> listaCanciones;
    private View.OnClickListener listener;

    public AdapterPlayList(Context miContexto, List<Cancion> listaCanciones) {
        this.miContexto = miContexto;
        this.listaCanciones = listaCanciones;
    }


    @Override
    public PlayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(miContexto);
        View view = inflater.inflate(R.layout.costume_row_canciones,null);
        PlayListViewHolder holder = new PlayListViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    public void eliminar(List<Cancion> lista){
        listaCanciones = lista;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull PlayListViewHolder holder, int position) {
        Cancion cancion = listaCanciones.get(position);
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

    class PlayListViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitulo, textViewDetalles;
        ImageView imageView;

        public PlayListViewHolder(View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.titulo);
            imageView = itemView.findViewById(R.id.imagenCancion);
            textViewDetalles = itemView.findViewById(R.id.detalles);
        }

    }
}