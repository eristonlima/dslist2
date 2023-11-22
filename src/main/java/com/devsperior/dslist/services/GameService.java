package com.devsperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsperior.dslist.dto.GameDTO;
import com.devsperior.dslist.dto.GameMinDTO;
import com.devsperior.dslist.entities.Game;
import com.devsperior.dslist.projections.GameMinProjection;
import com.devsperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(game);
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		
		var result = gameRepository.findAll();
		
		//Transforma os tipos de objeto
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
}
