package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @GetMapping("/bioskop/add")
    public String addBioskopForm( Model model ) {
        model.addAttribute("bioskop", new BioskopModel());

        //Return view template yang digunakan
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());

        //Return view template yang diinginkan
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);

        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(@PathVariable Long noBioskop, Model model){
        //Mendapatkan bioskop sesuai dengan noBioskop
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskop);

        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopSubmit(@ModelAttribute BioskopModel bioskop, Model model){
        //Mendapatkan bioskop sesuai dengan noBioskop
        bioskopService.updateBioskop(bioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("noBioskop", bioskop.getNoBioskop());

        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskop(@PathVariable Long noBioskop, Model model){
        //Mendapatkan penjaga sesuai dengan noPenjaga
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        model.addAttribute("noBioskop", noBioskop);

        if(bioskopService.isOpen(bioskop)){
            return "delete-bioskop-denied-open";
        }

        if(bioskopService.isDijaga(bioskop)){
            return "delete-bioskop-denied-dijaga";
        }

            bioskopService.deleteBioskop(bioskop);
            return "delete-bioskop-success";

    }
}
