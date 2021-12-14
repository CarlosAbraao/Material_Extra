package com.devcarlos.service;

import com.devcarlos.entities.Anime;
import com.devcarlos.repository.AnimeRepository;
import com.devcarlos.request.AnimePostRequestBody;
import com.devcarlos.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {

   private final AnimeRepository animeRepository;
// LISTANDO TODOS ANIMES
    public List<Anime> allList() {

        return animeRepository.findAll();
    }

// PEGANDO O ANIME PELO ID
    public Anime findByIdOrThrowBadRequestExecption(Long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }


    public Anime save(AnimePostRequestBody animePostRequestBody) {
     Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
     return animeRepository.save(anime);



    }

    public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestExecption(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody){
        findByIdOrThrowBadRequestExecption(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(animePutRequestBody.getId())
                .name(animePutRequestBody.getName())
                .build();
        animeRepository.save(anime);
    }
}
