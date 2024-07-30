package nl.kimraven.muziek.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import nl.kimraven.muziek.entities.dto.CurrentVersionResponse;
import nl.kimraven.muziek.usecases.concerts.GetCurrentVersionUsecase;


/**
 * 
 */
@Tag(name = "1. Concert")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts/currentversion/{id}")
public class GetCurrentVersionConcertController {
    //
    private final GetCurrentVersionUsecase usecase;
    
     /**
     * 
     * @return
     */
    @GetMapping()
    @Operation(summary = "Get current version of a concert")
    public CurrentVersionResponse execute(String id) {
        return usecase.execute(id);
        
    }
}
