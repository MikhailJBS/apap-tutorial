package apap.tutorial.manpromanpro.restdto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserResponseDTO {
    private Long id;
    private String username;
    private String name;
    private String role;
}
