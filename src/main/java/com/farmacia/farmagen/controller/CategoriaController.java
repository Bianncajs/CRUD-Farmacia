package com.farmacia.farmagen.controller;

import com.farmacia.farmagen.model.Categoria;
import com.farmacia.farmagen.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {

		Categoria categoriaCriada = categoriaRepository.save(categoria);
		return new ResponseEntity<>(categoriaCriada, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {

		List<Categoria> categorias = categoriaRepository.findAll();
		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {

		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		categoria.setId(id);
		Categoria categoriaAtualizada = categoriaRepository.save(categoria);
		return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
