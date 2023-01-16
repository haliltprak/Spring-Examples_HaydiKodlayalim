package com.haydikodlayalim.controller;

import com.haydikodlayalim.entity.Kullanici;
import com.haydikodlayalim.repository.KullaniciRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    @PostConstruct // bu metodu eklemek zorunda degiliz.
    public void init(){
        Kullanici kullanici = new Kullanici()  ;
        kullanici.setAdi("Haydi");
        kullanici.setSoyadi("Kodlayalim");
        kullaniciRepository.save(kullanici);
    }

    @Autowired
    private KullaniciRepository kullaniciRepository; // suan icin service katmanina gerek yok.

    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici)); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele(){
        return ResponseEntity.ok(kullaniciRepository.findAll()); //responseEntity zorunlu degil ama duzenli gozukmesi icin ekledik.
    }

}
