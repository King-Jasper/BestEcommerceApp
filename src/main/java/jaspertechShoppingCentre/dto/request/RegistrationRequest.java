package jaspertechShoppingCentre.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jaspertechShoppingCentre.enums.Gender;
import jaspertechShoppingCentre.enums.Roles;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;


    private String phone;

    @NotBlank(message = "Password is required")
    private String password;

    private String  dateOfBirth;

    private Gender gender;

    private Roles role;
}
