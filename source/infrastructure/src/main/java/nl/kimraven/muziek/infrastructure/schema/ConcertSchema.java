package nl.kimraven.muziek.infrastructure.schema;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import nl.kimraven.muziek.entities.ConcertVersion;
import nl.kimraven.muziek.entities.Status;

/**
 * 
 */
@Data
@Document(collection = "concerts")
public class ConcertSchema {

    @Id
    private String id;

    private ConcertVersion current;
    private List<ConcertVersion> history;

    @Version
    private Long version;
    
    private String artistName;
    private String concertLocation;
    private LocalDate date;
    private Status status;
    
}
