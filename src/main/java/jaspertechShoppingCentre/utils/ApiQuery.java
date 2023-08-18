package jaspertechShoppingCentre.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;

@Getter
@Setter
@AllArgsConstructor

@Builder
public class ApiQuery {
    private HashMap<String , Object> objectHashMap;

    public ApiQuery() {
        this.objectHashMap = new HashMap<>();
    }


    public HashMap<String, Object> getParams() {
        return  this.objectHashMap;
    }

    public void putParams(String key, Object value) {
        this.objectHashMap = objectHashMap;
    }
}
