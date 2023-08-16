package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.BrandRequest;
import jaspertechShoppingCentre.dto.response.BrandResponse;

import java.util.List;

public interface BrandService {
    BrandResponse createBrand(BrandRequest brandRequest);

    List<BrandResponse> getAllBrands();

    BrandResponse  getBrandById(Long brandId);

    BrandResponse updateBrand(Long brandId, BrandRequest brandRequest);

    String deleteBrand(Long brandId);
}
