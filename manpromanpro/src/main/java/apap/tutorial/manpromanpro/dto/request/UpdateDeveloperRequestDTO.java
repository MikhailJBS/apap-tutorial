package apap.tutorial.manpromanpro.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDeveloperRequestDTO extends AddDeveloperRequestDTO {
    private Long id;
}
