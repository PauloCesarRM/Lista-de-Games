package com.devpaulo.list_games.repositories;

import com.devpaulo.list_games.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

    //este é um componente que acessa os dados e faz a busca no banco de dados
public interface GameRepository extends JpaRepository<Game, Long> {


}
