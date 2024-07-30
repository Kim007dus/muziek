package nl.kimraven.muziek.usecases.concerts;

import nl.kimraven.muziek.entities.dto.PreviousVersionResponse;

public interface GetPreviousVersionUsecase {
    
    public PreviousVersionResponse execute(String id);
}
