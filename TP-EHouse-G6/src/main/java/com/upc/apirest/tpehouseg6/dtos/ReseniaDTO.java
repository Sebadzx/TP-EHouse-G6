package com.upc.apirest.tpehouseg6.dtos;

import com.upc.apirest.tpehouseg6.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReseniaDTO {
    private int idResenia;
    private int puntuacion;
    private LocalDate fechaResenia;
    private String descripcionResenia;
    private Usuario usuario;
}
