package com.devcarlos.service;

import com.devcarlos.entities.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> allList(){
        return List.of(new Anime(1l,"Naturo"), new Anime(2l,"Sakura"), new Anime(3l,"Garfield"));
    }}
