package nl.kimraven.muziek.infrastructure.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
@Tag(name = "Status")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/concerts/{concert_id}/status")
public class ChangeStatusController {

    //
    private final ChangeStatusConcertUsecase usecase;
    
     /**
     * 
     * @return
     */
    @PutMapping()
    @Operation(summary = "Change status of a concert through date of today")
    public ConcertResponse execute(@PathVariable("concert_id") String id) {
        return usecase.execute(id);
        
    }
}
