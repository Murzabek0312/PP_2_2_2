package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarbyCount( int count);
    List<Car> getAllCar();
}
