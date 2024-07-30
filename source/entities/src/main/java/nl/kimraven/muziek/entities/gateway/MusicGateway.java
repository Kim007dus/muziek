package nl.kimraven.muziek.entities.gateway;

import java.util.List;
import java.util.Optional;

import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Festival;


/**
 * 
 */	
public interface MusicGateway  {
    
    List<Concert> findAllConcerts();
    Optional<Concert> findConcertById(String id);
    Optional<Concert> findConcertByArtist(String artistName);
      
    List<Festival> findAllFestivals();
    Optional<Festival> findFestivalById(String id);
    Optional<Festival> findFestivalByName(String festivalName);
    
    Optional<Concert> saveConcert(Concert concert);
    Optional<Concert> updateConcert(String id, Concert concert);
    Optional<Festival> saveFestival(Festival festival);

    void deleteConcert(Concert concert);
    void deleteFestival(Festival festival);


    
}
