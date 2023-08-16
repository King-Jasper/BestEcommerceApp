package jaspertechShoppingCentre.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubCategoryRequest {
    private Long subCategoryId;
    @NotNull(message = "Field cannot be missing or empty")
    private String subCategoryName;


    private String imageUrl;
}
