package com.haydikodlayalim.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@ApiModel(value = "Benim Pet nesnem",description = "Benim Pet") // swaggerdan geliyor
public class Pet {

    @ApiModelProperty(value = "Pet nesnesinin tekil id alani") //bir modelin propertysini tanimliyoruz boylelikle dokumantasyonunu olusur.
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin Adi alani")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin Tarih alani")
    private Date date;

    public  Pet(int id,String name,Date date){
        this.id=id;
        this.name=name;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
