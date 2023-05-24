package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Category;
import com.example.curso.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();	// Retorna todos os objs do BD
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);	// Retorna um obj Optional
		return obj.get();		// Retorna o obj(Category) do obj(Optional);
	}
	
	
}
