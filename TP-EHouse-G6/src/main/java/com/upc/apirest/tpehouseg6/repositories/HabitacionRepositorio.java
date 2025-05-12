package com.upc.apirest.tpehouseg6.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepositorio {
    @Query(value = "select ho.id_hotel,ho.nombre_hotel, h.tipo_habitacion, count(r.id_reserva) as hab_favorita\n" +
            "from habitacion h\n" +
            "inner join hotel ho on h.hotel_id = ho.id_hotel\n" +
            "inner join reserva r on h.id_habitacion = r.habitacion_id\n" +
            "group by ho.id_hotel, h.tipo_habitacion,ho.nombre_hotel\n" +
            "order by hab_favorita desc", nativeQuery = true)
    public List<String[]> habitacionFavorita();
}
