package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Product;
import com.example.curso.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();	// Retorna todos os objs do BD
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);	// Retorna um obj Optional
		return obj.get();		// Retorna o obj(Product) do obj(Optional);
	}
	
	
}
