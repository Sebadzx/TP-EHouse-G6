package com.upc.apirest.tpehouseg6.serviceimpl;


import com.upc.apirest.tpehouseg6.entities.Reserva;
import com.upc.apirest.tpehouseg6.repositories.ReservaRepositorio;
import com.upc.apirest.tpehouseg6.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepositorio RR;

    @Override
    public Reserva insertar(Reserva reserva) {
        return RR.save(reserva);
    }

    @Override
    public Reserva editar(Reserva reserva) {
        if (RR.findById(reserva.getIdReserva()).isPresent()) {
            return RR.save(reserva);
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
    public List<Reserva> listar() {
        return RR.findAll();
    }

    @Override
    public Reserva buscarPorId(long id) {
        if(RR.findById(id).isPresent()){
            return RR.findById(id).get();
        }
        return null;
    }
}
