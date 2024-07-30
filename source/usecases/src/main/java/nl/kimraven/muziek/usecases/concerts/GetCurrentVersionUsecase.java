package nl.kimraven.muziek.usecases.concerts;


import nl.kimraven.muziek.entities.dto.CurrentVersionResponse;


/**
 * 
 */
public interface GetCurrentVersionUsecase {
    

    public CurrentVersionResponse execute(String id);
}
