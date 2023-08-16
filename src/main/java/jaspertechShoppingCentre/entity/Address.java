package jaspertechShoppingCentre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String emailAddress;
    private String fullName;
    private String phone;
    private String street;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
    private String country;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user-id", nullable = false)
    private AppUser user;

   @JsonIgnore
    @OneToOne(mappedBy = "address",  cascade = CascadeType.ALL )
    private Order order;

}
