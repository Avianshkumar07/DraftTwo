package com.DraftTwoCRUD.DraftTwo.Controller;

import com.DraftTwoCRUD.DraftTwo.Model.Fruit;
import com.DraftTwoCRUD.DraftTwo.Service.fruitService;
import com.DraftTwoCRUD.DraftTwo.dto.fruitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;


@RestController
@RequestMapping("/api/fruits")
public class fruitController {

    private fruitService fruitservice; 

    //create a constructor and inject fruitservice dependency into ur controller
    public fruitController(fruitService fruitservice){
        this.fruitservice = fruitservice;
    }

    //PostMapping
    @PostMapping
    public ResponseEntity<fruitDto> createFruit(@RequestBody fruitDto fruitDto){
        return ResponseEntity.ok(fruitservice.createFruit(fruitDto));
    }
    //GetMaping (get product by Id)
    @GetMapping("/{id}")
    public  ResponseEntity<fruitDto> getFruitById (@PathVariable long id ){
        return ResponseEntity.ok(fruitservice.getFruitById(id));
    }

    //GetMApping (get all products)

    @GetMapping
    public ResponseEntity <List<fruitDto>> getAllFruits (){

        return ResponseEntity.ok(fruitservice.getAllFruits());

    }

    @PutMapping("/{id}")
    public ResponseEntity<fruitDto> updateFruit(@PathVariable long id , @RequestBody fruitDto fruitdto){
        return ResponseEntity.ok(fruitservice.updateFruit(id, fruitdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable long id){
        fruitservice.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }


}
