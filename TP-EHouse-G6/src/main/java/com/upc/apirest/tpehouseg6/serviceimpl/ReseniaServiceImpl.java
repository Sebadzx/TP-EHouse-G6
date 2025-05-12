package com.upc.apirest.tpehouseg6.serviceimpl;

import com.upc.apirest.tpehouseg6.entities.Resenia;
import com.upc.apirest.tpehouseg6.repositories.ReseniaRepositorio;
import com.upc.apirest.tpehouseg6.services.ReseniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServiceImpl implements ReseniaService {
    @Autowired
    private ReseniaRepositorio RR;

    @Override
    public Resenia insertar(Resenia resenia) {
        return RR.save(resenia);
    }

    @Override
    public Resenia editar(Resenia resenia) {
        if (RR.findById(resenia.getIdResenia()).isPresent()) {
            return RR.save(resenia);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(RR.existsById(id)){
            RR.deleteById(id);
        }
    }

    @Override
    public List<Resenia> listar() {
        return RR.findAll();
    }

    @Override
    public Resenia buscarPorId(long id) {
        if(RR.findById(id).isPresent()){
            return RR.findById(id).get();
        }
        return null;
    }


}

