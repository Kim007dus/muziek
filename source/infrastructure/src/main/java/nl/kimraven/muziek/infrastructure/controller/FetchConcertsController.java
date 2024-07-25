package nl.kimraven.muziek.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

import nl.kimraven.muziek.entities.dto.ConcertResponse;
import nl.kimraven.muziek.usecases.concerts.FetchConcertsUsecase;

/**
 * 
 */
@Tag(name = "1. Concerts")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts")
public class FetchConcertsController {
    
    //
    private final FetchConcertsUsecase usecase;

    /**
     * 
     * @return
     */
    @GetMapping()
    @Operation(summary = "Get a list of all concerts")
    public List<ConcertResponse> execute() {
        return usecase.execute();
    }
}
