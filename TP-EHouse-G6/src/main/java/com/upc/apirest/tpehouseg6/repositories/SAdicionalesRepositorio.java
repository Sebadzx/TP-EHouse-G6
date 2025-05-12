package com.upc.apirest.tpehouseg6.repositories;

import com.upc.apirest.tpehouseg6.entities.SAdicionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SAdicionalesRepositorio extends JpaRepository<SAdicionales, Long> {
}
