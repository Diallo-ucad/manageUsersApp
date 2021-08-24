package com.technicaltest.manageusersacountapp.controller;

import com.technicaltest.manageusersacountapp.entity.User;
import com.technicaltest.manageusersacountapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<User> getAllUserById(@PathVariable int id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(user.getBirthdate());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate birthdate = LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthdate, now);
        if(age<18){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }
}
