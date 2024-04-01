package com.example.libros.models;

import org.springframework.data.annotation.Id;

public class userModel {
    @Id
    private int id;

    private String nombre;
    private String apellido;
    private String nombre_usuario;
    private String correo;
    private String contrasena;


    public userModel() {
    }


    public userModel(int id, String nombre, String apellido, String nombre_usuario, String correo,
            String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getNombre_usuario() {
        return nombre_usuario;
    }


    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getContrasena() {
        return contrasena;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    


    

    
}
