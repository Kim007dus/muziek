package nl.kimraven.muziek.infrastructure.datasource;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import nl.kimraven.muziek.infrastructure.schema.FestivalSchema;

/**
 * 
 */
public interface FestivalRepository extends MongoRepository<FestivalSchema, String> {

    @Query("{ 'festivalName' : ?0 }")
    List<FestivalSchema> findAllFestivals();


    
}