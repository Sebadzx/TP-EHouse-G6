package com.upc.apirest.tpehouseg6.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SAdicionales")
public class SAdicionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServiciosAdicionales;
    private String nombreServicio;
    private double precioServicio;
}
