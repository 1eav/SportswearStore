package com.store.SportswearStore.controller;

import com.store.SportswearStore.DTO.SportswearDtoProduct;
import com.store.SportswearStore.model.SportswearEntityProduct;
import com.store.SportswearStore.repository.SportswearRepositoryProduct;
import com.store.SportswearStore.service.ProductCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class SportswearControllerProduct {
    private final SportswearRepositoryProduct repositoryProduct;
    private final ProductCrudService crudService;

    @GetMapping
    public String webAllProduct(Model model, @Param("keyword") String keyword) {
        List<SportswearDtoProduct> result = crudService.listAll(keyword);
        model.addAttribute("product", result);
        return "product";
    }

    @RequestMapping("/product")
    public String searchProduct(Model model, @Param("keyword") String keyword) {
        List<SportswearDtoProduct> result = crudService.listAll(keyword);
        model.addAttribute("product", result);
        return "redirect:/product";
    }

    @GetMapping("/createProduct")
    public String webCreateProduct(Model model) {
        model.addAttribute("product", new SportswearEntityProduct());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute SportswearEntityProduct entityProduct) {
        repositoryProduct.save(entityProduct);
        return "redirect:/product";
    }

    @GetMapping("/editProduct/{id}")
    public String webEditProduct(@PathVariable Long id, Model model) {
        SportswearEntityProduct entityProduct = repositoryProduct.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверное ID товара: " + id));
        model.addAttribute("product", entityProduct);
        return "editProduct";
    }

    @PostMapping("/editProduct/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute SportswearEntityProduct entityProduct) {
        entityProduct.setId(id);
        repositoryProduct.save(entityProduct);
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repositoryProduct.deleteById(id);
        return "redirect:/product";
    }
}