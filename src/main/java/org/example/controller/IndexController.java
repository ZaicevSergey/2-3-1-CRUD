package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.model.User;
import org.example.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {
    boolean check = true;

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String redirect() {


        if (check == true) {
            userService.deleteTable();
            userService.createOrUpdateUser(new User("Зайцев", "Сергей", "sszaicev@gmail.com"));
            userService.createOrUpdateUser(new User("Медвеженко", "Андрей", "med_andrey@gmail.com"));
            userService.createOrUpdateUser(new User("Казаревская", "Виктория", "vik@gmail.com"));
            check = false;
        }
        return "redirect:/users";
    }
}
