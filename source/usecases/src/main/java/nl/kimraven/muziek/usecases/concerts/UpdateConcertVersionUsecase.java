package nl.kimraven.muziek.usecases.concerts;

import jakarta.validation.constraints.NotBlank;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.ConcertVersion;


public interface UpdateConcertVersionUsecase {
    
    public Concert execute(@NotBlank String id, ConcertVersion newVersion);
}
