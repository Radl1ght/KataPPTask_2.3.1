package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("Ferrari", "red", 22314));
        carsList.add(new Car("Toyota", "blue", 228022));
        carsList.add(new Car("Mitsubishi", "white", 148888));
        carsList.add(new Car("Mercedes", "yellow", 159951));
        carsList.add(new Car("Volkswagen", "black", 34322));
    }

    @Override
    public List<Car> getCarsList(Integer count) {
        if (count == null || count > carsList.size()) {
            count = 5;
        }
        return carsList.subList(0, count);
    }

}
