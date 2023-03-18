package com.example.demo.controller;

import com.example.demo.model.BlindPerson;
import com.example.demo.service.IBlindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlindPersonController {
    @Autowired
    private IBlindService blindService;

    @GetMapping("")
    public String findAll(Model model,
                          @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<BlindPerson> blindPersonPage = this.blindService.findAll(pageable);
        System.out.println(blindPersonPage);
        model.addAttribute("blindPersonPage", blindPersonPage);
        return "list-cv";
    }

    @GetMapping("form")
    public String getForm(Model model) {
        model.addAttribute("blindPerson", new BlindPerson());
        return "form-cv";
    }

    @PostMapping("create")
    public String addNew(@ModelAttribute BlindPerson blindPerson) {
        this.blindService.save(blindPerson);
        return "redirect:/";
    }
}
