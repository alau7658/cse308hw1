package Jotto.services;

import Jotto.domain.Game;


import java.util.List;

public interface GameService {
    Game saveGame(Game game); //adds/updates game in DB (add = game start when valid word, save = change in gameState) *C or *U
    Game getGameById(Integer gameID); //gets the game by the gameID *R
    List<Game> getMatchHistory(String username); //Gets all the games by username *R
}