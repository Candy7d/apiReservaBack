package apireserva.com.apiReserva.Repository;

import apireserva.com.apiReserva.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<CarModel,Long> {

    List<CarModel> findbyName();
}
