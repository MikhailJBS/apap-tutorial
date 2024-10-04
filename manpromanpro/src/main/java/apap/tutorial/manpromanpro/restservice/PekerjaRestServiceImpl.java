package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.request.AddPekerjaRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.request.UpdatePekerjaRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.DeveloperResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.PekerjaResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.repository.PekerjaDb;
import apap.tutorial.manpromanpro.repository.ProyekDb;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PekerjaRestServiceImpl implements PekerjaRestService {
    @Autowired
    PekerjaDb pekerjaDb;

    @Autowired
    ProyekDb proyekDb;

    @Override
    public PekerjaResponseDTO addPekerja(AddPekerjaRequestRestDTO pekerjaDTO) {
        Pekerja pekerja = new Pekerja();
        pekerja.setNama(pekerjaDTO.getNama());
        pekerja.setUsia(pekerjaDTO.getUsia());
        pekerja.setPekerjaan(pekerjaDTO.getPekerjaan());

        if (pekerjaDTO.getBiografi() != null) {
            pekerja.setBiografi(pekerjaDTO.getBiografi());
        }

        pekerja.setListProyek(new ArrayList<>());
        if (pekerjaDTO.getListProyek() != null) {
            Set<UUID> uniqueProyekIds = new HashSet<>(pekerjaDTO.getListProyek());
            
            uniqueProyekIds.forEach(idProyek -> {
                Proyek proyek = proyekDb.findById(idProyek).orElse(null);
                if (proyek != null) {
                    pekerja.getListProyek().add(proyek);
                    proyek.getListPekerja().add(pekerja);
                }
            });
        }

        var newPekerja = pekerjaDb.save(pekerja);
        return pekerjaToPekerjaResponseDTO(newPekerja);
    }

    @Override
    public List<PekerjaResponseDTO> getAllPekerja() {

        var listPekerja = pekerjaDb.findAll();
        var listPekerjaResponseDTO = new ArrayList<PekerjaResponseDTO>();
        listPekerja.forEach(pekerja -> {
            var pekerjaResponseDTO =pekerjaToPekerjaResponseDTO(pekerja);
            listPekerjaResponseDTO.add(pekerjaResponseDTO);
        });

        return listPekerjaResponseDTO;
    }

    @Override
    public PekerjaResponseDTO getPekerjaById(Long idPekerja) {
        var pekerja = pekerjaDb.findById(idPekerja).orElse(null);

        if (pekerja == null) {
            return null;
        }

        return pekerjaToPekerjaResponseDTO(pekerja);
    }

    @Override
    public PekerjaResponseDTO updatePekerjaRest(UpdatePekerjaRequestRestDTO pekerjaDTO) {
        Pekerja pekerja = pekerjaDb.findById(pekerjaDTO.getId()).orElse(null);
        if (pekerja == null) {
            return null;
        }

        pekerja.setNama(pekerjaDTO.getNama());
        pekerja.setUsia(pekerjaDTO.getUsia());
        pekerja.setPekerjaan(pekerjaDTO.getPekerjaan());

        if (pekerjaDTO.getBiografi() != null) {
            pekerja.setBiografi(pekerjaDTO.getBiografi());
        }

        var listProyekFromDTO = pekerjaDTO.getListProyek();
        if (listProyekFromDTO != null) {
            // Convert incoming list to Set to remove duplicates
            Set<UUID> uniqueProyekIds = new HashSet<>(listProyekFromDTO);
            
            var listProyekExisting = pekerja.getListProyek();

            if (listProyekExisting != null && !listProyekExisting.isEmpty()) {
                // Remove pekerja from proyek that are no longer in the list
                listProyekExisting.forEach(proyek -> {
                    if (!uniqueProyekIds.contains(proyek.getId())) {
                        proyek.getListPekerja().remove(pekerja);
                    }
                });

                pekerja.setListProyek(new ArrayList<>());
                uniqueProyekIds.forEach(idProyek -> {
                    Proyek proyek = proyekDb.findById(idProyek).orElse(null);
                    if (proyek != null) {
                        pekerja.getListProyek().add(proyek);
                        if (!proyek.getListPekerja().contains(pekerja)) {
                            proyek.getListPekerja().add(pekerja);
                        }
                    }
                });
            } else {
                pekerja.setListProyek(new ArrayList<>());
                uniqueProyekIds.forEach(idProyek -> {
                    Proyek proyek = proyekDb.findById(idProyek).orElse(null);
                    if (proyek != null) {
                        pekerja.getListProyek().add(proyek);
                        proyek.getListPekerja().add(pekerja);
                    }
                });
            }
        }

        var updatePekerja = pekerjaDb.save(pekerja);
        return pekerjaToPekerjaResponseDTO(updatePekerja);
    }

    private PekerjaResponseDTO pekerjaToPekerjaResponseDTO(Pekerja pekerja) {
        var pekerjaResponseDTO = new PekerjaResponseDTO();
        pekerjaResponseDTO.setId(pekerja.getId());
        pekerjaResponseDTO.setNama(pekerja.getNama());
        pekerjaResponseDTO.setUsia(pekerja.getUsia());
        pekerjaResponseDTO.setPekerjaan(pekerja.getPekerjaan());
        pekerjaResponseDTO.setBiografi(pekerja.getBiografi());
        pekerjaResponseDTO.setCreatedAt(pekerja.getCreatedAt());
        pekerjaResponseDTO.setUpdatedAt(pekerja.getUpdatedAt());

        if (pekerja.getListProyek() != null) {
            var listProyekResponseDTO = new ArrayList<ProyekResponseDTO>();
            pekerja.getListProyek().forEach(proyek -> {
                var proyekResponseDTO = new ProyekResponseDTO();
                var developerResponseDTO = new DeveloperResponseDTO();

                proyekResponseDTO.setId(proyek.getId());
                proyekResponseDTO.setNama(proyek.getNama());
                proyekResponseDTO.setDeskripsi(proyek.getDeskripsi());
                proyekResponseDTO.setTanggalMulai(proyek.getTanggalMulai());
                proyekResponseDTO.setTanggalSelesai(proyek.getTanggalSelesai());
                proyekResponseDTO.setStatus(proyek.getStatus());
                proyekResponseDTO.setCreatedAt(proyek.getCreatedAt());
                proyekResponseDTO.setUpdatedAt(proyek.getUpdatedAt());

                developerResponseDTO.setId(proyek.getDeveloper().getId());
                developerResponseDTO.setNama(proyek.getDeveloper().getNama());
                developerResponseDTO.setAlamat(proyek.getDeveloper().getAlamat());
                developerResponseDTO.setTanggalBerdiri(proyek.getDeveloper().getTanggalBerdiri());
                developerResponseDTO.setEmail(proyek.getDeveloper().getEmail());
                developerResponseDTO.setCreatedAt(proyek.getDeveloper().getCreatedAt());
                developerResponseDTO.setUpdatedAt(proyek.getDeveloper().getUpdatedAt());
                proyekResponseDTO.setDeveloper(developerResponseDTO);

                listProyekResponseDTO.add(proyekResponseDTO);
            });

            pekerjaResponseDTO.setListProyek(listProyekResponseDTO);
        }
        return pekerjaResponseDTO;
    }

    @Override
    public void deletePekerja(List<Long> listIdPekerja) throws EntityNotFoundException, ConstraintViolationException {
        for (Long id : listIdPekerja) {
            var pekerja = pekerjaDb.findById(id).orElseThrow(() -> new EntityNotFoundException("Pekerja with ID " + id + " not found"));
    
            if (pekerja.getListProyek() == null || pekerja.getListProyek().isEmpty()) {
                pekerja.setDeletedAt(new Date());
            } else {
                throw new ConstraintViolationException("Cannot delete pekerja assigned to proyek", null);
            }
        }
    }
    
}