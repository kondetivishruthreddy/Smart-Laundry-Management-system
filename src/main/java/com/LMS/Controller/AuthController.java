package com.LMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Service.AuthService;
import com.LMS.model.Users;
import com.LMS.model.Admin;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public Users login(@RequestBody Users user) {
        return service.login(user.getRegno(), user.getPassword());
    }

    @PostMapping("/admin-login")
    public Admin adminLogin(@RequestBody Admin admin) {
        return service.adminLogin(admin.getEmail(), admin.getPassword());
    }

    @PostMapping("/admin-register")
    public Admin adminRegister(@RequestBody Admin admin) {
        return service.adminRegister(admin);
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }

    @GetMapping("/users")
    public java.util.List<Users> getUsers() {
        return service.getAllUsers();
    }
}
