package nl.kimraven.muziek.entities.exception;

public class AddConcertException extends RuntimeException {

    public AddConcertException() {
        super("Failed to add concert");
    }
    
}
