package jaspertechShoppingCentre.dto.response;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private String categoryName;
    private Date createAt;

    private Date updateAt;
}
