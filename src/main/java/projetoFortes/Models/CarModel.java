package projetoFortes.Models;

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
    @Column(name = "pkcar")
    private Long pkCar;

    @Column(name = "name_car")
    private String nameCar;

    @Column(name = "model_car")
    private String modelCar;

    @Column(name = "company_car")
    private String companyCar;

    @Column(name = "date_manufacture")
    private Date dateManufacture;
}
