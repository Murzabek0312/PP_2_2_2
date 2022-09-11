package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    {
        Car car1 = new Car("Mercedes", "White", 336);
        Car car2 = new Car("BMW", "Black", 203);
        Car car3 = new Car("Toyota", "Silver", 125);
        Car car4 = new Car("Nissan", "Red", 106);
        Car car5 = new Car("Lada", "White", 87);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

    }
    @Override
    public List<Car> getAllCar() {
        return cars;
    }
    @Override
    public List<Car> getCarbyCount(int count) {
        if (count < 5) {
            return cars.stream().limit(count).collect(Collectors.toList());
        } else if (count >= 5) {
            return cars;
        } else {
            return null;
        }
    }
}
