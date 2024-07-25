package nl.kimraven.muziek.usecases.concerts;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import nl.kimraven.muziek.entities.dto.ConcertResponse;

/**
 * 
 */
public interface AddConcertUsecase {

    public ConcertResponse execute(@NotBlank String artistName, @NotBlank LocalDate date, @NotBlank String concertLocation);
}
