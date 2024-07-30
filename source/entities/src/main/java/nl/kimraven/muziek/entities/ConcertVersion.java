package nl.kimraven.muziek.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 
 */
@Data
public class ConcertVersion {
    //
    @Version
    Long version;

    //
    @NotBlank
    String artistName;

    //
    @NotBlank
    String concertLocation;

    //
    @NotBlank
    LocalDate date;

    //
    @NotNull
    Status status;
}
