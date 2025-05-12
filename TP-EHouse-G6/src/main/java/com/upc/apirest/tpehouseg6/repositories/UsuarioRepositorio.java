package com.upc.apirest.tpehouseg6.repositories;

import com.upc.apirest.tpehouseg6.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
