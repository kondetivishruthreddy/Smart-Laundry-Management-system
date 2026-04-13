
package com.LMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.model.Users;
import com.LMS.model.Admin;
import com.LMS.repo.UserRepo;
import com.LMS.repo.AdminRepo;

@Service
public class AuthService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AdminRepo adminRepo;

    public Users login(String regno, String password) {
        Users user = repo.findByRegno(regno);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public Users register(Users user) {
        return repo.save(user);
    }

    public java.util.List<Users> getAllUsers() {
        return repo.findAll();
    }

    public Admin adminLogin(String email, String password) {
        // Auto-provision demo admin if none exists
        if (adminRepo.count() == 0) {
            adminRepo.save(new Admin("admin@vitap.ac.in", "admin123"));
        }

        Admin admin = adminRepo.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }

    public Admin adminRegister(Admin admin) {
        return adminRepo.save(admin);
    }
}
