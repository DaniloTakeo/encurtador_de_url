package com.url_shortner.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.url_shortner.dto.UrlRequestDTO;
import com.url_shortner.dto.UrlResponseDTO;
import com.url_shortner.model.UrlMapping;
import com.url_shortner.repository.UrlMappingRepository;

@Service
public class UrlShortenerService {

    private final UrlMappingRepository repository;

    public UrlShortenerService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public UrlResponseDTO shorten(UrlRequestDTO request) {
        String id = generateUniqueId();
        UrlMapping mapping = new UrlMapping();
        mapping.setId(id);
        mapping.setOriginalUrl(request.url());
        repository.save(mapping);
        return new UrlResponseDTO("http://localhost:8080/" + id);
    }

    public String getOriginalUrl(String id) {
        return repository.findById(id)
                .map(url -> {
                    url.setAccessCount(url.getAccessCount() + 1);
                    repository.save(url);
                    return url.getOriginalUrl();
                })
                .orElseThrow(() -> new RuntimeException("URL não encontrada"));
    }

    private String generateUniqueId() {
        String id;
        do {
            id = UUID.randomUUID().toString().substring(0, 6);
        } while (repository.existsById(id));
        return id;
    }
}