package com.example.oscar.verificarconexion;

/**
 * Created by Oscar on 03/07/2018.
 */

public class Error {
    private int iconoError;
    private String titulo;
    private String descripcion;
    private String solucion;


    public Error() {
    }

    public Error(int iconoError, String titulo, String descripcion, String solucion) {
        this.iconoError = iconoError;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.solucion = solucion;
    }

    public int getIconoError() {
        return iconoError;
    }

    public void setIconoError(int iconoError) {
        this.iconoError = iconoError;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

}
