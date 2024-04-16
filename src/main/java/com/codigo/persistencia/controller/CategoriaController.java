package com.codigo.persistencia.controller;

import com.codigo.persistencia.dao.CategoriaRepository;
import com.codigo.persistencia.entity.Categoria;
import com.codigo.persistencia.entity.Producto;
import com.codigo.persistencia.request.ProductoRequest;
import com.codigo.persistencia.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categoria")
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping("/crearCategoria")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria registrarCategoria;
        registrarCategoria = categoriaService.registrarCategoria(categoria);
        return ResponseEntity.ok(registrarCategoria);
    }

}
