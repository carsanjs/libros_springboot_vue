package com.example.libros.models;

import org.springframework.data.annotation.Id;

public class bookModel {


    @Id
    private int id;
    private String isbn;
    private String nombre;
    private String autor;
    private String genero;
    private String fecha_publicacion;
    private String precio;


    
    public bookModel() {
    }



    public bookModel(int id, String isbn, String nombre, String autor, String genero, String fecha_publicacion,
            String precio) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.fecha_publicacion = fecha_publicacion;
        this.precio = precio;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getIsbn() {
        return isbn;
    }



    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getAutor() {
        return autor;
    }



    public void setAutor(String autor) {
        this.autor = autor;
    }



    public String getGenero() {
        return genero;
    }



    public void setGenero(String genero) {
        this.genero = genero;
    }



    public String getFecha_publicacion() {
        return fecha_publicacion;
    }



    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }



    public String getPrecio() {
        return precio;
    }



    public void setPrecio(String precio) {
        this.precio = precio;
    }

    

    

    
}
