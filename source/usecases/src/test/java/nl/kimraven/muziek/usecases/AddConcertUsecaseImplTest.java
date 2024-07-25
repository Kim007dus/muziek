// package nl.kimraven.muziek.usecases;

// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.Optional;

// import javax.swing.text.html.Option;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import nl.kimraven.muziek.entities.Concert;
// import nl.kimraven.muziek.entities.gateway.MusicGateway;


// /**
//  * 
//  */
// class AddConcertUsecaseImplTest {

//     //
//     private MusicGateway gateway;
//     private AddConcertUsecaseImpl usecase;
//     private Concert concert;
   

//     //
//     private final String artistName = "artistName";
//     private final String date = "04-07";
//     private final String year = "2021";
//     private final String concertLocation = "concertLocation";

    
//     @BeforeEach
//     void setUp() {
//         gateway = mock(MusicGateway.class);
//         usecase = new AddConcertUsecaseImpl(gateway);
//         concert = new Concert();
//         concert.setArtistName(artistName);
//         concert.setDate(date);
//         concert.setYear(year);
//         concert.setConcertLocation(concertLocation);
//     }

//     @Test
//     void testExecute() {
        

//         usecase.execute(artistName, date, year, concertLocation);
        

//         verify(gateway, times(1)).addConcert(concert);
//     }


// }
