package com.customer.customer_details.Controller;

import com.customer.customer_details.Model.User;
import com.customer.customer_details.Repository.UserRepo;
import com.customer.customer_details.helper.Message;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HomeController {

       @Autowired
       UserRepo userRepo;

       @Autowired
       BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title","Home-Customer Add");
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Register-Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/register")
    public String register( @ModelAttribute("user") User user, Model model, HttpSession session){
        try{
            user.setRole("ROLE_Public");
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            User result=this.userRepo.save(user);
            System.out.println("USER"+user);
            model.addAttribute("user",new User());
            session.setAttribute("message",new Message("User added success",
                    "alert-success"));
           // session.removeAttribute("message");
            return "signup";
        }catch (Exception e){
           e.printStackTrace();
           model.addAttribute("user",user);

           session.setAttribute("message",new Message("Something Went Wrong"+e.getMessage()
                   ,"alert-danger"));
           // session.removeAttribute("message");
           return "signup";
        }

    }
    



    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Login-Smart Contact Manager");
        return "login";
    }

//    @RequestMapping("/logout")
//    public String logout(){
//        return "logout";
//    }



}
