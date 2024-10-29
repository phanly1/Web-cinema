//package com.team12.fantafilm.controller.user;
//
//import com.team12.fantafilm.model.User;
//import com.team12.fantafilm.service.impl.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/login")
//
//public class LoginController {
//    @GetMapping
//    public String login(){
//        return "user/login";
//    }
//
//
////    @PostMapping("/login")
////    public String login(
////            @RequestParam(name = "email") String email,
////            @RequestParam(name = "password") String password,
////            HttpServletRequest request, Model model
////    ) {
////
////        User user = UserService.findByEmail(email);
////        HttpSession sessionLogin = request.getSession();
////
////        if (user == null || !user.getPassWord().equals(password)) {
////            sessionLogin.setAttribute("ERR_LOGIN", "Sai tên tài khoản hoặc mật khẩu");
////            return "user/login";
////        } else {
////            sessionLogin.setAttribute("user", user);
////            return "/";
////        }
////    }
////
////    @GetMapping("/logout")
////    public String logout(HttpServletRequest request) {
////        HttpSession session = request.getSession();
////        session.setAttribute("customer", null);
////        return "user/home";
////    }
//
//
//
//}
