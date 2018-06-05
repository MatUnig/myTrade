package com.trading.registration.controller;


import com.trading.currency.dao.CurrencyDao;
import com.trading.currency.model.Currency;
import com.trading.registration.model.Login;
import com.trading.registration.model.User;
import com.trading.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    CurrencyDao currencyDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        User user = userService.validateUser(login);
        if (null != user) {
            mav = new ModelAndView("welcome");
            HttpSession sess = request.getSession();
            sess.setAttribute("user",user);
            mav.addObject("firstname", user.getName());
            mav.addObject("balance",user.getBalance());
            mav.addObject("list", currencyDao.getAll());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or password is wrong.");
        }
        return mav;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sess = request.getSession();
        if (sess.getAttribute("user") == null){
            return "You are not logged in, please log in and try again";
        }
        User currentuser = (User) sess.getAttribute("user");
        request.getSession().invalidate();
        return "You have been logged out. Thank you for trading " + currentuser.getName() +".";
    }

}