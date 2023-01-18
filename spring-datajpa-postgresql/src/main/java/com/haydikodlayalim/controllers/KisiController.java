package com.haydikodlayalim.controllers;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.services.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {


    private final KisiService kisiService;

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(kisiService.save(kisiDto)); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }

    @GetMapping
    public ResponseEntity<List<KisiDto>> tumunuListele(){
        return ResponseEntity.ok(kisiService.getAll()); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }
}
