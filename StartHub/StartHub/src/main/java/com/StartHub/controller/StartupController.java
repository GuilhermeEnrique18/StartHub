package com.StartHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.StartHub.model.Startup;
import com.StartHub.service.StartupService;

import java.util.List;

@RestController
@RequestMapping("/api/startups")
public class StartupController {

    @Autowired
    private StartupService startupService;

    @PostMapping
    public ResponseEntity<Startup> createStartup(@RequestBody Startup startup) {
        Startup createdStartup = startupService.saveStartup(startup);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStartup);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Startup> getStartupById(@PathVariable Long id) {
        Startup startup = startupService.getStartupById(id);
        return ResponseEntity.ok(startup);
    }

    @GetMapping
    public ResponseEntity<List<Startup>> getAllStartups() {
        List<Startup> startups = startupService.getAllStartups();
        return ResponseEntity.ok(startups);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStartup(@PathVariable Long id) {
        startupService.deleteStartup(id);
        return ResponseEntity.noContent().build();
    }
}