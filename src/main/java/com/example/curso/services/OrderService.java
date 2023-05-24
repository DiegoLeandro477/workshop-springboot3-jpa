package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Order;
import com.example.curso.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();	// Retorna todos os objs do BD
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);	// Retorna um obj Optional
		return obj.get();		// Retorna o obj(Order) do obj(Optional);
	}
	
	
}
