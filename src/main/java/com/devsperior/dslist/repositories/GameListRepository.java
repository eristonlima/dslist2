package com.devsperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
