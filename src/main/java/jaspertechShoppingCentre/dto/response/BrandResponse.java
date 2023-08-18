package jaspertechShoppingCentre.dto.response;

import lombok.*;

import java.time.LocalDate;
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
    private LocalDate createAt;

    private String updateAt;
}
