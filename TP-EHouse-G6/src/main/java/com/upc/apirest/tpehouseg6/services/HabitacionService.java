package com.upc.apirest.tpehouseg6.services;


import com.upc.apirest.tpehouseg6.entities.Habitacion;

import java.util.List;

public interface HabitacionService {
    public Habitacion insertar(Habitacion habitacion);
    public Habitacion editar(Habitacion habitacion);
    public void eliminar(long id);
    public List<Habitacion> listar();
    public Object buscarPorId(long id);
    public List<String[]> habitacionFavorita();
    /*Map<String, Long> obtenerCantidadHabitacionesPorTipo(String tipoHabitacion);
     */
}
