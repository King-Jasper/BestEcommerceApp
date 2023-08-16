package jaspertechShoppingCentre.dto.request;

import jaspertechShoppingCentre.entity.SearchCriteria;

import java.util.List;

public class ProductSearchRequest {
    private List<SearchCriteria> criteria;

    private  String dataOperator;
}
