package com.example.demo.repository;

import com.example.demo.model.Teach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachRepo extends JpaRepository<Teach, Long> {
}
