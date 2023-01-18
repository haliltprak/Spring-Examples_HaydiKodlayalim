package com.haydikodlayalim.dto;

import com.haydikodlayalim.entity.Adres;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// kendi entitylerimizi disari acmak dogru olmadigi icin Dto classlarini kullaniyoruz.
@Data
public class KisiDto {

    private Long id;

    private String adi;

    private String soyadi;


    private List<String> adresleri;
}
