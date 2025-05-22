package com.DraftTwoCRUD.DraftTwo.Repository;

import com.DraftTwoCRUD.DraftTwo.Model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface fruitRepo extends JpaRepository<Fruit, Long> {
}
