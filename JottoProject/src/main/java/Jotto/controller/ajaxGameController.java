package Jotto.controller;

import java.lang.*;
import Jotto.domain.Round;
import Jotto.domain.*;
import Jotto.algo.Algorithm;
import Jotto.services.GameService;
import Jotto.services.RoundService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import org.json.*;

@Controller
@RequestMapping(value="/game.html")
public class ajaxGameController {

    private RoundService roundService;
    private GameService gameService;

    @Autowired
    public void setRoundService(RoundService roundService) {
        this.roundService = roundService;
    }
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    @ResponseBody
    public String newWordCheck(HttpServletRequest request) {
        int numCheck = 0;
        String userGuess = request.getParameter("word");
        String game_id = request.getParameter("gameId");
        if(Algorithm.checkGuess(userGuess)){
            Algorithm.userRound(Algorithm.AIgiven,Algorithm.given,userGuess);

            int status = Algorithm.getStatus();
            String cpuGuess = Algorithm.guess.toLowerCase();
            if (cpuGuess!= null)
                numCheck = Algorithm.checkNum(Algorithm.given.toLowerCase(), cpuGuess.toLowerCase());
            int roundNumber = Algorithm.round;

            Round round = new Round();
            round.setRound_number(roundNumber);
            round.setCpu_guess(cpuGuess);
            round.setUser_guess(userGuess);
            round.setGame_id(Integer.parseInt(game_id));
            roundService.addRound(round);

            if (status == 1) {
                Game game  = gameService.getGameById(Integer.parseInt(game_id));
                game.setGame_state(GameState.WIN);
                gameService.saveGame(game);
            }
            if (status == 2) {
                Game game  = gameService.getGameById(Integer.parseInt(game_id));
                game.setGame_state(GameState.LOSE);
                gameService.saveGame(game);
            }



            JSONObject result = new JSONObject()
                    .put("check", true)
                    .put("status", Algorithm.getStatus())
                    .put("cpuGuess", cpuGuess)
                    .put("userCount", Algorithm.checkNum(Algorithm.AIgiven.toLowerCase(),userGuess.toLowerCase()))
                    .put("cpuCount", numCheck);
            return result.toString();
        }else{
            JSONObject result = new JSONObject()
                    .put("check", false)
                    .put("status", Algorithm.getStatus())
                    .put("cpuGuess", "")
                    .put("userCount", 0)
                    .put("cpuCount", 0);
            return result.toString();
        }
    }

}
