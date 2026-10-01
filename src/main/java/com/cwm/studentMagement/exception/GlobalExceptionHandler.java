package com.cwm.studentMagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfException;;

@ControllerAdvice 
public class GlobalExceptionHandler {

    private  static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(CsrfException.class)
    public String csrfExceptionHandler(CsrfException csr, RedirectAttributes redirectAttributes) {
        log.warn("CSRF validation failed" , csr.getMessage());
        redirectAttributes.addFlashAttribute("message", "Session expried");
        return "redirect:/login";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  String genericExceptionHandler(Exception csr) {
        log.error("CSRF validation failed" , csr.getMessage());
        return "500";
    }
}
