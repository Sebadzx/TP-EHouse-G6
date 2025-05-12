package com.upc.apirest.tpehouseg6.controllers;

import com.upc.apirest.tpehouseg6.dtos.ReservaDTO;
import com.upc.apirest.tpehouseg6.entities.Reserva;
import com.upc.apirest.tpehouseg6.services.ReservaService;
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
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ReservaDTO> listaReservas() {
        List<Reserva> reservas = reservaService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return reservas.stream()
                .map(reserva -> modelMapper.map(reserva, ReservaDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/reserva")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReservaDTO> adicionaReserva(@RequestBody ReservaDTO reservaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
        reserva = reservaService.insertar(reserva);
        reservaDTO = modelMapper.map(reserva, ReservaDTO.class);
        return ResponseEntity.ok(reservaDTO);
    }
    @PutMapping("/reserva")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReservaDTO>  editarReserva(@RequestBody ReservaDTO reservaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
        reserva = reservaService.editar(reserva);
        reservaDTO = modelMapper.map(reserva, ReservaDTO.class);
        return ResponseEntity.ok(reservaDTO);
    }
    @DeleteMapping("/reserva/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarReserva(@PathVariable int id) {
        reservaService.eliminar(id);
    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<ReservaDTO> buscaReserva(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Reserva reserva = reservaService.buscarPorId(id);
        ReservaDTO reservaDTO = modelMapper.map(reserva, ReservaDTO.class);
        return ResponseEntity.ok(reservaDTO);
    }
}
