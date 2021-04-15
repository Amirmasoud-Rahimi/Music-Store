package com.demisco.project.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.demisco.project.repository.UserRepo;
import com.demisco.project.exception.*;
import com.demisco.project.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/authenticate")
public class AuthenticationController {
    private UserRepo userRepo;

    public AuthenticationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(RedirectAttributes model, User user) {
        userRepo.save(user);
        model.addFlashAttribute("registeredSuccessfully", "New Member Registered Successfully. Now Login");
        return "redirect:/authenticate/userLogin";
    }

    @GetMapping("/userLogin")
    public String userLoginPage(Model model) {
        model.addAttribute("userR", "userRole");
        return "login";
    }

    @PostMapping("/userLogin")
    public String userLogin(String userName, String password, HttpSession session) {
        User user = userRepo.findByUserNameAndPasswordAndUserType(userName, password, "member")
                .orElseThrow(InvalidInputException::new);
        if (session.getAttribute("member") != null) {
            session.removeAttribute("cart"); //for Login with a Browser as Different Users
        }
        session.setAttribute("member", user);
        return "redirect:/member";
    }

    @GetMapping("/userLogout")
    public String userLogout(HttpSession session) {
        session.removeAttribute("member");
        session.removeAttribute("cart"); //for Login with a Browser as Different Users
        return "Music";
    }

    @GetMapping("/adminLogin")
    public String adminLoginPage(Model model) {
        model.addAttribute("adminR", "adminRole");
        return "login";
    }

    @PostMapping("/adminLogin")
    public String adminLogin(String userName, String password, HttpSession session) {
        userRepo.findByUserNameAndPasswordAndUserType(userName, password, "admin")
                .orElseThrow(InvalidInputException::new);
        session.setAttribute("admin", "administrator");
        return "redirect:/admin";
    }

    @GetMapping("/adminLogout")
    public String adminLogout(HttpSession session) {
        session.removeAttribute("admin");
        return "Music";
    }

    @GetMapping("/profileRecovery")
    public String profileRecoveryPage() {
        return "profileRecovery";
    }

    @PostMapping("/profileRecovery")
    public String profileRecoveryResult(RedirectAttributes model, String email) {
        User user = userRepo.findByEmailAndUserType(email, "member");
        if (user == null) throw new UserNotFoundException();
        model.addFlashAttribute("result", user);
        return "redirect:/authenticate/profileRecovery";
    }
}