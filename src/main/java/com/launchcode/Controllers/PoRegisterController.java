package com.launchcode.Controllers;

import com.launchcode.models.PoType;
import com.launchcode.models.PurchaseOrder;
import com.launchcode.models.data.PoTypeDao;
import com.launchcode.models.data.PurchaseOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value = "poRegister")
public class PoRegisterController {

    @Autowired
    private PoTypeDao poTypeDao;

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;


    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("purchaseOrders", purchaseOrderDao.findAll());
        model.addAttribute("title", "PO Register");
        return "poRegister/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String dispalyAddPOForm(Model model) {
        model.addAttribute("title", "Add PO");
        model.addAttribute(new PurchaseOrder());
        model.addAttribute("poTypes", poTypeDao.findAll());
        return "poRegister/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPOForm(@Valid @ModelAttribute PurchaseOrder newPurchaseOrder, Errors errors, @RequestParam int poTypeId, Model model) {

        if (errors.hasErrors()) {

            model.addAttribute("title", "Add Type");
            model.addAttribute("poTypes", poTypeDao.findAll());
            return "poRegister/add";
        }

        PoType ptype = poTypeDao.findOne(poTypeId);
        newPurchaseOrder.setPoType(ptype);
        purchaseOrderDao.save(newPurchaseOrder);
        return "redirect:";


    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveForm(Model model) {
        model.addAttribute("purchaseOrders", purchaseOrderDao.findAll());
        model.addAttribute("title", "Remove Purchase Order");
        return "poRegister/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] poIds) {

        for (int poId : poIds) {
            purchaseOrderDao.delete(poId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "poType", method = RequestMethod.GET)
    public String poType(Model model, @RequestParam int id) {

        PoType ptype = poTypeDao.findOne(id);
        List<PurchaseOrder> purchaseOrders = ptype.getPurchaseOrders();
        model.addAttribute("purchaseOrders", purchaseOrders);
        model.addAttribute("title", "PO's by Type: " + ptype.getName());
        return "poRegister/index";

    }

    @RequestMapping(value ="completed", method = RequestMethod.GET)
    public String completed(Model model) {


        model.addAttribute("purchaseOrders", purchaseOrderDao.findAll());
        model.addAttribute("title", "Complete Projects");
        return "poRegister/completed";

    }


    @RequestMapping(value = "completedIndex", method = RequestMethod.GET)
    public String processCompletedForm(Model model, @RequestParam int [] poIds, PurchaseOrder completePO) {

            for (int poId : poIds) {

                PurchaseOrder donePO = purchaseOrderDao.findOne(poId);
                completePO.setPoId(poId);
                purchaseOrderDao.save(completePO);

            }


            model.addAttribute("purchaseOrders",purchaseOrderDao.findAll());
            model.addAttribute("title", "Completed Projects");






            return "poRegister/completedIndex";

    }
}



