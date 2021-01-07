package com.mimi.FoodDelivery.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlerController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<?> error(){
        return  ResponseEntity.badRequest().body("Въвели сте грешен адрес");
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
