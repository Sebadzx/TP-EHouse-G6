package com.upc.apirest.tpehouseg6.dtos;

import com.upc.apirest.tpehouseg6.entities.Habitacion;
import com.upc.apirest.tpehouseg6.entities.SAdicionales;
import com.upc.apirest.tpehouseg6.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private int idReserva;
    private int cantidadPersonas;
    private LocalDate fecha_reserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precioTotal;
    private String estadoReserva;
    private Usuario usuario;
    private Habitacion habitacion;
    private SAdicionales sAdicionales;
}
