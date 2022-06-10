package apireserva.com.apiReserva.Resources;

import apireserva.com.apiReserva.Models.CarModel;
import apireserva.com.apiReserva.Repository.CarRepository;
import apireserva.com.apiReserva.Services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/Administrar")
public class CarResource {
    private final CarRepository carRepository;
    private final CarService carService;


    @GetMapping("List")
    List<CarModel> getCars(CarModel carModel){
        List<CarModel> carModels = carService.getCars(carModel);

        return carModels;
    }

    @GetMapping("List/{nome}")
        public List<CarModel>findByName(@PathVariable String nome){
            List<CarModel> carByName = carService.findByName(nome);

            return carByName;
        };

    @GetMapping("List/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
       ResponseEntity<Object> carModelOptional = carService.getById(id);

       return ResponseEntity.status(HttpStatus.OK).body(carModelOptional);
    }

    @PostMapping("Register")
    public CarModel createCar(@RequestBody CarModel carModel){
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
    public ResponseEntity<CarModel> atualizarCli(@PathVariable Long codigo, @RequestBody CarModel carModel) {
        log.info("atualizarCli");
        log.info("codigo: {}", codigo);
        log.info("carModel: {}", carModel);

        CarModel carCurrent = carRepository.findById(codigo).get();
        BeanUtils.copyProperties(carModel, carCurrent, "id");

        return ResponseEntity.ok(carService.createCar(carCurrent));
    }

}
