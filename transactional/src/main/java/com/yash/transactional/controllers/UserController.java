package com.yash.transactional.controllers;

import com.yash.transactional.models.User;
import com.yash.transactional.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final GenericService genericService;

    public UserController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return genericService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return genericService.getUserById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return genericService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return genericService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        genericService.deleteUser(id);
    }
}
