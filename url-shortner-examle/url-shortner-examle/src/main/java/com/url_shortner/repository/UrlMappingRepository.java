package com.url_shortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.url_shortner.model.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {
    boolean existsById(String id);
}