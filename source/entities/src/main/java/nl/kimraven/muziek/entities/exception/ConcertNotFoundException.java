package nl.kimraven.muziek.entities.exception;

public class ConcertNotFoundException extends RuntimeException {

    public ConcertNotFoundException() {
        super("Concert not found");
    }

    
}
