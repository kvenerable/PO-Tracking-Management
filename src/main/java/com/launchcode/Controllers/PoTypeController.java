package com.launchcode.Controllers;

import com.launchcode.models.PoType;
import com.launchcode.models.data.PoTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("title", "Add Type");
        return "poType/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPOForm(@ModelAttribute PoType newPoType) {

        poTypeDao.save(newPoType);
        return "redirect:";


    }
}