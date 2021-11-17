package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value="/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listUser(Model model) {
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

//    @GetMapping("/user/update/{noUser}")
//    public String updateUserForm(@PathVariable Long noUser, Model model) {
//        UserModel user = userService.getUserByNoUser(noUser);
//        model.addAttribute("user", user);
//        return "form-update-user";
//    }
//
//    @PostMapping("/user/update")
//    public String updateUserSubmit(@ModelAttribute UserModel user, Model model) {
//        if (user.getListFilm() == null) {
//            user.setListFilm(new ArrayList<>());
//        }
//        userService.updateUser(user);
//        model.addAttribute("noUser", user.getNoUser());
//        return "update-user";
//    }

    @GetMapping("/delete/{noUser}")
    public String deleteUser(@PathVariable Long noUser, Model model) {
        UserModel user = userService.getUserByNoUser(noUser);
        userService.deleteUser(user);
        model.addAttribute("user", user);
        return "delete-user";
    }
}