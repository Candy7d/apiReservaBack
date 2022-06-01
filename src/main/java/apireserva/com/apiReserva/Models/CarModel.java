package apireserva.com.apiReserva.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_carros")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkCar")
    private Long pkCaos;

    @Column(name = "nameCar")
    private String nameCar;

    @Column(name = "modelCar")
    private String modelCar;

    @Column(name = "companyCar")
    private String companyCar;

    @Column(name = "dateManufacture")
    private Date dateManufacture;



}
