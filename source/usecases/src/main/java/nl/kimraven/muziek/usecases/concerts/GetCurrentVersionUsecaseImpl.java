package nl.kimraven.muziek.usecases.concerts;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.dto.CurrentVersionResponse;
import nl.kimraven.muziek.entities.exception.ConcertNotFoundException;
import nl.kimraven.muziek.entities.gateway.MusicGateway;

/**
 * 
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class GetCurrentVersionUsecaseImpl implements GetCurrentVersionUsecase {
       
    //
    private final MusicGateway gateway;

    /**
     * 
     * @param gateway
     */
    @Override
    public CurrentVersionResponse execute(String id) {
        //
        log.info("Fetching concert with id: {}", id);
        
        Concert concert = gateway.findConcertById(id).orElseThrow(ConcertNotFoundException::new);
        log.info("Show all concertinformation: {}", concert);

        return new CurrentVersionResponse(concert);
    }

    
}
