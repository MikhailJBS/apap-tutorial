package apap.tutorial.manpromanpro.restdto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProyekResponseDTO {
    private UUID id;
    private String nama;
    private String deskripsi;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DeveloperResponseDTO developer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PekerjaResponseDTO> listPekerja;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Jakarta")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Jakarta")
    private Date updatedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Jakarta")
    private Date deletedAt;
}
