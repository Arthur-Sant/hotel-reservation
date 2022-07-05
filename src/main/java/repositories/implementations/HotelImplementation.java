package repositories.implementations;

import models.Hotel;
import repositories.IHotelRepository;

import java.util.*;

public class HotelImplementation implements IHotelRepository {

    public List<List<Hotel>> findAll(){
        List<List<Hotel>> allHotelData = new ArrayList<List<Hotel>>();
        List<Hotel> lakewoodDataList = this.addData("Lakewood");
        List<Hotel> bridgewoodDataList = this.addData("Bridgewood");
        List<Hotel> ridgewoodDataList = this.addData("Ridgewood");

        // Nessa parte eu setei valores de 100, porque o teste requer dias especificos que seja baratos, e
        // na interação que fiz no metodo addData abaixo, adicionei valores aleatorios entre 500 a 1000
        lakewoodDataList.get(15).setDiaryRegular(100f);
        lakewoodDataList.get(16).setDiaryRegular(100f);
        lakewoodDataList.get(17).setDiaryRegular(100f);

        bridgewoodDataList.get(19).setDiaryRegular(100f);
        bridgewoodDataList.get(20).setDiaryRegular(100f);
        bridgewoodDataList.get(21).setDiaryRegular(100f);

        ridgewoodDataList.get(25).setDiaryReward(100f);
        ridgewoodDataList.get(26).setDiaryReward(100f);
        ridgewoodDataList.get(27).setDiaryReward(100f);

        allHotelData.add(lakewoodDataList);
        allHotelData.add(bridgewoodDataList);
        allHotelData.add(ridgewoodDataList);

        return allHotelData;
    }

    private List<Hotel> addData(String hotelName){
        List<Hotel> dataList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2009, Calendar.MARCH, 1);
        Random random = new Random();

        for (int cont = 1; cont <= 31; cont++){
            String id = UUID.randomUUID().toString();
            calendar.set(Calendar.DATE, cont);
            Date date = calendar.getTime();
            Float diaryRegular = random.nextInt(500) + 500f;
            Float diaryReward = random.nextInt(500) + 500f;

            Hotel hotel = new Hotel(id, hotelName, date, diaryRegular, diaryReward);

            dataList.add(hotel);
        }

        return dataList;
    }
}