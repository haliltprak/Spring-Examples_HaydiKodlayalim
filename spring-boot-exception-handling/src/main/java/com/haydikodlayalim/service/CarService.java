package com.haydikodlayalim.service;

import com.haydikodlayalim.dto.Car;
import com.haydikodlayalim.exception.EntityNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CarService {
    private List<Car> carList = new ArrayList<>();

    @PostConstruct
    public void init(){
        carList.add(new Car("Car A","Brand 1"));
        carList.add(new Car("Car B","Brand 2"));
        carList.add(new Car("Car C","Brand 3"));
    }

    public Car getCar(String name) {
        if(name.toUpperCase().startsWith("A")){ // farkli bir exception icin boyle bir sey yazdik. Simdilik mantikli olmasina gerek yok.
            throw new IllegalArgumentException();
        }
        return  carList.stream().
                filter(item -> item.getName().equals(name)).
                findFirst().
                orElseThrow(()-> new EntityNotFoundException(name));
    }
}
