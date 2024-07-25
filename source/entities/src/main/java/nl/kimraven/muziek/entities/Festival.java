package nl.kimraven.muziek.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 
 */
@Data
public class Festival {
    //
    @Id
    String id;
    
    //
    @Version
    Long version;

    //
    @NotBlank
    String festivalName;

    //
    @NotBlank
    String festivalLocation;
    
    //
    @NotBlank
    LocalDate date;

    //
    @NotNull
    Status status;
}
