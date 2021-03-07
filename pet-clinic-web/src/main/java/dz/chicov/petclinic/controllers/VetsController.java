package dz.chicov.petclinic.controllers;

import dz.chicov.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    private VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets/index", "vets", "vetsindex.html", "vets.html"})
    public String index(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
