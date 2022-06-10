package apireserva.com.apiReserva.Services;

import apireserva.com.apiReserva.Models.CarModel;
import apireserva.com.apiReserva.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<CarModel> getCars(CarModel carModel){
        List<CarModel> carModels = carRepository.findAll();
        return carModels;
    }

    public List<CarModel> findByName(@PathVariable String nome){
        List<CarModel> parameterName = carRepository.findbyName(nome);
        return parameterName;
    }

    public ResponseEntity<Object> getById(@PathVariable Long pkId){
        Optional<CarModel> carModelOptional = carRepository.findById(pkId);

        if(!carModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(carModelOptional);
    }

    public CarModel createCar(@RequestBody CarModel carModel){
        log.info("createCar");
        log.info("carModel: {}", carModel);

        CarModel carCreated = carRepository.save(carModel);

        try{
            if(carCreated.getNameCar() == null || carCreated.getNameCar() == null)
            {

        }}catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return carCreated;

    }

    public void removeCarById(@PathVariable Long pkId){
        carRepository.deleteById(pkId);
    }



}
