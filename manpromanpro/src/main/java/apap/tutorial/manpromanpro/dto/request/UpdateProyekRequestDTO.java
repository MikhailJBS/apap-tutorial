package apap.tutorial.manpromanpro.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProyekRequestDTO extends AddProyekRequestDTO {
    @NotNull(message = "ID proyek tidak boleh kosong")
    private UUID id;
}