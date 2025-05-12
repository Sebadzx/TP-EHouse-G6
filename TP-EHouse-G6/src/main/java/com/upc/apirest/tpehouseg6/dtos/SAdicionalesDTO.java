package com.upc.apirest.tpehouseg6.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SAdicionalesDTO {
    private int idServiciosAdicionales;
    private String nombreServicio;
    private double precioServicio;
}
