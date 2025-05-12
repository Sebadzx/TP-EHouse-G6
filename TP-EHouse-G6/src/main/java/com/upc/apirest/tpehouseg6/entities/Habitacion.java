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
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;
    private String tipoHabitacion;
    private String disponibilidad;
    private String descripcionHabitacion;


    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}

