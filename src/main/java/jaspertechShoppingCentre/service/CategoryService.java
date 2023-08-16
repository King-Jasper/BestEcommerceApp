package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.CategoryRequest;
import jaspertechShoppingCentre.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);



    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategory(Long categoryId);

    CategoryResponse editCategory(Long categoryId, CategoryRequest categoryRequest);

    String  deleteCategoryById(Long categoryId);
}
