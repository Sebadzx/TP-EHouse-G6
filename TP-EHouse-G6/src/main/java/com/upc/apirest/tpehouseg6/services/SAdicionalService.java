package com.upc.apirest.tpehouseg6.services;

import com.upc.apirest.tpehouseg6.entities.SAdicionales;

import java.util.List;

public interface SAdicionalService {
    public SAdicionales insertar(SAdicionales sAdicionales);
    public SAdicionales editar(SAdicionales sAdicionales);
    public void eliminar(long id);
    public List<SAdicionales> listar();
    public SAdicionales buscarPorId(long id);

}
