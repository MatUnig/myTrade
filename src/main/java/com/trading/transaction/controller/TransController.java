package com.trading.transaction.controller;

import com.trading.registration.dao.UserDao;
import com.trading.registration.model.Login;
import com.trading.registration.model.User;
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
import java.io.IOException;

@Controller
public class TransController {
    @Autowired
    public TransService transService;

    @RequestMapping(value = "/pickProduct", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("transaction") Transaction transaction) throws IOException {
        ModelAndView mav = new ModelAndView("product");
        String option = request.getParameter("products");
        if (option.equals("usdpln")) {
            mav.addObject("product", "USD/PLN");
            mav.addObject("price", Function.doubleApiParser(
                    "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=PLN&apikey=OXP7JS2TSKX8B130",
                    "5. Exchange Rate"));
        }
        else if (option.equals("btc")) {
            mav.addObject("product", "Bitcoin");
            mav.addObject("price", Function.doubleApiParser(
                    "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=BTC&to_currency=USD&apikey=OXP7JS2TSKX8B130",
                    "5. Exchange Rate"));
        }
        else if (option.equals("eurusd")) {
            mav.addObject("product", "EUR/USD");
            mav.addObject("price", Function.doubleApiParser(
                    "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=EUR&to_currency=USD&apikey=OXP7JS2TSKX8B130",
                    "5. Exchange Rate"));
        }
        return mav;

    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mav = new ModelAndView("product");
        String option = request.getParameter("products");
        if (option.equals("usdpln")) {
            mav.addObject("product", "USD/PLN");
            mav.addObject("price", Function.doubleApiParser(
                    "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=PLN&apikey=OXP7JS2TSKX8B130",
                    "5. Exchange Rate"));
        }
        return mav;

    }
    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    @ResponseBody
    public String buyProduct(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("transaction") Transaction transaction) throws IOException {
        transService.buy(transaction, request);
        return transService.toString() + "Gratuluje zakupu";

    }
}

