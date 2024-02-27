package app.auth.service.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import app.auth.service.user.model.User;

public interface UserRepository extends JpaRepository<User,String>{
    Optional<User> findByUserName(String userName);
}
