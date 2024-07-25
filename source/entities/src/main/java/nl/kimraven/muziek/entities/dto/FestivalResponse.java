package nl.kimraven.muziek.entities.dto;

import java.time.LocalDate;

import nl.kimraven.muziek.entities.Festival;
import nl.kimraven.muziek.entities.Status;

/**
 * 
 */
public record FestivalResponse( 
        String id,
        Long version,
        String festivalName,
        String festivalLocation,
        LocalDate date,
        Status status){

      public FestivalResponse(Festival festival){
          this(
                  festival.getId(),
                  festival.getVersion(),
                  festival.getFestivalName(),
                  festival.getFestivalLocation(),
                  festival.getDate(),                  
                  festival.getStatus());

        }

  
    } 
    

