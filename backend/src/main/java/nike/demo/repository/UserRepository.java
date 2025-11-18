package nike.demo.repository;

import nike.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
   // List<User>findByAllIdDate(Long id);
}
