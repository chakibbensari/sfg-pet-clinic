package dz.chicov.petclinic.controllers;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("owners")
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "index", "index.html"})
    public String index(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
