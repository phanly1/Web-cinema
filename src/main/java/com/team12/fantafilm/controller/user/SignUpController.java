//package com.team12.fantafilm.controller.user;
//
//import com.team12.fantafilm.model.User;
//import com.team12.fantafilm.service.IUserService;
//import com.team12.fantafilm.service.impl.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org. springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import javax.validation.Valid;
//@Controller
//@RequestMapping("/signup")
//public class SignUpController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public String signup(Model model){
//
//        User user = new User();
//        model.addAttribute("user", user);
//
//        return "user/signup";
//    }
//
//    @PostMapping("/signup/save")
//    public String registration(@Valid @ModelAttribute("user") User user,
//                              BindingResult bindingResult, String confirmPassWord
//                               ){
//        if(bindingResult.hasErrors()){
//            return "user/signup";
//        }
//
//        // kiem tra xac nhan mat khau
//        if(!user.getPassWord().equals(confirmPassWord)){
//            bindingResult.rejectValue("password","error.user","Xác nhận mật khẩu không khớp");
//            return "user/signup";
//        }
//
//        //kiem tra email da ton tai
//        if(userService.findByEmail(user.getEmail()) != null){
//            bindingResult.rejectValue("email","error.user","Email đã được đăng ký");
//            return "user/signup";
//        }
//        userService.save(user);
//        return "user/login";
//
//    }
//
//
//}
