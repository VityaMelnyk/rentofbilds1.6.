package edu.ale.rentofbilds.Repository;

import edu.ale.rentofbilds.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    //делаем метод которы будет возращать нам даные!

    List<Item> findByNameAndDescription(String name, String desctription);

    //List<Item> findByCreated_atBetween(LocalDateTime start, LocalDateTime finish);

   List<Item> findByNameContaining(String str);

}
