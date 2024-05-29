package com.StartHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.StartHub.dtos.UserDto;
import com.StartHub.model.User;
import com.StartHub.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
	private UserRepository repository;
	

	public UserDto findById(Long id) {
		User user = repository.findById(id).orElseThrow(null);
        return new UserDto(user);
	}

	public List<UserDto> findAll() {
		List<User> result = repository.findAll();
        return result.stream().map(x -> new UserDto(x)).toList();
	}

	public UserDto insert(UserDto dto) {
		User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());

		entity = repository.save(entity);
		return new UserDto(entity);
	}

	public UserDto update(Long id, UserDto dto) {
			User entity = repository.getReferenceById(id);
            entity.setId(dto.getId());
			entity.setEmail(dto.getEmail());
            entity.setPassword(dto.getPassword());
            entity.setUsername(dto.getUsername());
			entity = repository.save(entity);
			return new UserDto(entity);
			
		

	}
	
	
	public void delete(Long id) {
		
		repository.deleteById(id);
		
	}

}