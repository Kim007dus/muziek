package nl.kimraven.muziek.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import nl.kimraven.muziek.entities.dto.PreviousVersionResponse;
import nl.kimraven.muziek.usecases.concerts.GetPreviousVersionUsecase;

/**
 * 
 */
@Tag(name = "Concerts")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/concerts/{concert_id}/previousversion")
public class GetPreviousVersionController {
    
    //
    private final GetPreviousVersionUsecase usecase;
    
   
      
     /**
     * 
     * @return
     */
    @GetMapping()
    @Operation(summary = "Get previous version of a concert")
    public PreviousVersionResponse execute(@PathVariable("concert_id") String id) {
        return usecase.execute(id);    
      
    }
}
