package com.StartHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StartHub.dtos.StartupDTO;
import com.StartHub.model.Startup;
import com.StartHub.repository.StartupRepository;



@Service
public class StartupService {
    
    @Autowired
	private StartupRepository repository;
	

	public StartupDTO findById(Long id) {
		Startup startup = repository.findById(id).orElseThrow(null);
        return new StartupDTO(startup);
				
	}

	public List<StartupDTO> findAll() {
		List<Startup> result = repository.findAll();
		return result.stream().map(x -> new StartupDTO(x)).toList();
	}

	
	public StartupDTO insert(StartupDTO dto) {
		Startup entity = new Startup();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity = repository.save(entity);
		return new StartupDTO(entity);
	}

	public StartupDTO update(Long id, StartupDTO dto) {
		
			Startup entity = repository.getReferenceById(id);
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity = repository.save(entity);
			return new StartupDTO(entity);

	}
	
	
	public void delete(Long id) {
		
		repository.deleteById(id);
		
	}


}


