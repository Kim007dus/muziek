package nl.kimraven.muziek.entities.exception;

public class StatusCancelledException extends RuntimeException {
    
    public StatusCancelledException() {
        super("If status is cancelled, status cannot be changed");
    }
}
