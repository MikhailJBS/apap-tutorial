package apap.tutorial.manpromanpro.dto.request;

import java.util.List;

import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.model.Pekerja;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProyekRequestDTO {
    @NotBlank(message = "Nama proyek tidak boleh kosong")
    @Size(max = 30, message = "Nama proyek tidak boleh lebih dari 30 karakter")
    private String nama;

    @NotBlank(message = "Deskripsi proyek tidak boleh kosong")
    private String deskripsi;

    @NotNull(message = "Tanggal mulai tidak boleh kosong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @NotNull(message = "Tanggal selesai tidak boleh kosong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    @NotBlank(message = "Status tidak boleh kosong")
    @Pattern(regexp = "STARTED|ONGOING|FINISHED", message = "Status harus STARTED, ONGOING, atau FINISHED")
    private String status;

    @NotNull(message = "Pekerja proyek tidak boleh kosong")
    private List<Pekerja> listPekerja;

    @NotNull(message = "Developer proyek tidak boleh kosong")
    private Developer developer;

    @AssertTrue(message = "Tanggal selesai harus setelah tanggal mulai")
    private boolean isTanggalSelesaiValid() {
        if (tanggalMulai == null || tanggalSelesai == null) {
            return true; // Let @NotNull handle null checks
        }
        return tanggalSelesai.after(tanggalMulai);
    }
}