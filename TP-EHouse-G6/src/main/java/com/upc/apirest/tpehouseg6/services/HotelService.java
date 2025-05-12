package com.upc.apirest.tpehouseg6.services;

import com.upc.apirest.tpehouseg6.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel insertar(Hotel hotel);
    public Hotel editar(Hotel hotel);
    public void eliminar(long id);
    public List<Hotel> listar();
    public Hotel buscarPorId(long id);

    /*public List<String[]> nmroHabitaciones();
     */
    public List<String[]> nmroHabitaciones();
}

