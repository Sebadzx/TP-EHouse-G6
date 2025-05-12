package com.upc.apirest.tpehouseg6.repositories;

import com.upc.apirest.tpehouseg6.entities.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseniaRepositorio extends JpaRepository<Resenia, Long> {
}
