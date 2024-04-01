package com.example.libros.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.libros.models.userModel;


@Repository
public interface userRepository extends MongoRepository<userModel, Integer> {

    public ArrayList<userModel>findByCorreoAndContrasena(String correo, String contrasena);
    
    
}
