package biblioteca.carte.services.auth;

import biblioteca.carte.dto.SignupRequest;
import biblioteca.carte.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
