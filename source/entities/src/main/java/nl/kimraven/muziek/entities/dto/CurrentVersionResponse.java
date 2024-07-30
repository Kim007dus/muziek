package nl.kimraven.muziek.entities.dto;

import java.time.LocalDate;

import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Status;

/**
 * 
 */
public record CurrentVersionResponse(
        String id,
        Long version,
        String artistName,
        String concertLocation,
        LocalDate date,
        Status status
) {
    public CurrentVersionResponse(Concert concert) {
        this(
                concert.getId(),                
                concert.getCurrent().getVersion(),
                concert.getCurrent().getArtistName(),
                concert.getCurrent().getConcertLocation(),
                concert.getCurrent().getDate(),                
                concert.getCurrent().getStatus()                
                );
    }


    
}
