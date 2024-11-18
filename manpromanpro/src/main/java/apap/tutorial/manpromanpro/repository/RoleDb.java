package apap.tutorial.manpromanpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import apap.tutorial.manpromanpro.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDb extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
    Optional<Role> findByRole(String role);
}
