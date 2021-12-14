package com.devcarlos.service;

import com.devcarlos.entities.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
public static List<Anime> animes;

static {
    animes = new ArrayList<>(List.of(new Anime(1l,"Naturo"), new Anime(2l,"Sakura"), new Anime(3l,"Garfield")));
}
    public  List<Anime> allList(){

    return animes;
    }


    public Anime findById(Long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }


    public Anime save(Anime anime) {

    // GERANDO UM NUMERO ALEATORIO E INSERINDO NO ID
    anime.setId(ThreadLocalRandom.current().nextLong(3,500));
    animes.add(anime);
    return anime;



    }
}
