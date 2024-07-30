package nl.kimraven.muziek.infrastructure.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import nl.kimraven.muziek.entities.dto.ConcertResponse;
import nl.kimraven.muziek.usecases.concerts.ChangeStatusConcertUsecase;

/**
 * 
 */
@Tag(name = "2. Status")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts/status/{id}")
public class ChangeStatusController {

    //
    private final ChangeStatusConcertUsecase usecase;
    
     /**
     * 
     * @return
     */
    @PutMapping()
    @Operation(summary = "Change status of a concert")
    public ConcertResponse execute(String id) {
        return usecase.execute(id);
        
    }
}
