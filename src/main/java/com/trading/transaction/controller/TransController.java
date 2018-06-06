package com.trading.transaction.controller;

import com.trading.registration.dao.UserDao;
import com.trading.registration.model.Login;
import com.trading.registration.model.User;
import com.trading.registration.service.UserService;
import com.trading.transaction.dao.TransDao;
import com.trading.transaction.dao.TransactionDao;
import com.trading.transaction.functions.Function;
import com.trading.transaction.model.Transaction;
import com.trading.transaction.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class TransController {
//    @Autowired
//    public TransService transService;
//    @Autowired
//    public UserService userService;

    private final TransService transService;

    public TransController(TransService transService) {
        this.transService = transService;
    }

//    private final TransactionDao transactionDao;
//
//    public TransController(TransactionDao transactionDao) {
//        this.transactionDao = transactionDao;
//    }

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
    public ModelAndView showTrans(HttpServletRequest request, Model model) throws IOException {
        List<Transaction> trans = transService.getTrans(request);
        ModelAndView mav = new ModelAndView("transactions");
        double profitSum=0;
        for (Transaction t : trans){
            Function.setCurrentPrice(t);
            Function.setProfit(t);
            profitSum+=t.getProfit();
        }
        model.addAttribute("trans",trans);
        HttpSession sess = request.getSession();
        User currentUser = (User)sess.getAttribute("user");
        currentUser.setBalance(currentUser.getBalance() + profitSum);
        userService.applyChanges(currentUser);
        return mav;
    }
    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public String closeTrans(HttpServletRequest request) throws IOException {
        int id = Integer.parseInt(request.getParameter("close"));
        System.out.println(id);
        Transaction trans = transService.findById(id);
        System.out.println(trans.getPrice());
        trans.setStatus("Closed");
        transactionDao.updateTrans(trans);
        return "redirect:/showTrans";
    }
    @RequestMapping(value = "/try", method = RequestMethod.GET)
    @ResponseBody
    public String close(){
        Transaction trans = transService.findById(2);
        trans.setStatus("czesc");
        transactionDao.updateTrans(trans);
        return "zmieniono";
    }
    //    @RequestMapping(value = "/try", method = RequestMethod.GET)
//    @ResponseBody
//    public String close(){
//        Transaction trans = transService.findById(2);
//        trans.setStatus("czesc");
//        transactionDao.updateTrans(trans);
//        return "zmieniono";
//    }
    //@ModelAttribute("someReference")
    //public List<Transaction>(){
    // metoda ta bedzie dostepna dla wszystkich kontrolerow

}

