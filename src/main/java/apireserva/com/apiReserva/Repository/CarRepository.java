package apireserva.com.apiReserva.Repository;

import apireserva.com.apiReserva.Models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<CarModel,Long> {

    @Query(value = "select c from CarModel c where c.CarModel like :nome ")
    List<CarModel> findbyName(String nome);
}
