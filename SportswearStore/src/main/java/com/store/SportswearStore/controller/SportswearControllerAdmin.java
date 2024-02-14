package com.store.SportswearStore.controller;

import com.store.SportswearStore.model.SportswearEntityAdmin;
import com.store.SportswearStore.repository.SportswearRepositoryAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class SportswearControllerAdmin {
    private final SportswearRepositoryAdmin repositoryAdmin;

    @GetMapping
    public String webAllAdmin(Model model) {
        List<SportswearEntityAdmin> entityAdmin = repositoryAdmin.findAll();
        model.addAttribute("admin", entityAdmin);
        return "admin";
    }

    @GetMapping("/createAdmin")
    public String webCreateAdmin(Model model) {
        model.addAttribute("admin", new SportswearEntityAdmin());
        return "createAdmin";
    }

    @PostMapping("/createAdmin")
    public String createAdmin(@ModelAttribute SportswearEntityAdmin entityAdmin) {
        repositoryAdmin.save(entityAdmin);
        return "redirect:/admin";
    }

    @GetMapping("/editAdmin/{id}")
    public String webEditAdmin(@PathVariable Long id, Model model) {
        SportswearEntityAdmin entityAdmin = repositoryAdmin.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверное ID администратора: " + id));
        model.addAttribute("admin", entityAdmin);
        return "editAdmin";
    }

    @PostMapping("/editAdmin/{id}")
    public String editAdmin(@PathVariable Long id, @ModelAttribute SportswearEntityAdmin entityAdmin) {
        entityAdmin.setId(id);
        repositoryAdmin.save(entityAdmin);
        return "redirect:/admin";
    }

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        repositoryAdmin.deleteById(id);
        return "redirect:/admin";
    }
}