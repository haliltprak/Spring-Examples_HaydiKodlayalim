package com.haydikodlayalim.services;

import com.haydikodlayalim.dto.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KisiService {

   // kendi entitylerimizi disari acmak dogru olmadigi icin Dto classlarini kullaniyoruz.
    KisiDto save(KisiDto kisiDto);

    void delete(Long id);

    List<KisiDto> getAll();

    Page<KisiDto> getAll(Pageable pageable);
}
