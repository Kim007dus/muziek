package nl.kimraven.muziek.usecases.concerts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.ConcertVersion;
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
     * @param concertLocation
     * @return
     */
    @Override
    public ConcertResponse execute(String artistName, LocalDate date, String concertLocation) {
        var concertInformation = new ConcertVersion();    
        concertInformation.setDate(date);        
        concertInformation.setConcertLocation(concertLocation);
        concertInformation.setArtistName(artistName);
        concertInformation.setStatus(Status.DRAFT);
        concertInformation.setVersion(1L);
              
        
        log.info("Adding concertInformation: {}", concertInformation);

        var concert = new Concert();
        concert.setId(generateId());
        concert.setCurrent(concertInformation);
        concert.setHistory(new ArrayList<>());

        log.info("Adding concert: {}", concert);

        return gateway.saveConcert(concert).map(ConcertResponse::new).orElseThrow(AddConcertException::new);
      
    }

    /** 
    * 
    */
    private String generateId() {
        return UUID.randomUUID().toString();
    }
    
   
}
