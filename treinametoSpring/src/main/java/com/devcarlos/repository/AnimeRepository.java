package com.devcarlos.repository;

import com.devcarlos.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {


}
