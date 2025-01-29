package com.devpaulo.list_games.repositories;


import com.devpaulo.list_games.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {


}
