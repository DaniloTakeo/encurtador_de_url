package com.url_shortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.url_shortner.dto.UrlRequestDTO;
import com.url_shortner.dto.UrlResponseDTO;
import com.url_shortner.service.UrlShortenerService;

@RestController
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<UrlResponseDTO> shorten(@RequestBody UrlRequestDTO request) {
        return ResponseEntity.ok(service.shorten(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        String originalUrl = service.getOriginalUrl(id);
        return ResponseEntity.status(302).header("Location", originalUrl).build();
    }
}