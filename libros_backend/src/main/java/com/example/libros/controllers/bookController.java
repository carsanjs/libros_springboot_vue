package com.example.libros.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libros.models.bookModel;
import com.example.libros.services.bookService;
import com.google.gson.Gson;



@RestController
@RequestMapping("/Libros")
@CrossOrigin("*")
public class bookController {


    @Autowired
    bookService servicios;

    @GetMapping(path="/ver")
    public ArrayList<bookModel> VerLibros() {  
       return servicios.consultarLibros();
    }

    @GetMapping("/Libro/{id}")
    public String consultarLibro(@PathVariable("id") Integer id) {
        try {
            Optional<bookModel> Libro = servicios.consultarLibro(id);

            Gson json = new Gson();

            if (Libro == null)
                return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
            else {

                return "{\"success\": true, \"message\": \"Consulta realizada correctamente.\", \"data\": "
                        + json.toJson(Libro.get())
                        + "}";
            }
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    @PostMapping(value = "/guardar")
    public String guardarLibro(@RequestBody bookModel Libro) {
        try {

            if (Libro != null) {
                Boolean respuesta = servicios.guardarLibro(Libro);

                if (respuesta)
                    return "{\"success\": true, \"message\": \"Libro almacenado correctamente.\"}";
                else
                    return "{\"success\": false, \"message\": \"No se pudo almacenar el Libro, revisa los parametros.\"}";
            } else
                return "{\"success\": false, \"message\": \"No se puede almacenar un Libro vacio.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    @PostMapping(value = "/actualizar")
    public String actualizarLibro(@RequestBody bookModel book) {
        try {
            boolean response = servicios.actualizarLibro(book);

            if (response)
                return "{\"success\": true, \"message\": \"Libro actualizado correctamente.\"}";
            else
                return "{\"success\": false, \"message\": \"No se pudo actualizar el Libro, revisa los parametros.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    
    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        try {
            boolean response = servicios.eliminarLibro(id);
            if (response)
                return "{\"success\": true, \"message\": \"Libro eliminado correctamente.\"}";
            else
                return "{\"success\": false, \"message\": \"No se pudo eliminar el Libro, revisa los parametros.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }
    
}
