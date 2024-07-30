package nl.kimraven.muziek.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 
 */
@Data
public class Concert {
    //
    @Id
    String id;

    //
    @NotBlank
    ConcertVersion current;

    //
    @NotNull
    List<ConcertVersion> history = new ArrayList<>();

}
