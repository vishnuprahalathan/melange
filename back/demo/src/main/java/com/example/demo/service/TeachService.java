package com.example.demo.service;

import com.example.demo.model.Teach;
import com.example.demo.repository.TeachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TeachService {

    private static final Logger logger = LoggerFactory.getLogger(TeachService.class);

    @Autowired
    private TeachRepo teachRepo;

    public Teach addApplication(Teach application) {
        logger.info("Saving new Teach application: {}", application);
        return teachRepo.save(application);
    }
}
