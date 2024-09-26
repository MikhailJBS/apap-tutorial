package apap.tutorial.manpromanpro.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPekerjaRequestDTO {
    private String nama;
    private int usia;
    private String pekerjaan;
    private String biografi;
}
