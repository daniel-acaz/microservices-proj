package br.com.broscoder.hruser.controller;

import br.com.broscoder.hruser.model.User;
import br.com.broscoder.hruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}
