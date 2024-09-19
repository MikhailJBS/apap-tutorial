package apap.tutorial.manpromanpro.model;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "nama", nullable = false)
    @NotNull
    @Size(max = 30)
    private String nama;

    @NotNull
    @Column(name = "deskripsi", columnDefinition = "TEXT", nullable = false)
    private String deskripsi;

    @Column(name = "tanggal_mulai", columnDefinition = "DATE",  nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @Column(name = "tanggal_selesai", columnDefinition = "DATE",  nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @NotNull
    @Size(max = 30)
    @Column(name = "status", nullable = false)
    private String status; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_developer", referencedColumnName = "id")
    private Developer developer;

    @ManyToMany
    @JoinTable(
        name = "pekerja_proyek",
        joinColumns = @JoinColumn(name = "id_proyek"),
        inverseJoinColumns = @JoinColumn(name = "id_peekerja"))
    List<Pekerja> listPekerja;

    @Column(name = "deleted_at")
    private Date deletedAt;
}