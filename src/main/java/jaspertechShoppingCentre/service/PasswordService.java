package jaspertechShoppingCentre.service;

import jakarta.servlet.http.HttpServletRequest;
import jaspertechShoppingCentre.dto.request.ResetPasswordRequest;

public interface PasswordService {
    String forgetPassword(String email, HttpServletRequest request);
    String resetPassword(ResetPasswordRequest request);
}
