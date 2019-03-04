package Jotto.controller;
import Jotto.domain.Account;
import Jotto.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


import java.util.List;


@Controller
@RequestMapping(value="/index.html")
public class ajaxAccountController {
    private AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String processRegisterRequest(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String response = "";
        boolean exist = this.doesUserExisit(username);
        if(exist == false){
            accountService.addAccount(new Account(username,password));
            response = "success";
        }
        else{
            response = "fail";
        }
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String validateLoginMethod(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean valid = this.validLogin(username,password);
        if (valid == true){
            return "sucess";
        }
        return "fail";
    }

    public boolean doesUserExisit(String username){
        List<Account>allAccounts = accountService.getAllAccounts();
        for(Account acc: allAccounts){
            if (acc.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean validLogin(String username, String password){
        List<Account>allAccounts = accountService.getAllAccounts();
        for(Account acc: allAccounts){
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
