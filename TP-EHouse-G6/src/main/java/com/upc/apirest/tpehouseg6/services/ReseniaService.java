package com.upc.apirest.tpehouseg6.services;

import com.upc.apirest.tpehouseg6.entities.Resenia;

import java.util.List;

public interface ReseniaService {
    public Resenia insertar(Resenia resenia);
    public Resenia editar(Resenia resenia);
    public void eliminar(long id);
    public List<Resenia> listar();
    public Resenia buscarPorId(long id);
}
