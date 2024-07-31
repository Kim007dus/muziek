package nl.kimraven.muziek.infrastructure.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.ConcertVersion;
import nl.kimraven.muziek.usecases.concerts.UpdateConcertVersionUsecase;

/**
 * 
 */
@Tag(name = "Debug")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/concerts/{concert_id}/updateversion")
public class DebugUpdateVersionController {

    //
    private final UpdateConcertVersionUsecase usecase;
    
     /**
     * 
     * @return
     */
    @PutMapping()
    @Operation(summary = "Debug - update version of a concert")
    public Concert execute(@PathVariable("concert_id") String id) {
        return usecase.execute(id, new ConcertVersion());
        
    }
}

