package com.upc.apirest.tpehouseg6.serviceimpl;


import com.upc.apirest.tpehouseg6.entities.Hotel;
import com.upc.apirest.tpehouseg6.repositories.HotelRepositorio;
import com.upc.apirest.tpehouseg6.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepositorio hR;

    @Override
    public Hotel insertar(Hotel hotel) {
        return hR.save(hotel);
    }

    @Override
    public Hotel editar(Hotel hotel) {
        if (hR.findById(hotel.getIdHotel()).isPresent()) {
            return hR.save(hotel);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(hR.existsById(id)){
            hR.deleteById(id);
        }
    }

    @Override
    public List<Hotel> listar() {
        return hR.findAll();
    }

    @Override
    public Hotel buscarPorId(long id) {
        if(hR.findById(id).isPresent()){
            return hR.findById(id).get();
        }
        return null;
    }

    @Override
    public List<String[]> nmroHabitaciones() {
        return hR.nmroHabitaciones();
    }

}
