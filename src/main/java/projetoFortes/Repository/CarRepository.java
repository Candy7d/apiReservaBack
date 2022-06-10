package projetoFortes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projetoFortes.Models.CarModel;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long> {

    @Query(value = "select c from CarModel c where c.nameCar like %:nome%")
    List<CarModel> findbyName(@Param("nome") String nome);
}
