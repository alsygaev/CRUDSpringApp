//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.education.spring.course.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.education.spring.course.dao.NotationDAO;
import ru.education.spring.course.models.Notation;

@Controller
@RequestMapping({"/notations"})
public class NotationsController {
    private final NotationDAO notationDAO;

    @Autowired
    public NotationsController(NotationDAO notationDAO) {
        this.notationDAO = notationDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("notations", this.notationDAO.index());
        return "notations/index";
    }

    @GetMapping({"/{id}"})
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("notation", this.notationDAO.show(id));
        return "notations/show";
    }

    @GetMapping({"/new"})
    public String newNotation(Model model) {
        model.addAttribute("notation", new Notation());
        return "notations/newNotation";
    }

    @PostMapping
    public String create(@ModelAttribute("notation") @Valid Notation notation,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "notations/newNotation";
        }
        this.notationDAO.save(notation);
        return "redirect:/notations";
    }

    @GetMapping({"{id}/edit"})
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("notation", this.notationDAO.show(id));
        return "notations/editNotation";
    }

    @PatchMapping({"/{id}"})
    public String update(@PathVariable("id") int id, @ModelAttribute("description") @Valid Notation notation,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "notations/editNotation";
        }
        this.notationDAO.update(id, notation);
        return "redirect:/notations";
    }

    @DeleteMapping({"/{id}"})
    public String delete(@PathVariable("id") int id) {
        this.notationDAO.delete(id);
        return "redirect:/notations";
    }
}
