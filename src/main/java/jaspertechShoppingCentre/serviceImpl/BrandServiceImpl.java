package jaspertechShoppingCentre.serviceImpl;

import jaspertechShoppingCentre.dto.request.BrandRequest;
import jaspertechShoppingCentre.dto.response.BrandResponse;
import jaspertechShoppingCentre.entity.Brand;
import jaspertechShoppingCentre.repositories.BrandRepository;
import jaspertechShoppingCentre.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    @Override
    public BrandResponse createBrand(BrandRequest brandRequest) {
        Brand brand = mapToBrand(brandRequest);
        Brand newBrand = brandRepository.save(brand);
        Return mapToBrandResponse(newBrand);
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        return null;
    }

    @Override
    public BrandResponse getBrandById(Long brandId) {
        return null;
    }

    @Override
    public BrandResponse updateBrand(Long brandId, BrandRequest brandRequest) {
        return null;
    }

    @Override
    public String deleteBrand(Long brandId) {
        return null;
    }
}
