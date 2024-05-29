package com.StartHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StartHub.model.Startup;
import com.StartHub.repository.StartupRepository;

@Service
public class StartupServiceImpl implements StartupService {

    @Autowired
    private StartupRepository startupRepository;

    @Override
    public Startup saveStartup(Startup startup) {
        return startupRepository.save(startup);
    }

    @Override
    public Startup getStartupById(Long id) {
        Optional<Startup> startup = startupRepository.findById(id);
        return startup.orElse(null);
    }

    @Override
    public List<Startup> getAllStartups() {
        return startupRepository.findAll();
    }

    @Override
    public void deleteStartup(Long id) {
        startupRepository.deleteById(id);
    }

    
}