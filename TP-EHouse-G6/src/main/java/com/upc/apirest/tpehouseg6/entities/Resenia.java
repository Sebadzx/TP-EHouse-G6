package com.upc.apirest.tpehouseg6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenia;
    private int puntuacion;
    private LocalDate fechaResenia;
    private String descripcionResenia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}