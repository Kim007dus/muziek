package nl.kimraven.muziek.usecases.concerts;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.dto.PreviousVersionResponse;
import nl.kimraven.muziek.entities.exception.ConcertNotFoundException;
import nl.kimraven.muziek.entities.gateway.MusicGateway;

/**
 * 
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class GetPreviousVersionUsecaseImpl implements GetPreviousVersionUsecase {
    
    //
    private final MusicGateway gateway;

    /**
     * 
     * @param gateway
     */
    @Override
    public PreviousVersionResponse execute(String id) {
        //
        log.info("Fetching concert with id: {}", id);
        
        Concert concert = gateway.findConcertById(id).orElseThrow(ConcertNotFoundException::new);

        return new PreviousVersionResponse(concert);
             
    }
}
