package nl.kimraven.muziek.entities.dto;

import java.time.LocalDate;

import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Status;

public record PreviousVersionResponse(
        String id,
        Long version,
        String artistName,
        String concertLocation,
        LocalDate date,
        Status status

) {
    public PreviousVersionResponse(Concert concert) {
        this(
                concert.getId(),                
                concert.getHistory().getLast().getVersion(),
                concert.getHistory().getLast().getArtistName(),
                concert.getHistory().getLast().getConcertLocation(),
                concert.getHistory().getLast().getDate(),
                concert.getHistory().getLast().getStatus()
                );
    }
} 
    

