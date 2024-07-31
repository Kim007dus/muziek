package nl.kimraven.muziek.infrastructure.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import nl.kimraven.muziek.entities.dto.ConcertResponse;
import nl.kimraven.muziek.usecases.concerts.AddConcertUsecase;


/**
 * 
 */
@Tag(name = "Concerts")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/concerts")
public class AddConcertController {
    
    //
    private final AddConcertUsecase usecase;

    /**
     * 
     * @return
     */
    @PostMapping()
    @Operation(summary = "Add a concert")
    public ConcertResponse execute(String artistName, LocalDate date, String concertLocation) {
        return usecase.execute(artistName, date, concertLocation);  
        
    }
}
