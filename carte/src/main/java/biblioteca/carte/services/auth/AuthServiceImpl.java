package biblioteca.carte.services.auth;

import biblioteca.carte.dto.SignupRequest;
import biblioteca.carte.dto.UserDto;
import biblioteca.carte.entity.User;
import biblioteca.carte.enums.UserRole;
import biblioteca.carte.repository.UserRepository;
import biblioteca.carte.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirtsByEmail(email).isPresent();
    }
}
