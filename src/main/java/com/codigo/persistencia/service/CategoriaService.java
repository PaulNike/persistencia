package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.CategoriaRepository;
import com.codigo.persistencia.entity.Categoria;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    @Transactional
    public Categoria registrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
