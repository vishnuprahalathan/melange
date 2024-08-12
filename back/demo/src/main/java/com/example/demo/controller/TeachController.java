package com.example.demo.controller;

import com.example.demo.model.Teach;
import com.example.demo.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teach")
@CrossOrigin(origins = "http://localhost:3000") // Adjust this if your frontend runs on a different port
public class TeachController {

    @Autowired
    private TeachService teachService;

    @PostMapping
    public ResponseEntity<Teach> addApplication(@RequestBody Teach application) {
        Teach savedApplication = teachService.addApplication(application);
        return ResponseEntity.ok(savedApplication);
    }
}
