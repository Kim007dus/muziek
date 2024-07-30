package nl.kimraven.muziek.infrastructure.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.kimraven.muziek.entities.Concert;
import nl.kimraven.muziek.entities.Festival;
import nl.kimraven.muziek.entities.gateway.MusicGateway;
import nl.kimraven.muziek.infrastructure.datasource.MusicMapper;
import nl.kimraven.muziek.infrastructure.datasource.ConcertRepository;
import nl.kimraven.muziek.infrastructure.datasource.FestivalRepository;

/**
 * 
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MusicGatewayImpl implements MusicGateway {

    //
    private final ConcertRepository concertRepository;
    private final FestivalRepository festivalRepository;


    // ---------------------------------------------------------------------------------
    // Concert
    // ---------------------------------------------------------------------------------

    @Override
    public List<Concert> findAllConcerts() {
        return concertRepository.findAll().stream().map(MusicMapper::toEntity).toList();

    }

    @Override
    public Optional<Concert> findConcertById(String id) {
        return concertRepository.findById(id).map(MusicMapper::toEntity);
    }


    @Override
    public Optional<Concert> findConcertByArtist(String artistName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findConcertByArtist'");
    }

    // ---------------------------------------------------------------------------------
    // Festival
    // ---------------------------------------------------------------------------------

    @Override
    public List<Festival> findAllFestivals() {
        return festivalRepository.findAll().stream().map(MusicMapper::toEntity).toList();
    }


    @Override
    public Optional<Festival> findFestivalById(String id) {
        return festivalRepository.findById(id).map(MusicMapper::toEntity);
    }


    @Override
    public Optional<Festival> findFestivalByName(String festivalName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFestivalByName'");
    }

    //---------------------------------------------


    // save concert en festival in de database
    @Override
    public Optional<Concert> saveConcert(Concert concert) {
        return Optional.ofNullable(MusicMapper.toEntity(concertRepository.save(MusicMapper.toSchema(concert))));

    }
    
    @Override
    public Optional<Festival> saveFestival(Festival festival) {
        return Optional.ofNullable(MusicMapper.toEntity(festivalRepository.save(MusicMapper.toSchema(festival))));
    }
    
    @Override
    public Optional<Concert> updateConcert(String id, Concert concert) {
         return concertRepository.findById(id).map(existingConcert -> {
            existingConcert.getHistory().add(existingConcert.getCurrent());
            existingConcert.setCurrent(concert.getCurrent());
            log.info("Updated concert with id: {}", id);

            Concert savedConcert = MusicMapper.toEntity(concertRepository.save(existingConcert));
            log.info("Updated concert: {}", savedConcert);        
            return savedConcert;
        });
    }

    // delete concert en festival uit de database
    @Override
    public void deleteConcert(Concert concert) {
        concertRepository.deleteById(concert.getId());
    }

    @Override
    public void deleteFestival(Festival festival) {
        festivalRepository.deleteById(festival.getId());
    }

   

}
