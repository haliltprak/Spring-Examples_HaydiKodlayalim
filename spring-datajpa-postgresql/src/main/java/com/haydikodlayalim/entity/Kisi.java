package com.haydikodlayalim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // iki adres nesnesinin id'si ayni ise bu iki nesne birbirine esittir yani iki nesne ayni nesnedir
@ToString
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1) // postgresql veritabani kullandigimiz icin generator kullandik. Mysql de bunu yapmamiza gerek yok
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 100,name = "adi")
    private String adi;

    @Column(length = 100,name = "soyadi")
    private String soyadi;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresleri;

}
