package com.haydikodlayalim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="kisi_adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // iki adres nesnesinin id'si ayni ise bu iki nesne birbirine esittir yani iki nesne ayni nesnedir
@ToString
public class Adres implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1) // postgresql veritabani kullandigimiz icin generator kullandik. Mysql de bunu yapmamiza gerek yok
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500,name = "adres")
    private String adres;
    @Enumerated
    private AdresTip adresTip;
    @Column(name = "aktif")
    private Boolean aktif;

    @ManyToOne()
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    enum AdresTip{
        EV_ADRESI,
        IS_ADRES,
        DIGER
    }
}
