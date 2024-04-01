package com.example.libros.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libros.models.bookModel;
import com.example.libros.repositories.bookRepository;

@Service
public class bookService {

    @Autowired
    bookRepository repositorio;

    public boolean guardarLibro(bookModel Libro){

        try {
            bookModel respuesta = repositorio.save(Libro);
            if(respuesta != null)
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizarLibro(bookModel book){

        try {
            if(repositorio.existsById(book.getId())){
                repositorio.save(book);
                return true;
            }else return false;
            
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<bookModel> consultarLibros(){
        try {
            return (ArrayList<bookModel>)repositorio.findAll();
        } catch (Exception e) {
            return null;
        }
    }


    public Optional<bookModel> consultarLibro(Integer id){

        try {
            if(!repositorio.existsById(id))return null;
            else return repositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eliminarLibro(Integer id){
        try {
            if(repositorio.existsById(id)){
                repositorio.deleteById(id);
                return true;
            }else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
