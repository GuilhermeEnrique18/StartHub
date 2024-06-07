package com.StartHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.StartHub.dtos.StartupDTO;
import com.StartHub.service.StartupService;

import java.util.List;

@RestController
@RequestMapping("/startups")
public class StartupController {

    @Autowired
    private StartupService service;

    @PostMapping
    public ResponseEntity<StartupDTO> createStartup(@RequestBody StartupDTO startup) {
        StartupDTO createdStartup = service.insert(startup);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStartup);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StartupDTO> getStartupById(@PathVariable Long id) {
        StartupDTO startup = service.findById(id);
        return ResponseEntity.ok(startup);
    }

    @GetMapping
    public ResponseEntity<List<StartupDTO>> getAllStartups() {
        List<StartupDTO> startups = service.findAll();
        return ResponseEntity.ok(startups);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStartup(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StartupDTO> update(@PathVariable Long id, @RequestBody StartupDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

}

