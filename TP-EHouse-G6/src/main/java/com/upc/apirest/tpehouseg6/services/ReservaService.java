package com.upc.apirest.tpehouseg6.services;


import com.upc.apirest.tpehouseg6.entities.Reserva;

import java.util.List;

public interface ReservaService {
    public Reserva insertar(Reserva reserva);
    public Reserva editar(Reserva reserva);
    public void eliminar(long id);
    public List<Reserva> listar();
    public Reserva buscarPorId(long id);

}

