package com.devcarlos.controller;


import com.devcarlos.entities.Anime;
import com.devcarlos.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
@RequiredArgsConstructor
public class AnimeController {

    // VARIAVEL LOCAL SERVICE

    private final AnimeService animeService;


    @GetMapping
    public List<Anime> list(){
        return animeService.allList();
    }
}
