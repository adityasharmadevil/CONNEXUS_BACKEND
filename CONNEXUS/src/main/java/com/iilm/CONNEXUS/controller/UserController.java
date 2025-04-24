package com.iilm.CONNEXUS.controller;



import com.iilm.CONNEXUS.service.UserService;
import com.iilm.CONNEXUS.user.User;
import com.iilm.CONNEXUS.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordUtil passwordUtil;

    // 🟢 Register New User
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            // Hash the password before saving
            String hashedPassword = passwordUtil.hashPassword(user.getPasswordHash());
            user.setPasswordHash(hashedPassword);

            userService.createUser(user);

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error registering user: " + e.getMessage());
        }
    }
}

