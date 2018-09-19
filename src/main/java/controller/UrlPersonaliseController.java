package controller;

import com.google.gson.Gson;
import model.UrlPersonalise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UrlPersonaliseService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class UrlPersonaliseController {

    @Autowired
    private UrlPersonaliseService urlPersonaliseService;

    @CrossOrigin
    @RequestMapping(value="/urlshortener/{cleUrl}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UrlPersonalise> getUrlPersonalise(@PathVariable("cleUrl") String cleUrl) throws Exception {

        UrlPersonalise urlPersonalise = urlPersonaliseService.getUrlPersonaliseParCle(cleUrl);
        return new ResponseEntity<>(urlPersonalise, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/urlshortener/save", method = RequestMethod.POST)
    public ResponseEntity<UrlPersonalise> ajouter( @RequestBody @Valid UrlPersonalise urlPersonalise) throws Exception {

        return new ResponseEntity<>(urlPersonaliseService.enregistreUrlPersonalise(urlPersonalise), HttpStatus.OK);
    }
}
