package nl.kimraven.muziek.usecases.concerts;

import jakarta.validation.constraints.NotBlank;
import nl.kimraven.muziek.entities.dto.ConcertResponse;

/**
 * 
 */
public interface ChangeStatusConcertUsecase {
    
    public ConcertResponse execute(@NotBlank String id);
    
}
