package nl.kimraven.muziek.infrastructure.datasource;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import nl.kimraven.muziek.infrastructure.schema.ConcertSchema;





/**
 * 
 */
public interface ConcertRepository extends MongoRepository<ConcertSchema, String> {

    @Query("{ 'artistName' : ?0 }")
    List<ConcertSchema> findAllConcerts();


    

   
    
    

    
}
