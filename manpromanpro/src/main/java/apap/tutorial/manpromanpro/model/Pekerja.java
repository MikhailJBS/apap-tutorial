package apap.tutorial.manpromanpro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Where;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import jakarta.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pekerja")
@Where(clause = "deleted_at IS NULL")
public class Pekerja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "usia", nullable = false)
    private int usia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Size(max = 30)
    @Column(name = "pekerjaan", nullable = false)
    private String pekerjaan;

    @NotNull
    @Column(name = "biografi",columnDefinition = "TEXT", nullable = false)
    private String biografi;

    @ManyToMany
    List<Proyek> listProyek;

    @Column(name = "deleted_at")
    private Date deletedAt;
}
