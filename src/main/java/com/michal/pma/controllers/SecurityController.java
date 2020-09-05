package com.michal.pma.controllers;

import com.michal.pma.dao.UserAccountRepository;
import com.michal.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, UserAccount userAccount){
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        userAccountRepository.save(userAccount);
        return "redirect:/";
    }
}
