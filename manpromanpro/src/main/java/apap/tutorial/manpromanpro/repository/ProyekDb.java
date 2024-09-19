package apap.tutorial.manpromanpro.repository;
import apap.tutorial.manpromanpro.model.Proyek;
import java.util.UUID;
import java.util.List;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProyekDb extends JpaRepository<Proyek, UUID> {

    List<Proyek> findByDeletedAtIsNull();
    List<Proyek> findByNamaContainingIgnoreCaseAndStatusContainingIgnoreCaseAndDeletedAtIsNull(String nama, String status, Sort sort);
}
