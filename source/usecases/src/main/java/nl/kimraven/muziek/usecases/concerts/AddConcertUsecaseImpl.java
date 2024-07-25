package nl.kimraven.muziek.usecases.concerts;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Status;
import nl.kimraven.muziek.entities.dto.ConcertResponse;
import nl.kimraven.muziek.entities.exception.AddConcertException;
import nl.kimraven.muziek.entities.gateway.MusicGateway;

/**
 * 
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AddConcertUsecaseImpl implements AddConcertUsecase {
    
    //
    private final MusicGateway gateway;

    /**
     * 
     * @param artistName
     * @param date
     * @param year
     * @param concertLocation
     * @return
     */
    @Override
    public ConcertResponse execute(String artistName, LocalDate date, String concertLocation) {
        
        var concert = new Concert();
        concert.setId(generateId());
        concert.setArtistName(artistName);
        concert.setDate(date);        
        concert.setConcertLocation(concertLocation);
        concert.setStatus(Status.DRAFT);

        log.info("Adding concert: {}", concert);

        return gateway.saveConcert(concert).map(ConcertResponse::new).orElseThrow(AddConcertException::new);
      
    }

    /** */
    private String generateId() {
        return UUID.randomUUID().toString();
    }
    
   
}
