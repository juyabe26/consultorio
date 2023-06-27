package com.perficient.consultorio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column
    private String codigo;

    @Column (name = "nombregenerico")
    private String nombreGenerico;

    @Column(name = "nombrecomercial")
    private String nombreComercial;

    @Column
    private String laboratorio;

    @Column
    private String marca;

}
