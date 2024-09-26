package apap.tutorial.manpromanpro.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import apap.tutorial.manpromanpro.model.Pekerja;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteMultiplePekerjaDTO {
    private List<Pekerja> listPekerja;
}
