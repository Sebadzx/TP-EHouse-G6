package com.upc.apirest.tpehouseg6.controllers;


import com.upc.apirest.tpehouseg6.dtos.HabitacionDTO;
import com.upc.apirest.tpehouseg6.dtos.HabitacionFavoritaDTO;
import com.upc.apirest.tpehouseg6.entities.Habitacion;
import com.upc.apirest.tpehouseg6.services.HabitacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/habitaciones")
    @PreAuthorize("hasRole('ADMIN')")
    public List<HabitacionDTO> listaHabitaciones() {
        List<Habitacion> habitaciones = habitacionService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return habitaciones.stream()
                .map(habitacion -> modelMapper.map(habitacion, HabitacionDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/habitacion")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HabitacionDTO> adicionaHabitacion(@RequestBody HabitacionDTO habitacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Habitacion habitacion = modelMapper.map(habitacionDTO, Habitacion.class);
        habitacion = habitacionService.insertar(habitacion);
        habitacionDTO = modelMapper.map(habitacion, HabitacionDTO.class);
        return ResponseEntity.ok(habitacionDTO);
    }
    @PutMapping("/habitacion")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HabitacionDTO>  editarHabitacion(@RequestBody HabitacionDTO habitacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Habitacion habitacion= modelMapper.map(habitacionDTO, Habitacion.class);
        habitacion = habitacionService.editar(habitacion);
        habitacionDTO = modelMapper.map(habitacion, HabitacionDTO.class);
        return ResponseEntity.ok(habitacionDTO);
    }
    @DeleteMapping("/habitacion/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarHabitacion(@PathVariable int id) {
        habitacionService.eliminar(id);
    }

    @GetMapping("/habitacion/{id}")
    public ResponseEntity<HabitacionDTO> buscaHabitacion(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Habitacion habitacion = habitacionService.buscarPorId(id);
        HabitacionDTO habitacionDTO = modelMapper.map(habitacion, HabitacionDTO.class);
        return ResponseEntity.ok(habitacionDTO);
    }

    @GetMapping("/preferenciahabitacion")
    @PreAuthorize("hasRole('ADMIN')")
    public List<HabitacionFavoritaDTO> habitacionFavorita() {
        List<String[]> lista = habitacionService.habitacionFavorita();
        List<HabitacionFavoritaDTO> listaDTO = new java.util.ArrayList<>();
        for (String[] columna : lista) {
            HabitacionFavoritaDTO dto = new HabitacionFavoritaDTO();
            dto.setIdHotel(Integer.parseInt(columna[0]));
            dto.setNombreHotel(columna[1]);
            dto.setTipoHabitacion(columna[2]);
            dto.setIdHabitacionFavorita(Integer.parseInt(columna[3]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
