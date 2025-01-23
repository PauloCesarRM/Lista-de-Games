package com.devpaulo.list_games.services;

import com.devpaulo.list_games.dto.GameMinDTO;
import com.devpaulo.list_games.entities.Game;
import com.devpaulo.list_games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//agora ele e um componente do sistema, o repostiorio não precisou disso pois extendeu do jpa
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
