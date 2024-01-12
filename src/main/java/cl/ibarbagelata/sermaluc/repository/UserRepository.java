package cl.ibarbagelata.sermaluc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ibarbagelata.sermaluc.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);

}
