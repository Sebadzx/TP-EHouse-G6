package com.upc.apirest.tpehouseg6.controllers;


import com.upc.apirest.tpehouseg6.dtos.SAdicionalesDTO;
import com.upc.apirest.tpehouseg6.entities.SAdicionales;
import com.upc.apirest.tpehouseg6.services.SAdicionalService;
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
public class SAdicionalController {
    @Autowired
    private SAdicionalService sAdicionalService;

    @GetMapping("/sAdicionales")
    @PreAuthorize("hasRole('ADMIN')")
    public List<SAdicionalesDTO> listaSAdicionales() {
        List<SAdicionales> sAdicionales = sAdicionalService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return sAdicionales.stream()
                .map(sAdicional -> modelMapper.map(sAdicional, SAdicionalesDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/sAdicional")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SAdicionalesDTO> adicionaSAdicional(@RequestBody SAdicionalesDTO sAdicionalDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SAdicionales sAdicional = modelMapper.map(sAdicionalDTO, SAdicionales.class);
        sAdicional = sAdicionalService.insertar(sAdicional);
        sAdicionalDTO = modelMapper.map(sAdicional, SAdicionalesDTO.class);
        return ResponseEntity.ok(sAdicionalDTO);
    }
    @PutMapping("/sAdicional")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SAdicionalesDTO>  editarSAdicional(@RequestBody SAdicionalesDTO sAdicionalDTO) {
        ModelMapper modelMapper = new ModelMapper();
        SAdicionales sAdicional = modelMapper.map(sAdicionalDTO, SAdicionales.class);
        sAdicional= sAdicionalService.editar(sAdicional);
        sAdicionalDTO = modelMapper.map(sAdicional, SAdicionalesDTO.class);
        return ResponseEntity.ok(sAdicionalDTO);
    }
    @DeleteMapping("/sAdicional/{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public void eliminarSAdicional(@PathVariable int id) {
        sAdicionalService.eliminar(id);
    }

    @GetMapping("/sAdicional/{id}")
    public ResponseEntity<SAdicionalesDTO> buscaSAdicional(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        SAdicionales sAdicional = sAdicionalService.buscarPorId(id);
        SAdicionalesDTO sAdicionalDTO = modelMapper.map(sAdicional, SAdicionalesDTO.class);
        return ResponseEntity.ok(sAdicionalDTO);
    }
}
