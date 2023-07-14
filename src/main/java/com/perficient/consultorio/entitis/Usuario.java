package com.perficient.consultorio.entitis;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;
  @Column
  private String usuario;
  @Column
  private String contrasena;

}
