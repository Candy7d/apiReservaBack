package apireserva.com.apiReserva.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkCustomer")
    private Long pkCustomer;

    @Column(name = "nameCustomer")
    private String nameCustomer;

    @Column(name ="phoneCustomer")
    private String phoneCustomer;

    @Column(name = "cpfCustomer")
    private String cpfCustomer;

    @Column(name = "genderCustomer")
    private String genderCustomer;


}
