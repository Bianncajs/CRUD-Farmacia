package com.farmacia.farmagen.repository;

import com.farmacia.farmagen.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}