package services;

import models.Hotel;
import repositories.IHotelRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HotelService {

    private IHotelRepository hotelRepository;

    public HotelService(IHotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public String getCheapestHotel(String diaryType, List<Date> dates){
        final List<List<Hotel>> allHotels = hotelRepository.findAll();
        String cheapestHotelName = "";
        Float cheapestHotelValue = 1100f;
        //Como os valores da diaria vao ate 1000, coloquei 1100 para fazer a comparaçao mais em baixo. Eu
        // poderia usar o Float.MAX_VALUE, mas nao achei nescessario oucupar tanto espaço na memoria

        for(List<Hotel> hotelDataList : allHotels){

            final Float[] sumDayValues = {0f};
            final String[] hotelName = {""};

            dates.forEach(date -> {
                Integer reservationDay = date.getDate();

                hotelDataList.forEach(hotelRate -> {
                    Integer hotelDay = hotelRate.getDate().getDate();

                    if (hotelDay.equals(reservationDay)){
                        hotelName[0] = hotelRate.getName();

                        if(diaryType.contains("regular")){
                            sumDayValues[0] += hotelRate.getDiaryRegular();
                        }else{
                            sumDayValues[0] += hotelRate.getDiaryReward();
                        }
                    }
                });

            });

            if (sumDayValues[0] <= cheapestHotelValue){
                cheapestHotelValue = sumDayValues[0];
                cheapestHotelName = hotelName[0];
            }
        }


        return cheapestHotelName;
    }
}
