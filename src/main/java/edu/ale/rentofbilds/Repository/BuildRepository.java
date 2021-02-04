package edu.ale.rentofbilds.Repository;

import edu.ale.rentofbilds.model.Build;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends MongoRepository<Build, String> {

}
