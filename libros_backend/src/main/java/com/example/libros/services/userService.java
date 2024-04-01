package com.example.libros.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libros.models.userModel;
import com.example.libros.repositories.userRepository;

@Service
public class userService {

    @Autowired
    userRepository repositorio;


    public boolean guardarUsuario(userModel usuario){

        try {
            userModel respuesta = repositorio.save(usuario);
            if(respuesta != null)
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizarUsuario(userModel user){

        try {
            if(repositorio.existsById(user.getId())){
                repositorio.save(user);
                return true;
            }else return false;
            
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<userModel> consultarUsuarios(){
        try {
            return (ArrayList<userModel>)repositorio.findAll();
        } catch (Exception e) {
            return null;
        }
    }


    public Optional<userModel> consultarUsuario(Integer id){

        try {
            if(!repositorio.existsById(id))return null;
            else return repositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eliminarUsuario(Integer id){
        try {
            if(repositorio.existsById(id)){
                repositorio.deleteById(id);
                return true;
            }else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<userModel> login(String correo, String contrasena){
        ArrayList<userModel> login=repositorio.findByCorreoAndContrasena(correo, contrasena);
        return login;
     }
    
}
