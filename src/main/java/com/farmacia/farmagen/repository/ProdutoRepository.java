package com.farmacia.farmagen.repository;

import java.util.List;
import com.farmacia.farmagen.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
}