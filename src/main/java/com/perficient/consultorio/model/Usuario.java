package com.perficient.consultorio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//@Entity
@Getter
@Setter
@AllArgsConstructor
//@Table(name = "usuario")
public class Usuario {

 public Usuario() { }

 // @Id
 // @GeneratedValue(strategy = GenerationType.AUTO)
 // private UUID uuid;
  //@Column
  private String primerNombre;
  //@Column
  private String segundoNombre;
  //@Column
  private String primerApellido;
  //@Column
  private String segundoApellido;
  //@Column
  private String tipoDocumento;
  //@Column
  private String numeroDocumento;
  //@Column
  private String email;


}
