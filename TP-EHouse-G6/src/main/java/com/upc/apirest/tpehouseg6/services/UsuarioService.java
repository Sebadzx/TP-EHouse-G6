package com.upc.apirest.tpehouseg6.services;


import com.upc.apirest.tpehouseg6.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario insertar(Usuario usuario);
    public Usuario editar(Usuario usuario);
    public void eliminar(long id);
    public List<Usuario> listar();
    public Usuario buscarPorId(long id);

}
