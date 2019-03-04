package Jotto.services;

import Jotto.domain.Game;
import Jotto.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game saveGame(Game game){

        return gameRepository.save(game);
    }

    @Override
    public Game getGameById(Integer gameID) {

        return gameRepository.findById(gameID).orElse(null);
    }

    @Override
    public List<Game> getMatchHistory(String username) {

        return gameRepository.getMatchHistory(username);
    }

}