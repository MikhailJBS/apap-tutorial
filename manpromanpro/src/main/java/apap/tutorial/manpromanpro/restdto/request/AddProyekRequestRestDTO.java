package apap.tutorial.manpromanpro.restdto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProyekRequestRestDTO {
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
    private List<Long> listPekerjaId;

    @NotNull(message = "Developer proyek tidak boleh kosong")
    private Long developerId;

    @AssertTrue(message = "Tanggal selesai harus setelah tanggal mulai")
    private boolean isTanggalSelesaiValid() {
        if (tanggalMulai == null || tanggalSelesai == null) {
            return true;
        }
        return tanggalSelesai.after(tanggalMulai);
    }
}