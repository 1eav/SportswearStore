package com.store.SportswearStore.controller;

import com.store.SportswearStore.model.SportswearEntityImage;
import com.store.SportswearStore.repository.SportswearRepositoryImage;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SportswearControllerImage {
    private final SportswearRepositoryImage repositoryImage;

    @GetMapping("/image")
    public String webImage(Model model) {
        List<SportswearEntityImage> entityImages = repositoryImage.findAll();
        model.addAttribute("image", entityImages);
        return "image";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam MultipartFile img, HttpSession session) {
        SportswearEntityImage loadImage = new SportswearEntityImage();
        loadImage.setImageName(img.getOriginalFilename());
        SportswearEntityImage uploadImage = repositoryImage.save(loadImage);
        try {
            File saveFile = new ClassPathResource("static/css").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
            System.out.println(path);
            Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("msg", "Загрузка завершена");
        return "redirect:/image";
    }
}