package nl.kimraven.muziek.usecases.concerts;

import java.util.List;

import nl.kimraven.muziek.entities.dto.ConcertResponse;

/**
 * 
 */
public interface FetchConcertsUsecase {

    public List<ConcertResponse> execute();
    
}
