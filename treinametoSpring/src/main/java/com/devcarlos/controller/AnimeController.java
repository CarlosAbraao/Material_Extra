package com.devcarlos.controller;


import com.devcarlos.entities.Anime;
import com.devcarlos.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("anime")
@RequiredArgsConstructor
public class AnimeController {

    // VARIAVEL LOCAL SERVICE
    // USANDO O REQUIREDARGSCONS...  EU N PRECISO USAR O AUTOWIRED
    // A CLASSE A SER ESTANCIADA DEVE SER SINALIZADA COM "FINAL"
    private final AnimeService animeService;


    @GetMapping
    public ResponseEntity<List<Anime>> list() {
       // return new ResponseEntity<>(animeService.allList(), HttpStatus.OK); UMA DAS FORMAS DE FAZER
         return ResponseEntity.ok(animeService.allList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> fyndById(@PathVariable long id) {
        // return new ResponseEntity<>(animeService.allList(), HttpStatus.OK);
        return ResponseEntity.ok(animeService.findById(id));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // POSSO FAZER DESSA FORMA OU DA FORMA LA EMBAIXO PAR AMOSTRAR O STATUS
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
       return new ResponseEntity<>(animeService.save(anime),HttpStatus.CREATED);
    }
}
