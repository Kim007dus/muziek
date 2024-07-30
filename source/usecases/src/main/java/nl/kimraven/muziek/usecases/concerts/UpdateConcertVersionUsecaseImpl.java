package nl.kimraven.muziek.usecases.concerts;

import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.ConcertVersion;
import nl.kimraven.muziek.entities.exception.ConcertNotFoundException;
import nl.kimraven.muziek.entities.gateway.MusicGateway;

/**
 * 
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UpdateConcertVersionUsecaseImpl implements UpdateConcertVersionUsecase {
    //
    private final MusicGateway gateway;

    /**
    * 
    */
    @Override
    public Concert execute(@NotBlank String id, ConcertVersion newVersion) {
        Concert concert = gateway.findConcertById(id).orElseThrow(ConcertNotFoundException::new);

        log.info("Found concert: {}", concert);

        ConcertVersion currentVersion = concert.getCurrent();
        newVersion.setVersion(currentVersion.getVersion() + 1);
        newVersion.setStatus(currentVersion.getStatus());
        newVersion.setArtistName(currentVersion.getArtistName());
        newVersion.setConcertLocation(currentVersion.getConcertLocation());
        newVersion.setDate(currentVersion.getDate());

        log.info("New version after setting fields: {}", newVersion);
         

        concert.getHistory().add(currentVersion);
        concert.setCurrent(newVersion);

        log.info("Updated concert before saving: {}", concert);

        return gateway.updateConcert(id, concert).orElseThrow(ConcertNotFoundException::new);

       

    

    }
   

        

    
}
