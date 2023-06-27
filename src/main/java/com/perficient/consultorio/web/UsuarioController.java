package com.perficient.consultorio.web;

import com.perficient.consultorio.model.Usuario;
import com.perficient.consultorio.service.UsuarioService;
import com.perficient.consultorio.web.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

 @Autowired
 private UsuarioService usuarioService;

 /**
  * Método encargado de validar si existe el usuario con los parámetros indicados
  * @param login
  * @param password
  * @return Datos del usuario
  */
 @GetMapping
 public @ResponseBody UsuarioDto buscarUsuario(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password){
  return  usuarioService.buscarUsuario(login,password);
 }


}
