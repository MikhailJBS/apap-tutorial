package apap.tutorial.manpromanpro.restdto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeveloperResponseDTO {
    private Long id;
    private String nama;
    private String alamat;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tanggalBerdiri;

    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProyekResponseDTO> listProyek;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Jakarta")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Jakarta")
    private Date updatedAt;
}
