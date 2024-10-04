package apap.tutorial.manpromanpro.restservice;

import org.springframework.stereotype.Service;

import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProyekRestService {
    ProyekResponseDTO addProyek(AddProyekRequestRestDTO proyekDTO);
    ProyekResponseDTO getProyekById(UUID idProyek);
    ProyekResponseDTO updateProyek(UpdateProyekRequestRestDTO proyekDTO);
    void deleteProyek(UUID idProyek);
}
