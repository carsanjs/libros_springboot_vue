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

import com.example.libros.models.userModel;
import com.example.libros.services.userService;
import com.google.gson.Gson;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class userController {
    @Autowired
    userService servicios;

    @GetMapping(value = "/login/{correo}/{contrasena}")
    public ArrayList<userModel> loginregistro(@PathVariable("correo") String correo, @PathVariable("contrasena") String contrasena) {
       return servicios.login(correo,contrasena);
    }
 




    @GetMapping("/veruser")
    public String obtenerUsuarios() {

        try {
            ArrayList<userModel> usuarios = servicios.consultarUsuarios();

            Gson json = new Gson();

            if (usuarios == null)
                return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
            else if (usuarios.size() == 0)
                return "{\"success\": false, \"message\": \"No hay usuarios que mostrar.\"}";
            else {

                return "{\"success\": true, \"message\": \"Consulta realizada correctamente.\", \"data\": "
                        + json.toJson(usuarios)
                        + "}";
            }

        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }

    }

    @GetMapping("/usuario/{id}")
    public String consultarUsuario(@PathVariable("id") Integer id) {
        try {
            Optional<userModel> usuario = servicios.consultarUsuario(id);

            // Gson json = new Gson();

            if (usuario == null)
                return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
            else {

                return "{\"success\": true, \"message\": \"Consulta realizada correctamente.\", \"data\": "
                        // + json.toJson(usuario.get())
                        + "}";
            }
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    @PostMapping(value = "/guardar")
    public String guardarUsuario(@RequestBody userModel usuario) {
        try {

            if (usuario != null) {
                Boolean respuesta = servicios.guardarUsuario(usuario);

                if (respuesta)
                    return "{\"success\": true, \"message\": \"Usuario almacenado correctamente.\"}";
                else
                    return "{\"success\": false, \"message\": \"No se pudo almacenar el usuario, revisa los parametros.\"}";
            } else
                return "{\"success\": false, \"message\": \"No se puede almacenar un usuario vacio.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    @PostMapping(value = "/actualizar")
    public String actualizarUsuario(@RequestBody userModel user) {
        try {
            boolean response = servicios.actualizarUsuario(user);

            if (response)
                return "{\"success\": true, \"message\": \"Usuario actualizado correctamente.\"}";
            else
                return "{\"success\": false, \"message\": \"No se pudo actualizar el usuario, revisa los parametros.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }

    
    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        try {
            boolean response = servicios.eliminarUsuario(id);
            if (response)
                return "{\"success\": true, \"message\": \"Usuario eliminado correctamente.\"}";
            else
                return "{\"success\": false, \"message\": \"No se pudo eliminar el usuario, revisa los parametros.\"}";
        } catch (Exception e) {
            return "{\"success\": false, \"message\": \"Ocurrio un error al hacer la consulta.\"}";
        }
    }
    
}
