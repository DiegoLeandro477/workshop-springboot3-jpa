package com.example.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Product;
import com.example.curso.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();		// Busca do service todos os obj(Product)'s
		return ResponseEntity.ok().body(list);		// Retorna um obj(Product) no formato JSON
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);			// Busca do service o obj(Product) que contem o id passado na url
		return ResponseEntity.ok().body(obj);		// Retorna o obj vindo do service::repository
	}
	
}
