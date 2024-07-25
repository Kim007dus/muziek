package nl.kimraven.muziek.usecases.concerts;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.gateway.MusicGateway;
import nl.kimraven.muziek.entities.dto.ConcertResponse;


/**
 * 
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class FetchConcertsUsecaseImpl implements FetchConcertsUsecase {
    
    //
    private final MusicGateway gateway;

    /**
     * 
     * @return
     */
    @Override
    public List<ConcertResponse> execute() {
        
        //
        log.info("Fetching all concerts");
        
        return gateway.findAllConcerts().stream().map(ConcertResponse::new).toList();
    }
}
