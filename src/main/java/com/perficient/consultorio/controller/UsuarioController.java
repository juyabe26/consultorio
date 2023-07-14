package com.perficient.consultorio.controller;

import com.perficient.consultorio.service.IUsuarioService;
import com.perficient.consultorio.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

 @Autowired
 private IUsuarioService iUsuarioService;

 /**
  * Método encargado de validar si existe el usuario con los parámetros indicados
  * @param login
  * @param password
  * @return Datos del usuario
  */
 @GetMapping
 public @ResponseBody UsuarioDto buscarUsuario(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password){
  return  iUsuarioService.buscarUsuario(login,password);
 }


}
