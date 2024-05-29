package com.StartHub.service;

import java.util.List;

import com.StartHub.model.Startup;

public interface StartupService {
    Startup saveStartup(Startup startup);
    Startup getStartupById(Long id);
    List<Startup> getAllStartups();
    void deleteStartup(Long id);
}


