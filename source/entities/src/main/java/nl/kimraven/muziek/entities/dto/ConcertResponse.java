package nl.kimraven.muziek.entities.dto;

import java.time.LocalDate;

import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Status;

/**
 * 
 */
public record ConcertResponse(
        String id,
        Long version,
        String artistName,
        String concertLocation,
        LocalDate date,
        Status status) {

    public ConcertResponse(Concert concert) {
        this(
                concert.getId(),
                concert.getVersion(),
                concert.getArtistName(),
                concert.getConcertLocation(),
                concert.getDate(),                
                concert.getStatus());
    }
}
