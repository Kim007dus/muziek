package nl.kimraven.muziek.entities.dto;

import java.time.LocalDate;

import java.util.List;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.ConcertVersion;
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
        Status status,
        List<ConcertVersion> history
        ) {

    public ConcertResponse(Concert concert) {
        this(
                concert.getId(),                
                concert.getCurrent().getVersion(),
                concert.getCurrent().getArtistName(),
                concert.getCurrent().getConcertLocation(),
                concert.getCurrent().getDate(),                
                concert.getCurrent().getStatus(),
                concert.getHistory()
                );
    }
}
