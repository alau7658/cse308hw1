package Jotto.controller;

import Jotto.algo.Algorithm;
import Jotto.domain.Game;
import Jotto.domain.GameState;
import Jotto.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import org.json.*;

import java.util.Date;

@Controller
@RequestMapping(value="/newgame.html")
public class ajaxNewGameController {
    private GameService gameService;
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    @ResponseBody
    public String newWordCheck(HttpServletRequest request) {
        String userWord = request.getParameter("word");
        String username = request.getParameter("username");
        Algorithm.initialSet();
        Algorithm.emptyAll();
        Algorithm.initialSet();
        if(Algorithm.checkInput(userWord)) {
            Algorithm.startgame(userWord);
            String cpuWord = Algorithm.AIgiven.toLowerCase();
            Game game = new Game();
            game.username = username;
            game.game_state = GameState.INCOMPLETE;
            game.user_word = userWord;
            game.cpu_word = cpuWord;
            game.date_created = new Date();
            gameService.saveGame(game);


            int game_id = game.getGame_id();

            JSONObject result = new JSONObject()
                    .put("check", true)
                    .put("game_id", game_id);
            return result.toString();
        }else{
            JSONObject result = new JSONObject()
                    .put("check", false)
                    .put("game_id", -1);
            return result.toString();
        }
    }





}