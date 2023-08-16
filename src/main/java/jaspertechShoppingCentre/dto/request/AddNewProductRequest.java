package jaspertechShoppingCentre.dto.request;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddNewProductRequest {
    @NotBlank(message = "product name cannot be blank")
    private String name;
   @DecimalMin(value = "0.0", message="Field Price can not be blank")
    private Double price;
@NotBlank(message = "Field ImageUrl cannot be blank")
    private String imageUrl;
@Range(min=0, message = "Field Available Quantity")
    private Integer availableQty;
    @NotBlank(message = "Field SubCategory cannot be blank")
private String subCategory;
    @NotBlank(message = "Field brand cannot be blank")
    private String brand;
    @NotBlank(message = "Field description cannot be blank")
    private String description;

}
