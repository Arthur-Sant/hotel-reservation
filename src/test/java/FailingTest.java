import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class FailingTest {
    @Test
    public void whenEnteringDataShouldReturnLakewoodHotel() {
        HotelReservation hotel = new HotelReservation();
        assertEquals("Lakewood", hotel.getCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tue), 18Mar2009(wed)"));
    }
    @Test
    public void whenEnteringDataShouldReturnBridgewoodHotel() {
        HotelReservation hotel = new HotelReservation();
        assertEquals("Bridgewood", hotel.getCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
    }
    @Test
    public void whenEnteringDataShouldReturnRidgewoodHotel() {
        HotelReservation hotel = new HotelReservation();
        assertEquals("Ridgewood", hotel.getCheapestHotel("Rewards: 26Mar2009(thu), 27Mar2009(fri), 28Mar2009(sat)"));
    }

    @Test
    public void whenInsertingEmptyDataShouldReturnErrorMessageString(){
        HotelReservation hotel = new HotelReservation();
        assertEquals("Enter the datas", hotel.getCheapestHotel(""));
    }
}
