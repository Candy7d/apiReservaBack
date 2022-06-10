package projetoFortes.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import projetoFortes.Models.CarModel;
import projetoFortes.Repository.CarRepository;

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

    public CarModel getById(@PathVariable Long pkId) throws Exception {
        Optional<CarModel> carModelOptional = carRepository.findById(pkId);

        if(!carModelOptional.isPresent()){
            throw new Exception("Id não encnontrado!");
        }

        return carModelOptional.get();
    }

    public CarModel createCar(@RequestBody CarModel carModel) throws Exception {
        log.info("createCar");
        log.info("carModel: {}", carModel);

        if(carModel.getNameCar() == null || carModel.getNameCar().isEmpty()){
            throw new Exception("Não foi possível cadastrar o modelo!");
        }

        CarModel carCreated = carRepository.save(carModel);

        return carCreated;

    }

    public void removeCarById(@PathVariable Long pkId){
        carRepository.deleteById(pkId);
    }



}

