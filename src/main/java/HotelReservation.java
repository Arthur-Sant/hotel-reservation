import repositories.implementations.HotelImplementation;
import services.HotelService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation {
    public String getCheapestHotel (String input) {

        if(input.isEmpty()){
            return "Enter the datas";
        }

        List<String> datesString = Arrays.asList(input.split(", "));
        String diaryType = datesString.get(0).substring(0, 9);
        datesString.set(0, datesString.get(0).replace(diaryType, ""));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyy(EEE)", Locale.US);
        List<Date> dates = new ArrayList<>();

        for(String date : datesString){
            try {
                dates.add(simpleDateFormat.parse(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        HotelImplementation hotelImplementation = new HotelImplementation();
        HotelService hotelService = new HotelService(hotelImplementation);

        String hotelName = hotelService.getCheapestHotel(diaryType.toLowerCase(), dates);

        return hotelName;
    }

    public static void main(String[] args)  {
        System.out.println("Hello word");
    }
}
