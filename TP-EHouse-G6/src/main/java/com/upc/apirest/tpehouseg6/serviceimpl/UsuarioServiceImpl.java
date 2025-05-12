package com.upc.apirest.tpehouseg6.serviceimpl;


import com.upc.apirest.tpehouseg6.entities.Usuario;
import com.upc.apirest.tpehouseg6.repositories.UsuarioRepositorio;
import com.upc.apirest.tpehouseg6.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepositorio UR;

    @Override
    public Usuario insertar(Usuario usuario) {
        return UR.save(usuario);
    }

    @Override
    public Usuario editar(Usuario usuario) {
        if (UR.findById(usuario.getIdUsuario()).isPresent()) {
            return UR.save(usuario);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(UR.existsById(id)){
            UR.deleteById(id);
        }
    }

    @Override
    public List<Usuario> listar() {
        return UR.findAll();
    }

    @Override
    public Usuario buscarPorId(long id) {
        if(UR.findById(id).isPresent()){
            return UR.findById(id).get();
        }
        return null;
    }
}
