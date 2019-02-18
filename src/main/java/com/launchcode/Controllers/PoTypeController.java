package com.launchcode.Controllers;

import com.launchcode.models.PoType;
import com.launchcode.models.data.PoTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="poType")
public class PoTypeController {

    @Autowired
    private PoTypeDao poTypeDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("poTypes", poTypeDao.findAll());
        model.addAttribute("title", "PO Types");
        return "poType/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String dispalyAddPOForm(Model model) {
        model.addAttribute("poType",new PoType());
        model.addAttribute("title", "Add Type");
        model.addAttribute("poTypes",poTypeDao.findAll());
        return "poType/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPOForm(Model model, @Valid @ModelAttribute PoType poType, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("title", "Add Type");
            return "poType/add";
        }

        model.addAttribute(poTypeDao.findAll());
        poTypeDao.save(poType);
        return "redirect:";


    }
}