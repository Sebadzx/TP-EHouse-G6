package com.upc.apirest.tpehouseg6.serviceimpl;


import com.upc.apirest.tpehouseg6.entities.SAdicionales;
import com.upc.apirest.tpehouseg6.repositories.SAdicionalesRepositorio;
import com.upc.apirest.tpehouseg6.services.SAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SAdicionalServiceImpl implements SAdicionalService {
    @Autowired
    private SAdicionalesRepositorio SR;

    @Override
    public SAdicionales insertar(SAdicionales sAdicionales) {
        return SR.save(sAdicionales);
    }

    @Override
    public SAdicionales editar(SAdicionales sAdicionales) {
        if (SR.findById(sAdicionales.getIdServiciosAdicionales()).isPresent()) {
            return SR.save(sAdicionales);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(SR.existsById(id)){
            SR.deleteById(id);
        }
    }

    @Override
    public List<SAdicionales> listar() {
        return SR.findAll();
    }

    @Override
    public SAdicionales buscarPorId(long id) {
        if(SR.findById(id).isPresent()){
            return SR.findById(id).get();
        }
        return null;
    }
}
