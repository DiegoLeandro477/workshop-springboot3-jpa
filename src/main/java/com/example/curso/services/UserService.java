package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();	// Retorna todos os objs do BD
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);	// Retorna um obj Optional
		return obj.get();		// Retorna o obj(User) do obj(Optional);
	}
	
	
}