package fr.lernejo.travelsite;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")



public class PostInscription {

    @GetMapping("/travels")
    public ResponseEntity<List<Voyage>> Voyages() {
        List<Voyage> VoyagesList = new ArrayList<Voyage>();
        Voyage Voyage1 = new Voyage("Caribbean", (float) 32.4);
        Voyage Voyage2 = new Voyage("Australia", (float) 35.1);
        VoyagesList.add(Voyage1);
        VoyagesList.add(Voyage2);
        return new ResponseEntity<List<Voyage>>(VoyagesList, HttpStatus.OK);
    }
    @PostMapping(value = "/inscription", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> register(@RequestBody Utilisateur utilisateur){


        return new ResponseEntity<Boolean>(utilisateur.validInscription(),HttpStatus.OK);
    }


}








