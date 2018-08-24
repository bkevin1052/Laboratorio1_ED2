package com.laboratoriorepaso.clases;

public class Cancion {

    private String nombre;
    private String categoria;
    private String album;
    private int duracion;
    private int imagen;

    public Cancion(String nombre,String categoria,String album, int duracion,int imagen) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.album = album;
        this.duracion = duracion;
        this.imagen = imagen;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
