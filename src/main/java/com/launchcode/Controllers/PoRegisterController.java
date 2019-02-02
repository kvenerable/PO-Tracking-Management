package com.launchcode.Controllers;

import com.launchcode.models.PurchaseOrder;
import com.launchcode.models.PurchaseOrderData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

f
@Controller
public class PoRegisterController {


    @RequestMapping(value = "")
    public String index(Model model){



        model.addAttribute("purchaseOrders", PurchaseOrderData.getAll());
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

        PurchaseOrderData.add(newPurchaseOrder);
        return "redirect:";


    }

}
