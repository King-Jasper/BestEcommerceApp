package jaspertechShoppingCentre.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;

    @TimeZoneStorage
    private LocalDateTime time;

    private HttpStatus statusCode;

    private T data;

    public ApiResponse(T data) {
        this.message = "Processed successful";
        this.time = LocalDateTime.now();
        this.data = data;
    }
}