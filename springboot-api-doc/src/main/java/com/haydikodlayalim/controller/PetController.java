package com.haydikodlayalim.controller;

import com.haydikodlayalim.dto.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet API dokumantasyonum") // swaggerdan geliyor
public class PetController {
    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        System.out.println("eklendi");

    }

    @PostMapping
    @ApiOperation(value = "Yeni Pet Ekleme metodu", notes = "Bu metodu dikkatli kullan") //http metodunun dokumantasyonunu tanimlamak icin kullaniriz. swaggerdan geliyor.
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "hayvan") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }

    @GetMapping
    @ApiOperation(value = "Pet listesi metodu", notes = "Bu metod tumunu getirir")
    public ResponseEntity<List<Pet>> tumunuListele(){
        Pet npet =new Pet(1,"Test Pet",new Date());
        petList.add(npet);
        System.out.println(petList.get(0));
        return ResponseEntity.ok(petList); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }

}
