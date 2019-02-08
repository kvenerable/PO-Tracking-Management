package com.launchcode.Controllers;

import com.launchcode.models.PurchaseOrder;
import com.launchcode.models.data.PoTypeDao;
import com.launchcode.models.data.PurchaseOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "poRegister")
public class PoRegisterController {

    @Autowired
    private PoTypeDao poTypeDao;

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;


    @RequestMapping(value = "")
    public String index(Model model){



        model.addAttribute("purchaseOrders", purchaseOrderDao.findAll());
        model.addAttribute("title","PO Register");
        return "poRegister/index";
    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String dispalyAddPOForm(Model model){
        model.addAttribute("title","Add PO");
        return "poRegister/add";

    }
    @RequestMapping(value = "add", method= RequestMethod.POST)
    public String processAddPOForm(@ModelAttribute PurchaseOrder newPurchaseOrder){

        purchaseOrderDao.save(newPurchaseOrder);
        return "redirect:";


    }

}
