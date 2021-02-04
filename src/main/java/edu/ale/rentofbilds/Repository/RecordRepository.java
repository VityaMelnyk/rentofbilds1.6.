package edu.ale.rentofbilds.Repository;

import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {


}
