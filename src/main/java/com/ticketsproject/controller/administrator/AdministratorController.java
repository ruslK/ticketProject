package com.ticketsproject.controller.administrator;

import com.ticketsproject.bootstrap.DataGenerator;
import com.ticketsproject.dto.RoleDTO;
import com.ticketsproject.dto.UserDTO;
import com.ticketsproject.entities.Role;
import com.ticketsproject.servises.RoleService;
import com.ticketsproject.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Component
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    RoleService roleService;
    UserService userService;

    public AdministratorController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("allUsers", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "administrator/createUser";
    }

    @PostMapping("/users")
    public String postUsers(@ModelAttribute("newUser") UserDTO newUser, Model model) {
        userService.save(newUser);
        model.addAttribute("newUser", new UserDTO());
        model.addAttribute("allUsers", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "administrator/createUser";
    }

    @GetMapping("/users/{id}")
    public String updateUser(@PathVariable("id") String id, Model model) {
        model.addAttribute("newUser", userService.findById(id));
        model.addAttribute("allUsers", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "administrator/createUser";
    }

    @GetMapping("/projects")
    public String getCreateProjectsPage() {
        return "administrator/createProject";
    }

}
