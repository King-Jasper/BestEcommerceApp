package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.AddNewProductRequest;
import jaspertechShoppingCentre.dto.request.UpdateProductRequest;
import jaspertechShoppingCentre.dto.response.ProductResponse;

public interface AdminService {
    ProductResponse addNewProduct(AddNewProductRequest addNewProductRequest);

    ProductResponse fetchSingleProduct(Long productId);

    ProductResponse updateProduct(Long productId, UpdateProductRequest updateProduct);

    String deleteProduct(Long productId);
}
