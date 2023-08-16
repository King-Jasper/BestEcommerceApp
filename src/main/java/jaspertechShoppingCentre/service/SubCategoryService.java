package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.SubCategoryRequest;
import jaspertechShoppingCentre.dto.response.SubCategoryResponse;

import java.util.List;
import java.util.Set;

public interface SubCategoryService {

    SubCategoryResponse addNewCategory(SubCategoryRequest subCategoryRequest, Long categoryId);

    List<SubCategoryResponse> viewAllCategories();

    SubCategoryResponse editSubCategory(SubCategoryRequest subCategoryRequest, Long subCategoryId);

    String  deleteSubCategory(Long subCategoryId);

    Set<SubCategoryResponse> viewSubCategoryByCategory(Long categoryId);
}
