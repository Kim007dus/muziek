package nl.kimraven.muziek.usecases.concerts;

import java.time.LocalDate;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Status;
import nl.kimraven.muziek.entities.dto.ConcertResponse;
import nl.kimraven.muziek.entities.exception.AddConcertException;
import nl.kimraven.muziek.entities.exception.ConcertNotFoundException;
import nl.kimraven.muziek.entities.exception.StatusCancelledException;
import nl.kimraven.muziek.entities.gateway.MusicGateway;

/**
 * 
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ChangeStatusConcertUsecaseImpl implements ChangeStatusConcertUsecase {
    //
    private final MusicGateway gateway;


    /**
     * 
     * @param status
     * @return
     */
    @Override
    public ConcertResponse execute(String id) {
        

        // als de datum van het concert in het verleden ligt, dan moet de status naar status.SEEN
        // als de datum van het concert in de toekomst ligt, dan moet de status naar status.UPCOMING
        // als de datum van het concert vandaag is, dan moet de status naar status.NOW
        // als de status van het concert DRAFT is, dan moet de status afhankelijk van de datum naar status.UPCOMING of status.NOW of status.SEEN
        // als de status van het concert CANCELLED is, dan mag de status niet veranderd worden
        var concert = gateway.findConcertById(id).orElseThrow(ConcertNotFoundException::new);
               

        if (concert.getStatus() == Status.CANCELLED) {
            throw new StatusCancelledException();
        }       
        
        LocalDate currentDate = LocalDate.now();
        Status newStatus;
        
        if (concert.getDate().isEqual(currentDate)) {
            newStatus = Status.NOW;
        } else if (concert.getDate().isBefore(currentDate)) {
            newStatus = Status.SEEN;
        } else {
            newStatus = Status.UPCOMING;
        }
        
        log.info("Changing status of concert: {} to {}", concert.getStatus(), newStatus);
        concert.setStatus(newStatus);
        

        return gateway.saveConcert(concert).map(ConcertResponse::new).orElseThrow(AddConcertException::new);
        
}
}


