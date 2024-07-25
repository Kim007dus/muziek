package nl.kimraven.muziek.infrastructure.datasource;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Festival;
import nl.kimraven.muziek.infrastructure.schema.ConcertSchema;
import nl.kimraven.muziek.infrastructure.schema.FestivalSchema;

/**
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class MusicMapper {
   
    public static Concert toEntity(ConcertSchema schema) {
        var entity = new Concert();

        entity.setId(schema.getId());
        entity.setVersion(schema.getVersion());

        entity.setArtistName(schema.getArtistName());
        entity.setConcertLocation(schema.getConcertLocation());
        entity.setDate(schema.getDate());
        entity.setStatus(schema.getStatus());

        return entity;
        
    }

    public static Festival toEntity(FestivalSchema schema) {
        var entity = new Festival();

        entity.setId(schema.getId());
        entity.setVersion(schema.getVersion());

        entity.setFestivalName(schema.getFestivalName());
        entity.setFestivalLocation(schema.getFestivalLocation());
        entity.setDate(schema.getDate());
        entity.setStatus(schema.getStatus());

        return entity;
        
    }

    public static ConcertSchema toSchema(Concert entity) {
        var schema = new ConcertSchema();

        schema.setId(entity.getId());
        schema.setVersion(entity.getVersion());

        schema.setArtistName(entity.getArtistName());
        schema.setConcertLocation(entity.getConcertLocation());
        schema.setDate(entity.getDate());
        schema.setStatus(entity.getStatus());

        return schema;
        
    }

    public static FestivalSchema toSchema(Festival entity) {
        var schema = new FestivalSchema();

        schema.setId(entity.getId());
        schema.setVersion(entity.getVersion());

        schema.setFestivalName(entity.getFestivalName());
        schema.setFestivalLocation(entity.getFestivalLocation());
        schema.setDate(entity.getDate());
        schema.setStatus(entity.getStatus());

        return schema;
        
    }
}
