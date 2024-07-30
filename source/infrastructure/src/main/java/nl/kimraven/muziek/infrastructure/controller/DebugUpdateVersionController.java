package nl.kimraven.muziek.infrastructure.controller;

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
@Tag(name = "2. Concerts")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts/update/{id}")
public class DebugUpdateVersionController {

    //
    private final UpdateConcertVersionUsecase usecase;
    
     /**
     * 
     * @return
     */
    @PutMapping()
    @Operation(summary = "Update version of a concert")
    public Concert execute(String id) {
        return usecase.execute("c53177a2-c5d4-4418-967b-27f322acc2f5", new ConcertVersion());
        
    }
}

