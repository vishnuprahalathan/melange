package com.example.demo.controller;

import com.example.demo.model.Skills;
import com.example.demo.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:3000") // Adjust this if your frontend runs on a different port
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @GetMapping
    public ResponseEntity<List<Skills>> getAllSkills() {
        try {
            List<Skills> skills = skillsService.getAllSkills();
            return new ResponseEntity<>(skills, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Skills> addSkill(@RequestBody Skills skill) {
        try {
            Skills createdSkill = skillsService.addSkill(skill);
            return new ResponseEntity<>(createdSkill, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSkill(@PathVariable("id") Long id) {
        try {
            skillsService.deleteSkill(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
