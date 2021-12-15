package com.devcarlos.service;

import com.devcarlos.Exceptions.BadRequestException;
import com.devcarlos.entities.Anime;
import com.devcarlos.mapper.AnimeMapper;
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



    // LISTANDO TODOS ANIMES
    public List<Anime> findByName(String name) {

        return animeRepository.findByName(name);
    }

// PEGANDO O ANIME PELO ID
    public Anime findByIdOrThrowBadRequestExecption(Long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException( "Anime not found"));
    }


    public Anime save(AnimePostRequestBody animePostRequestBody) {
     return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));



    }

    public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestExecption(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findByIdOrThrowBadRequestExecption(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
