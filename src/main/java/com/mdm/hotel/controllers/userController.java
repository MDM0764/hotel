package com.mdm.hotel.controllers;

import com.mdm.hotel.entities.user;
import com.mdm.hotel.repos.userRepository;
import com.mdm.hotel.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

@Controller
public class userController {

    @Autowired
    private userRepository repo;

    @Autowired
    private userService service;

    @RequestMapping("/register")
    public String showReg() {
        return "register";
    }

    @RequestMapping(value = "registerUser", method= RequestMethod.POST)
     public String register(@ModelAttribute("user") user regUser, ModelMap modelMap) {
       String[] password = regUser.getPassword().split(",");
       if (!password[0].equals(password[password.length -1])) {
           modelMap.addAttribute("msg", "passswords don't match");
           return "user";
       } else {
           regUser.setPassword(password[password.length-1]);
       }
            try {
                service.register(regUser);
            } catch ( UsernameNotFoundException e) {
                modelMap.addAttribute("msg", "User Already Exists");
                return "register";
            } catch (Exception e) {
                modelMap.addAttribute("msg", ""+ e.getMessage());
                return "register";
            }
            return "login";
     }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

     @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login (@RequestParam("userId") String userId, @RequestParam("password") String password, ModelMap modelMap){
         user user;
        if (isValid(userId)) {//find by email
            user = repo.findByEmail(userId);
         } else {
            Long phoneNo = Long.parseLong(userId);
            user = repo.findByPhoneno(phoneNo);
         }
         if (user == null) {
             modelMap.addAttribute("msg", "user does not exist, please register");
             return "login";
         }
        if (service.checkPassword(password, user.getPassword())) {
            modelMap.addAttribute("userCode", user.getId());
            return "user/home";
        } else {
            modelMap.addAttribute("msg", "passswords don't match");
            return "login";
        }

     }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}
