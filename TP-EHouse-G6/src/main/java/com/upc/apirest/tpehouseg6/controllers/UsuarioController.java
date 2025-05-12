package com.upc.apirest.tpehouseg6.controllers;


import com.upc.apirest.tpehouseg6.dtos.UsuarioDTO;
import com.upc.apirest.tpehouseg6.entities.Usuario;
import com.upc.apirest.tpehouseg6.services.UsuarioService;
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
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsuarioDTO> listaUsuarios() {
        List<Usuario> usuarios = usuarioService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/usuario")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioDTO> adicionaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario = usuarioService.insertar(usuario);
        usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return ResponseEntity.ok(usuarioDTO);
    }
    @PutMapping("/usuario")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioDTO>  editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario = usuarioService.editar(usuario);
        usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return ResponseEntity.ok(usuarioDTO);
    }
    @DeleteMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminar(id);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDTO> buscaUsuario(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = usuarioService.buscarPorId(id);
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return ResponseEntity.ok(usuarioDTO);
    }
}

