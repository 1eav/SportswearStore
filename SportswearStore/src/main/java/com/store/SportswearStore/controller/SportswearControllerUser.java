package com.store.SportswearStore.controller;

import com.store.SportswearStore.model.SportswearEntityUser;
import com.store.SportswearStore.repository.SportswearRepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class SportswearControllerUser {
    private final SportswearRepositoryUser repositoryUser;

    @GetMapping
    public String webAllUser(Model model) {
        List<SportswearEntityUser> entityUser = repositoryUser.findAll();
        model.addAttribute("user",entityUser);
        return "user";
    }

    @GetMapping("/createUser")
    public String webCreateUser(Model model) {
        model.addAttribute("user", new SportswearEntityUser());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute SportswearEntityUser entityUser) {
        repositoryUser.save(entityUser);
        return "redirect:/user";
    }

    @GetMapping("/editUser/{id}")
    public String webEditUser(@PathVariable Long id, Model model) {
        SportswearEntityUser entityUser = repositoryUser.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверное ID пользователя: " + id));
        model.addAttribute("user", entityUser);
        return "editUser";
    }

    @PostMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute SportswearEntityUser entityUser) {
        entityUser.setId(id);
        repositoryUser.save(entityUser);
        return "redirect:/user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        repositoryUser.deleteById(id);
        return "redirect:/user";
    }
}