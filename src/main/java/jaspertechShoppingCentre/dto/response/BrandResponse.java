package jaspertechShoppingCentre.dto.response;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {
    private String brandName;

    private String brandDescription;
    private String logoUrl;
    private Date createAt;

    private Date updateAt;
}
