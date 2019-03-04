package Jotto.controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Jotto.services.GameService;
import Jotto.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/history.html")
public class ajaxHistoryController {
    private GameService gameService;
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }


    @RequestMapping(value = "/show", method = RequestMethod.POST)
    @ResponseBody
    public String getMatchHistory(HttpServletRequest request) {
        String username = request.getParameter("username");
        List<Game> matchHistory = gameService.getMatchHistory(username);
        Gson gson = new GsonBuilder().create();
        String jsonObject = gson.toJson(matchHistory);
        return jsonObject;
    }


}
