package com.example.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*") // Allow frontend requests
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String testAPI() {
        return "API is working";
    }
    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userService.authenticateUser(email, password) ? "Login successful!" : "Invalid credentials";
    }
}
