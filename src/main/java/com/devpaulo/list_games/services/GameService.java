package com.devpaulo.list_games.services;

import com.devpaulo.list_games.dto.GameDTO;
import com.devpaulo.list_games.dto.GameMinDTO;
import com.devpaulo.list_games.entities.Game;
import com.devpaulo.list_games.projections.GameMinProjection;
import com.devpaulo.list_games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Classes de serviço recebem dados dos repositórios e processam as regras de negócio.

@Service//agora ele e um componente do sistema, o repostiorio não precisou disso pois extendeu do jpa
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
