package com.upc.apirest.tpehouseg6.controllers;


import com.upc.apirest.tpehouseg6.dtos.HotelDTO;
import com.upc.apirest.tpehouseg6.dtos.NroHabitacionesDTO;
import com.upc.apirest.tpehouseg6.entities.Hotel;
import com.upc.apirest.tpehouseg6.services.HotelService;
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
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hoteles")
    @PreAuthorize("hasRole('ADMIN')")
    public List<HotelDTO> listaHoteles() {
        List<Hotel> hoteles= hotelService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return hoteles.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/hotel")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HotelDTO> adicionaHotel(@RequestBody HotelDTO hotelDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
        hotel = hotelService.insertar(hotel);
        hotelDTO = modelMapper.map(hotel, HotelDTO.class);
        return ResponseEntity.ok(hotelDTO);
    }
    @PutMapping("/hotel")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HotelDTO>  editarHotel(@RequestBody HotelDTO hotelDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
        hotel = hotelService.editar(hotel);
        hotelDTO = modelMapper.map(hotel, HotelDTO.class);
        return ResponseEntity.ok(hotelDTO);
    }
    @DeleteMapping("/hotel/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarHotel(@PathVariable int id) {
        hotelService.eliminar(id);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDTO> buscaHotel(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Hotel hotel = hotelService.buscarPorId(id);
        HotelDTO hotelDTO = modelMapper.map(hotel, HotelDTO.class);
        return ResponseEntity.ok(hotelDTO);
    }

    @GetMapping("/nmroHabitaciones")
    @PreAuthorize("hasRole('ADMIN')")
    public List<NroHabitacionesDTO> nmroHabitaciones() {
        List<String[]> lista = hotelService.nmroHabitaciones();
        List<NroHabitacionesDTO> listaDTO = new java.util.ArrayList<>();
        for (String[] columna : lista) {
            NroHabitacionesDTO dto = new NroHabitacionesDTO();
            dto.setIdHotel(Integer.parseInt(columna[0]));
            dto.setNombreHotel(columna[1]);
            dto.setNroHabitaciones(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
