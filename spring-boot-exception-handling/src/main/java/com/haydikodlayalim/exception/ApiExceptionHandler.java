package com.haydikodlayalim.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// globalde exception handling islemi
// local islemi icin carapi sinifina bakin
@RestControllerAdvice // Aop bölümünden hatırlaman lazım. Burada advicelar vardi.
public class ApiExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class}) // EntityNotFound classi hatasi alindiginda bu metod calisacak
    public String entityNotFound(){
        return "Kayit bulunamadi";
    }

    @ExceptionHandler({IllegalArgumentException.class}) // EntityNotFound classi hatasi alindiginda bu metod calisacak
    public String illegalArgumentException(){
        return "Yanlis parametre girildi.";
    }

}
