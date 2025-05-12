package com.upc.apirest.tpehouseg6.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionFavoritaDTO {
    private int idHotel;
    private String nombreHotel;
    private String tipoHabitacion;
    private int idHabitacionFavorita;
}
