package com.DraftTwoCRUD.DraftTwo.Mapper;

import com.DraftTwoCRUD.DraftTwo.Model.Fruit;
import com.DraftTwoCRUD.DraftTwo.dto.fruitDto;

public class fruitMapper {

    //This class converts entity object to Dto and vice versa

    //this class will convert fruit (entity) object to fruitdto

    public static fruitDto toDto(Fruit fruit){
        fruitDto dto = new fruitDto();
        dto.setId(fruit.getId());          //getId(),getName(); getPrice() --> these are getter method from fruit class
        dto.setName(fruit.getName());      //setId() , setName() , setPrice() --> are setter method from fruitDto class
        dto.setPrice(fruit.getPrice());

        return dto;
    }

    //this class will convert dto back into fruit (entity) object

    public static Fruit toEntity (fruitDto dto){

        Fruit fruit = new Fruit();

        fruit.setId(dto.getId());
        fruit.setName(dto.getName());
        fruit.setPrice(dto.getPrice());

        return fruit;
    }
}
