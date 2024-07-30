// package nl.kimraven.muziek.usecases;

// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;

// import java.time.LocalDate;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import nl.kimraven.muziek.entities.Concert;
// import nl.kimraven.muziek.entities.gateway.MusicGateway;
// import nl.kimraven.muziek.usecases.concerts.FetchConcertsUsecaseImpl;

// /**
//  * 
//  */
// class FetchConcertsUsecaseImplTest {

//      //
//     private MusicGateway gateway;
//     private FetchConcertsUsecaseImpl usecase;
//     private Concert concert;
   

//     //
//     private final String artistName = "artistName";
//     private final LocalDate date = LocalDate.of(2021, 7, 04);
//     private final String concertLocation = "concertLocation";

    
//     @BeforeEach
//     void setUp() {
//         gateway = mock(MusicGateway.class);
//         usecase = new FetchConcertsUsecaseImpl(gateway);
//         concert = new Concert();
//         concert.setArtistName(artistName);
//         concert.setDate(date);
//         concert.setConcertLocation(concertLocation);
//     }

//     @Test
//     void testExecute() {
//         usecase.execute();
        

//         verify(gateway, times(1)).findAllConcerts();
//     }
// }


