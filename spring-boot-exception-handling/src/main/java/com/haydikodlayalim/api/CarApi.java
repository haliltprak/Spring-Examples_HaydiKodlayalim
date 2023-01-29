package com.haydikodlayalim.api;

import com.haydikodlayalim.dto.Car;
import com.haydikodlayalim.exception.EntityNotFoundException;
import com.haydikodlayalim.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name){
        return ResponseEntity.ok(carService.getCar(name));
    }

    // localde exception handling islemi
    // global icin ApiExceptionHandler sinifina bakin
    /*@ExceptionHandler({EntityNotFoundException.class}) // EntityNotFound classi hatasi alindiginda bu metod calisacak
    public String entityNotFound(){
        return "Kayit bulunamadi";
    }*/

}
