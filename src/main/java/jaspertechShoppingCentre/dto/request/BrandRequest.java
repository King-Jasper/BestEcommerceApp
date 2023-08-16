package jaspertechShoppingCentre.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {
    private String brandName;
    private String brandDescription;

    private  String logoUrl;
}
