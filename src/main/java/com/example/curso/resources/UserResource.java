package com.example.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.User;
import com.example.curso.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();		// Busca do service todos os obj(User)'s
		return ResponseEntity.ok().body(list);		// Retorna um obj(User) no formato JSON
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);			// Busca do service o obj(User) que contem o id passado na url
		return ResponseEntity.ok().body(obj);		// Retorna o obj vindo do service::repository
	}
	
}
