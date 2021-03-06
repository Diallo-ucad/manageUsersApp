package com.technicaltest.manageusersacountapp.controller;

import com.technicaltest.manageusersacountapp.entity.User;
import com.technicaltest.manageusersacountapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getAllUserById(@PathVariable int id){

        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Invalid user id"+id);

        }
        return ResponseEntity.ok().body(userService.getUserById(id));
    }


    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user){

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(user.getBirthdate());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate birthdate = LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthdate, now);
        String country = user.getCountry();
        if(age<18 || !country.equalsIgnoreCase("France") ){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Sorry, only adult french resident are allowed to create an account!");
        }
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

}
