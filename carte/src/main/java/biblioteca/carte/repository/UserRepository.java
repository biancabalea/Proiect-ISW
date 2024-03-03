package biblioteca.carte.repository;

import biblioteca.carte.entity.User;
import biblioteca.carte.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirtsByEmail(String email);

    User findByUserRole(UserRole userRole);
}
