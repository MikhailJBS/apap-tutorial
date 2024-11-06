package apap.tutorial.manpromanpro.restservice;

import java.util.List;
import java.util.UUID;

import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;

public interface ProyekRestService {
    ProyekResponseDTO addProyek(AddProyekRequestRestDTO proyekDTO);
    ProyekResponseDTO getProyekById(UUID idProyek);
    ProyekResponseDTO updateProyek(UpdateProyekRequestRestDTO proyekDTO);
    List<ProyekResponseDTO> getProyekByNama(String namaProyek);
    void deleteProyek(UUID idProyek);
    List<ProyekResponseDTO> getAllProyek();
}
