package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
