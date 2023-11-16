package com.devsperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
