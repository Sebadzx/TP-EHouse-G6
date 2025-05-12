package com.upc.apirest.tpehouseg6.controllers;


import com.upc.apirest.tpehouseg6.dtos.ReseniaDTO;
import com.upc.apirest.tpehouseg6.entities.Resenia;
import com.upc.apirest.tpehouseg6.services.ReseniaService;
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
public class ReseniaController {
    @Autowired
    private ReseniaService reseniaService;

    @GetMapping("/resenias")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ReseniaDTO> listaResenias() {
        List<Resenia> resenias = reseniaService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return resenias.stream()
                .map(resenia -> modelMapper.map(resenia, ReseniaDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/resenia")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReseniaDTO> adicionaResenia(@RequestBody ReseniaDTO reseniaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Resenia resenia = modelMapper.map(reseniaDTO, Resenia.class);
        resenia = reseniaService.insertar(resenia);
        reseniaDTO = modelMapper.map(resenia, ReseniaDTO.class);
        return ResponseEntity.ok(reseniaDTO);
    }
    @PutMapping("/resenia")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReseniaDTO>  editarResenia(@RequestBody ReseniaDTO reseniaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Resenia resenia = modelMapper.map(reseniaDTO, Resenia.class);
        resenia = reseniaService.editar(resenia);
        reseniaDTO = modelMapper.map(resenia, ReseniaDTO.class);
        return ResponseEntity.ok(reseniaDTO);
    }
    @DeleteMapping("/resenia/{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public void eliminarResenia(@PathVariable int id) {
        reseniaService.eliminar(id);
    }

    @GetMapping("/resenia/{id}")
    public ResponseEntity<ReseniaDTO> buscaResenia(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Resenia resenia = reseniaService.buscarPorId(id);
        ReseniaDTO reseniaDTO = modelMapper.map(resenia, ReseniaDTO.class);
        return ResponseEntity.ok(reseniaDTO);
    }
}