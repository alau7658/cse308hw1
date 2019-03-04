package Jotto.controller;

import Jotto.domain.Game;
import Jotto.domain.Round;
import Jotto.services.GameService;
import Jotto.services.RoundService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping(value="/detail.html")
public class ajaxDetailsController {
    private GameService gameService;
    private RoundService roundService;
    @Autowired
    public void setRoundService(RoundService roundService) {
        this.roundService = roundService;
    }
    @Autowired
    public void setGameService(GameService gService) {
        this.gameService = gService;
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    @ResponseBody
    public String getDetails(HttpServletRequest request) {
        String gameID = request.getParameter("gameID");
        return getMatchDetails(Integer.parseInt(gameID)).toString();
    }

    public JSONObject getMatchDetails(Integer gameID) {
        Game game = gameService.getGameById(gameID);
        String user_word = game.getUser_word();
        String cpu_word = game.getCpu_word();
        List<Round> rounds = roundService.getMatchDetails(gameID);
        List<List<Character>> userLetters = new ArrayList();
        List<List<Character>> cpuLetters = new ArrayList();
        List<Integer> userCorrectCounter = new ArrayList<Integer>();
        List<Integer> cpuCorrectCounter = new ArrayList<Integer>();
        for(Round a:rounds){

            List<Character> userCorrectLetters = new ArrayList<Character>();
            List<Character> cpuCorrectLetters = new ArrayList<Character>();
            int userCounter = 0;
            int cpuCounter = 0;
            String cpu_guess = a.getCpu_guess();
            String user_guess = a.getUser_guess();

            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if (cpu_guess.charAt(i) == user_word.charAt(j)) {
                        cpuCounter++;
                        cpuCorrectLetters.add(cpu_guess.charAt(i));
                        break;
                    }
                }
            }

            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if (user_guess.charAt(i) == cpu_word.charAt(j)) {
                        userCounter++;
                        userCorrectLetters.add(user_guess.charAt(i));
                        break;
                    }
                }
            }

            userLetters.add(userCorrectLetters);
            cpuLetters.add(cpuCorrectLetters);
            cpuCorrectCounter.add(cpuCounter);
            userCorrectCounter.add(userCounter);
        }
        JSONObject result = new JSONObject();
        result.put("length",rounds.size());
        result.put("dateCreated",game.getDate_created());
        result.put("gameState",game.getGame_state());
        result.put("matchID",gameID);
        result.put("matchDetails",rounds);
        result.put("userLetter",userLetters);
        result.put("cpuLetters",cpuLetters);
        result.put("cpuCorrectCounter",cpuCorrectCounter);
        result.put("userCorrectCounter",userCorrectCounter);
        result.put("user_word",user_word);
        result.put("cpu_word",cpu_word);
        return result;
    }
}
