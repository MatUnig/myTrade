package com.trading.transaction.controller;

import com.trading.registration.dao.UserDao;
import com.trading.registration.model.Login;
import com.trading.registration.model.User;
import com.trading.registration.service.UserService;
import com.trading.transaction.dao.TransDao;
import com.trading.transaction.functions.Function;
import com.trading.transaction.model.Transaction;
import com.trading.transaction.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class TransController {
    @Autowired
    public TransService transService;
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/pickProduct", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("transaction") Transaction transaction) throws IOException {
        ModelAndView mav = new ModelAndView("product");
        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");
        String product = Function.parseNames(fromCurrency, toCurrency);
        double price = Function.parsePrice(fromCurrency, toCurrency);
        mav.addObject("fromCurrency", fromCurrency);
        mav.addObject("toCurrency", toCurrency);
        mav.addObject("product", product);
        mav.addObject("price", price);
        return mav;
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    @ResponseBody
    public String buyProduct(HttpServletRequest request, HttpServletResponse response,
                             @ModelAttribute("transaction") Transaction transaction) throws IOException {
        transService.buy(transaction, request);
        return "Gratuluje zakupu" + transaction.getProduct();
    }

    @RequestMapping(value = "/showTrans", method = RequestMethod.GET)
    @ResponseBody
    public List<Transaction> showTrans(HttpServletRequest request) throws IOException {
        List<Transaction> trans = transService.getTrans(request);
        double profitSum=0;
        for (Transaction t : trans){
            Function.setCurrentPrice(t);
            Function.setProfit(t);
            profitSum+=t.getProfit();
        }
        HttpSession sess = request.getSession();
        User currentUser = (User)sess.getAttribute("user");
        currentUser.setBalance(currentUser.getBalance() + profitSum);
        userService.applyChanges(currentUser);
        return trans;
    }
    //@ModelAttribute("someReference")
    //public List<Transaction>(){
    // metoda ta bedzie dostepna dla wszystkich kontrolerow

}

