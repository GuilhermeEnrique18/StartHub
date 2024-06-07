package com.StartHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StartHub.model.Startup;

public interface StartupRepository extends JpaRepository<Startup, Long> {
}