package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.sql.SQLOutput;

@Controller
public class CarController {

    final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCar(@RequestParam(value = "count",required = false) Integer count, Model model){
        //System.out.println(count);
        if(count!=null) {
           model.addAttribute("cars", carService.getCarbyCount(count));
           System.out.println(carService.getCarbyCount(count));
       } if(count==null) {
           model.addAttribute("cars", carService.getAllCar());
       }
        return "cars";
    }
}
