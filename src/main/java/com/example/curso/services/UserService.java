package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;
import com.example.curso.services.exceptions.DatabaseException;
import com.example.curso.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll(); // Retorna todos os objs do BD
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); // Retorna um obj Optional
		return obj.orElseThrow(()-> new ResourceNotFoundException(id)); // Retorna o obj(User) do obj(Optional);
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DatabaseException(ex.getMessage());
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateDate(entity, obj);
			return repository.save(entity);			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
