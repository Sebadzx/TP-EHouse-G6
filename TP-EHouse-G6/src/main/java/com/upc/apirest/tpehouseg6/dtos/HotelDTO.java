package com.upc.apirest.tpehouseg6.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private int idHotel;
    private String nombreHotel;
    private String direccionHotel;
    private String telefonoHotel;
    private String correoHotel;
}
