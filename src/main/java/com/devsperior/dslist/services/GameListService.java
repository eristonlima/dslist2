package com.devsperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsperior.dslist.dto.GameListDTO;
import com.devsperior.dslist.entities.GameList;
import com.devsperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		//var result = gameListRepository.findAll();
		List<GameList> result = gameListRepository.findAll();
		
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
	}
}
