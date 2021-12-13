package com.devcarlos.controller;

import com.devcarlos.domain.Anime;

import com.devcarlos.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
public class AnimeController {

    @Autowired
    DateUtil dateUtil;
//@RequestMapping(method = RequestMethod.GET, path = "list") // FUNCIONA MAIS ESTA DEPRECIADO
    @GetMapping("list")
    public List<Anime> list(){
        // TODA VEZ QUE DER UM GET ELE VAI FAZER O LOG COM HORA E DATA DO SISTEMA
        log.info(dateUtil.formatdatetimestyle(LocalDateTime.now()));
        return List.of(new Anime("Naruto"), new Anime("Dragon Ball"), new Anime("Sakuyra"));
    }


}
