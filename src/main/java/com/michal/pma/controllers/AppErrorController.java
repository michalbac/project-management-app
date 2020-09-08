package com.michal.pma.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest){
        Object status = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "errorpages/error_404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return "errorpages/error_500";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()){
                return "errorpages/error_403";
            }
        }
        return"errorpages/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
