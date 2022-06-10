package projetoFortes.Resources;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoFortes.Models.CarModel;
import projetoFortes.Repository.CarRepository;
import projetoFortes.Services.CarService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/Manage")
public class CarResources {
    private final CarRepository carRepository;
    private final CarService carService;


    @GetMapping("List")
    List<CarModel> getCars(CarModel carModel){
        List<CarModel> carModels = carService.getCars(carModel);

        return carModels;
    }

    @GetMapping("ListName/{nome}")
    public List<CarModel>findByName(@PathVariable String nome){
        List<CarModel> carByName = carService.findByName(nome);

        return carByName;
    };

    @GetMapping("ListId/{id}")
    public ResponseEntity<CarModel> findById(@PathVariable Long id) throws Exception {
        CarModel carModelOptional = carService.getById(id);

        return ResponseEntity.ok(carModelOptional);
    }

    @PostMapping("Register")
    public CarModel createCar(@RequestBody CarModel carModel) throws Exception {
        log.info("createCar");
        log.info("carModel: {}", carModel);

        CarModel carCreated = carService.createCar(carModel);
        return carCreated;
    }

    @DeleteMapping("/Delete/{id}")
    public void removeCarById(@PathVariable Long id){
        carService.removeCarById(id);
    }

    @PutMapping("/Refresh/{codigo}")
    public ResponseEntity<CarModel> atualizarCli(@PathVariable Long code, @RequestBody CarModel carModel) throws Exception {
        log.info("refreshCli");
        log.info("code: {}", code);
        log.info("carModel: {}", carModel);

        CarModel carCurrent = carRepository.findById(code).get();
        BeanUtils.copyProperties(carModel, carCurrent, "id");

        return ResponseEntity.ok(carService.createCar(carCurrent));
    }

}

