package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.entity.Brand;
import jaspertechShoppingCentre.entity.SubCategory;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;

    private String productName;

    private String description;

    private SubCategory subCategoryName;

    private Brand brandName;

    private Double price;

    private Integer sales;

    private int quantityAvailable;
    private boolean isOutOfStock;

    private Date updateAt;

    private Date createdAt;
}
