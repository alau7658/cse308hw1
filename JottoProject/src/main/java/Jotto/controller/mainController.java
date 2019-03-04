package Jotto.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class mainController {
    @RequestMapping(value={"/","index.html"})
    String index(){
        return "index";
    }

    @RequestMapping(value={"home.html"})
    String home(){
        return  "home";
    }

    @RequestMapping(value={"detail.html"})
    String detail(){
        return "detail";
    }

    @RequestMapping(value={"game.html"})
    String game(){
        return "game";
    }

    @RequestMapping(value={"history.html"})
    String history(){
        return "history";
    }

    @RequestMapping(value={"newgame.html"})
    String newgame(){
        return "newgame";
    }



}
