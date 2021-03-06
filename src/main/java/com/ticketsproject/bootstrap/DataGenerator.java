package com.ticketsproject.bootstrap;

import com.ticketsproject.dto.ProjectDTO;
import com.ticketsproject.dto.RoleDTO;
import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.dto.UserDTO;
import com.ticketsproject.enums.Gender;
import com.ticketsproject.enums.Status;
import com.ticketsproject.servises.ProjectService;
import com.ticketsproject.servises.RoleService;
import com.ticketsproject.servises.TaskService;
import com.ticketsproject.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {


    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    TaskService taskService;

    @Autowired
    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new RoleDTO(1L, "Administrator"));
        roleService.save(new RoleDTO(2L, "Manager"));
        roleService.save(new RoleDTO(3L, "Employee"));

        UserDTO u1 = new UserDTO("Job", "Misha", "job@misha.com", "password", true, "234523452345", roleService.findById(1L), Gender.FEMALE);
        UserDTO u2 = new UserDTO("Tina", "Ivanko", "tina@gmail.com", "password", true, "4356435643564356", roleService.findById(2L), Gender.FEMALE);
        UserDTO u6 = new UserDTO("Coner", "White", "tina@gmail.com", "password", true, "4356435643564356", roleService.findById(2L), Gender.FEMALE);
        UserDTO u3 = new UserDTO("Steve", "Shapiro", "steve1@shapiro.com", "password", true, "4353454356", roleService.findById(3L), Gender.FEMALE);
        UserDTO u4 = new UserDTO("Ivanko", "Sveta", "steve2@shapiro.com", "password", true, "4353454356", roleService.findById(3L), Gender.FEMALE);
        UserDTO u5 = new UserDTO("Mariana", "Karson", "steve3@shapiro.com", "password", true, "4353454356", roleService.findById(3L), Gender.FEMALE);
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);
        userService.save(u5);
        userService.save(u6);

        ProjectDTO p1 = new ProjectDTO("Spring MVC", "PR001", u2, LocalDate.now(), LocalDate.now().plusDays(25), "Project 1", Status.COMPLETE);
        ProjectDTO p2 = new ProjectDTO("Spring MVC 2", "PR002", u2, LocalDate.now(), LocalDate.now().plusDays(35), "Project 2", Status.IN_PROGRESS);
        ProjectDTO p3 = new ProjectDTO("Spring MVC 3", "PR003", u6, LocalDate.now(), LocalDate.now().plusDays(45), "Project 3", Status.UAT_TEST);
        ProjectDTO p4 = new ProjectDTO("Spring MVC 4", "PR004", u6, LocalDate.now(), LocalDate.now().plusDays(45), "Project 3", Status.OPEN);
        ProjectDTO p5 = new ProjectDTO("Spring MVC 5", "PR005", u2, LocalDate.now(), LocalDate.now().plusDays(45), "Project 3", Status.OPEN);
        projectService.save(p1);
        projectService.save(p2);
        projectService.save(p3);
        projectService.save(p4);
        projectService.save(p5);


        TaskDTO t1 = new TaskDTO(p1, u4, "Update Title", "Soon as possible", LocalDate.now(), LocalDate.now(), Status.OPEN);
        TaskDTO t2 = new TaskDTO(p2, u5, "Update body", "Soon as possible", LocalDate.now(), LocalDate.now(), Status.UAT_TEST);
        TaskDTO t3 = new TaskDTO(p2, u3, "Automation Testing", "Soon as possible", LocalDate.now(), LocalDate.now(), Status.IN_PROGRESS);

        taskService.save(t1);
        taskService.save(t2);
        taskService.save(t3);
    }
}
