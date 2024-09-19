package apap.tutorial.manpromanpro.repository;
import apap.tutorial.manpromanpro.model.Developer;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperDb extends JpaRepository<Developer, Long> {
    Optional<Developer> findById(Long id);

    List<Developer> findAll();

}
