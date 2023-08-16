package jaspertechShoppingCentre.repositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jaspertechShoppingCentre.entity.State;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface StateRepository extends JpaRepository<State, Long> {

}
