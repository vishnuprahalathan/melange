package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.model.Admin;
import com.example.demo.repository.UsersRepo;
import com.example.demo.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AdminRepo adminRepo;

    public Users addUser(Users user) {
        return usersRepo.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        Users user = usersRepo.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public boolean authenticateAdmin(String email, String password) {
        Admin admin = adminRepo.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }

    public Users findByEmail(String email) {
        return usersRepo.findByEmail(email);
    }

    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    public Users updateUser(Long id, Users userDetails) {
        Optional<Users> optionalUser = usersRepo.findById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword()); // Consider hashing passwords
            return usersRepo.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        usersRepo.deleteById(id);
    }
}
