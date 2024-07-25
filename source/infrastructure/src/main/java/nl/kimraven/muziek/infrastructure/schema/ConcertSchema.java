package nl.kimraven.muziek.infrastructure.schema;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import nl.kimraven.muziek.entities.Status;

/**
 * 
 */
@Data
@Document(collection = "concerts")
public class ConcertSchema {

    @Id
    private String id;

    @Version
    private Long version;
    
    private String artistName;
    private String concertLocation;
    private LocalDate date;
    private String year;
    private Status status;
    
}
