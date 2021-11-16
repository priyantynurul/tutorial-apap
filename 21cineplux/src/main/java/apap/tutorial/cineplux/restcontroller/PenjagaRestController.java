package apap.tutorial.cineplux.restcontroller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.PenjagaRestService;
import apap.tutorial.cineplux.rest.BioskopDetail;
import apap.tutorial.cineplux.service.BioskopRestService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class PenjagaRestController {
    @Autowired
    private PenjagaRestService penjagaRestService;

    @Autowired
    private PenjagaService penjagaService;

    @PostMapping(value = "/penjaga")
    private PenjagaModel createPenjaga(@Valid @RequestBody PenjagaModel penjaga, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        } else {
            return penjagaRestService.createPenjaga(penjaga);
        }
    }

    @PutMapping(value = "/penjaga/{noPenjaga}")
    private PenjagaModel updatePenjaga(@PathVariable("noPenjaga") Long noPenjaga, @RequestBody PenjagaModel penjaga){
        try{
            return penjagaRestService.updatePenjaga(noPenjaga, penjaga);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Penjaga with No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }

    @GetMapping(value = "/penjaga/{noPenjaga}")
    private PenjagaModel retrievePenjaga(@PathVariable("noPenjaga") Long noPenjaga) {
        try {
            return penjagaRestService.getPenjagaByNoPenjaga(noPenjaga);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }

    @GetMapping(value = "/list-penjaga")
    private List<PenjagaModel> retrieveListPenjaga() {
        return penjagaRestService.retrieveListPenjaga();
    }

    @GetMapping(value = "/list-penjaga/{jenisKelamin}")
    private List<PenjagaModel> retrievePenjagaByGender(@PathVariable("jenisKelamin") Integer jenisKelamin) {
        List<PenjagaModel> listPenjaga = penjagaRestService.retrieveListPenjaga();

        List<PenjagaModel> filtered = new ArrayList();
        for(PenjagaModel penjaga : listPenjaga){
            if(penjaga.getJenisKelamin()==jenisKelamin){
                filtered.add(penjaga);
            }
        }

        return filtered;
    }

    @DeleteMapping(value = "/penjaga/{noPenjaga}")
    private ResponseEntity deletePenjaga(@PathVariable("noPenjaga") Long noPenjaga){
        try{
            penjagaRestService.deletePenjaga(noPenjaga);
            return ResponseEntity.ok("Penjaga with No Penjaga " + String.valueOf(noPenjaga) + " Deleted!");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Penjaga with No Penjaga " + String.valueOf(noPenjaga) + " Not Found.");
        } catch (UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bioskop is still open or has penjaga!");
        }
    }

    @GetMapping(value = "/penjaga/umur/{noPenjaga}")
    private PenjagaModel umurPenjaga(@PathVariable("noPenjaga") Long noPenjaga) {
        try {
            PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
            System.out.println(penjagaRestService.getUmur(noPenjaga));

            String[] umur1 = penjagaRestService.getUmur(noPenjaga).split(",");

            String umur2 = umur1[1];

            System.out.println(umur2);
            Integer umur3 = Integer.valueOf(umur2.split(":")[1]);
            System.out.println(umur3);
            penjaga.setUmur(umur3);
            return penjaga;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }
}