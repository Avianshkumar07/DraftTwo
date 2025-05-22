package com.DraftTwoCRUD.DraftTwo.Service;

import com.DraftTwoCRUD.DraftTwo.dto.fruitDto;

import java.util.List;

public interface fruitService {

    fruitDto createFruit (fruitDto fruitdto);
    fruitDto getFruitById(Long id);
    List<fruitDto> getAllFruits();
    fruitDto updateFruit(long id, fruitDto fruitDto);
    void deleteFruit(long id);

}
