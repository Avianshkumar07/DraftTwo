package com.DraftTwoCRUD.DraftTwo.Service.ServiceImpl;

import com.DraftTwoCRUD.DraftTwo.Mapper.fruitMapper;
import com.DraftTwoCRUD.DraftTwo.Model.Fruit;
import com.DraftTwoCRUD.DraftTwo.Repository.fruitRepo;
import com.DraftTwoCRUD.DraftTwo.Service.fruitService;
import com.DraftTwoCRUD.DraftTwo.dto.fruitDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class fruitServiceImpl implements fruitService {

    private fruitRepo repository;  //it allows the below constructor to access the DB thru FruitRepository

    //create constructor and
    //this constructor will enable the spring to inject repository dependency nto your fruitServiceImpl
    //so that u can use to access the DB

    public fruitServiceImpl(fruitRepo repository){
        this.repository=repository;
    }

    @Override
    public fruitDto createFruit(fruitDto fruitdto) {
        Fruit fruit = fruitMapper.toEntity(fruitdto); //converting fruitDto object into fruit entity object using mapper class
                                                        //as repositories works with entity not dto

        return fruitMapper.toDto(repository.save(fruit)); //convert saved entity back to Dto
        //final return value is fruitDto, which spring will convert into JSON and send HTTP response
    }

    @Override
    public fruitDto getFruitById(Long id) {
        Fruit fruit = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));

        return fruitMapper.toDto(fruit);
    }

    @Override
    public List<fruitDto> getAllFruits() {
        return repository.findAll().stream()
                .map(fruitMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public fruitDto updateFruit(long id, fruitDto fruitDto) {
        Fruit fruit = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));

        return fruitMapper.toDto(fruit);
    }

    @Override
    public void deleteFruit(long id) {
        Fruit fruit =repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));

               repository.deleteById(id);

    }


}



