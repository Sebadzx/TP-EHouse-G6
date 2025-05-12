package com.upc.apirest.tpehouseg6.serviceimpl;

import com.upc.apirest.tpehouseg6.entities.Habitacion;
import com.upc.apirest.tpehouseg6.repositories.HabitacionRepositorio;
import com.upc.apirest.tpehouseg6.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements HabitacionService {
    @Autowired
    private HabitacionRepositorio hR;

    @Override
    public Habitacion insertar(Habitacion habitacion) {
        return hR.save(habitacion);
    }

    @Override
    public Habitacion editar(Habitacion habitacion) {
        if (hR.findById(habitacion.getIdHabitacion()).isPresent()) {
            return hR.save(habitacion);
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
    public List<Habitacion> listar() {
        return hR.findAll();
    }

    @Override
    public Habitacion buscarPorId(long id) {
        if(hR.findById(id).isPresent()){
            return hR.findById(id).get();
        }
        return null;
    }

   /* @Override
    public Map<String, Long> obtenerCantidadHabitacionesPorTipo(String tipoHabitacion) {
        List<Object[]> resultados = hR.countHabitacionesByTipoHabitacion(tipoHabitacion);
        Map<String, Long> habitacionesPorTipo = new HashMap<>();

        // Transformar los resultados en un Map<String, Long>
        for (Object[] resultado : resultados) {
            String tipo = (String) resultado[0];
            Long totalHabitaciones = ((Number) resultado[1]).longValue();  // Conversión segura a Long
            habitacionesPorTipo.put(tipo, totalHabitaciones);
        }

        return habitacionesPorTipo;
    }*/

    @Override
    public List<String[]> habitacionFavorita() {
        return hR.habitacionFavorita();
    }

}
