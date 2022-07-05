package repositories;

import models.Hotel;

import java.util.List;

public interface IHotelRepository {
    public List<List<Hotel>> findAll();
}
