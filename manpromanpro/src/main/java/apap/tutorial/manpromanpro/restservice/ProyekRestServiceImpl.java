package apap.tutorial.manpromanpro.restservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.repository.DeveloperDb;
import apap.tutorial.manpromanpro.repository.PekerjaDb;
import apap.tutorial.manpromanpro.repository.ProyekDb;
import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.DeveloperResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.PekerjaResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;
import jakarta.persistence.EntityNotFoundException;


@Service
@Transactional
public class ProyekRestServiceImpl implements ProyekRestService {

    @Autowired
    ProyekDb proyekDb;

    @Autowired
    PekerjaDb pekerjaDb;

    @Autowired
    DeveloperDb developerDb;

    @Override
    public ProyekResponseDTO addProyek(AddProyekRequestRestDTO proyekDTO) {
        // Create a new Proyek object
        Proyek proyek = new Proyek();
        proyek.setNama(proyekDTO.getNama());
        proyek.setDeskripsi(proyekDTO.getDeskripsi());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setStatus(proyekDTO.getStatus());
    
        // Fetch the developer by ID
        Developer developer = developerDb.findById(proyekDTO.getDeveloperId())
                .orElseThrow(() -> new EntityNotFoundException("Developer with ID " + proyekDTO.getDeveloperId() + " not found"));
        proyek.setDeveloper(developer);
    
        // Initialize the list of pekerja
        proyek.setListPekerja(new ArrayList<>());
        
        if (proyekDTO.getListPekerjaId() != null) {
            // Add each pekerja to the project
            proyekDTO.getListPekerjaId().forEach(idPekerja -> {
                Pekerja pekerja = pekerjaDb.findById(idPekerja)
                        .orElseThrow(() -> new EntityNotFoundException("Pekerja with ID " + idPekerja + " not found"));
                
                pekerja.getListProyek().add(proyek);
                proyek.getListPekerja().add(pekerja);
            });
        }
    
        // Set the timestamps
        proyek.setCreatedAt(new Date());
        proyek.setUpdatedAt(new Date());
    
        // Save the new proyek to the database
        Proyek savedProyek = proyekDb.save(proyek);
        
        // Convert and return the response
        return proyekToProyekResponseDTO(savedProyek);
    }

    @Override
    public ProyekResponseDTO getProyekById(UUID idProyek) {
        var proyek = proyekDb.findById(idProyek).orElse(null);

        if (proyek == null) {
            return null;
        }

        return proyekToProyekResponseDTO(proyek);
    }

    @Override
    public ProyekResponseDTO updateProyek(UpdateProyekRequestRestDTO proyekDTO) {
        Proyek proyek = proyekDb.findById(proyekDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Proyek with ID " + proyekDTO.getId() + " not found"));
    
        // Update basic properties
        proyek.setNama(proyekDTO.getNama());
        proyek.setDeskripsi(proyekDTO.getDeskripsi());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setStatus(proyekDTO.getStatus());
        proyek.setUpdatedAt(new Date());
    
        // Update developer if provided
        if (proyekDTO.getDeveloperId() != null) {
            Developer developer = developerDb.findById(proyekDTO.getDeveloperId())
                    .orElseThrow(() -> new EntityNotFoundException("Developer with ID " + proyekDTO.getDeveloperId() + " not found"));
            proyek.setDeveloper(developer);
        }
    
        // Update pekerja list if provided
        if (proyekDTO.getListPekerjaId() != null) {
            // Clear existing relationships
            proyek.getListPekerja().forEach(pekerja -> {
                pekerja.getListProyek().remove(proyek);
            });
            proyek.getListPekerja().clear();
    
            // Add new relationships
            proyekDTO.getListPekerjaId().forEach(idPekerja -> {
                Pekerja pekerja = pekerjaDb.findById(idPekerja)
                        .orElseThrow(() -> new EntityNotFoundException("Pekerja with ID " + idPekerja + " not found"));
                pekerja.getListProyek().add(proyek);
                proyek.getListPekerja().add(pekerja);
            });
        }
    
        // Save and return the updated proyek
        Proyek savedProyek = proyekDb.save(proyek);
        return proyekToProyekResponseDTO(savedProyek);
    }

    @Override
    public void deleteProyek(UUID idProyek) {
        var proyek = proyekDb.findById(idProyek).orElseThrow(() -> new EntityNotFoundException("Proyek with ID " + idProyek + " not found"));
        proyek.setDeletedAt(new Date());
        proyekDb.save(proyek);
    }

    private ProyekResponseDTO proyekToProyekResponseDTO(Proyek proyek) {
        ProyekResponseDTO proyekResponseDTO = new ProyekResponseDTO();
        proyekResponseDTO.setId(proyek.getId());
        proyekResponseDTO.setNama(proyek.getNama());
        proyekResponseDTO.setDeskripsi(proyek.getDeskripsi());
        proyekResponseDTO.setTanggalMulai(proyek.getTanggalMulai());
        proyekResponseDTO.setTanggalSelesai(proyek.getTanggalSelesai());
        proyekResponseDTO.setStatus(proyek.getStatus());
        proyekResponseDTO.setDeveloper(developerToDeveloperResponseDTO(proyek.getDeveloper()));
        proyekResponseDTO.setDeletedAt(proyek.getDeletedAt());
        proyekResponseDTO.setCreatedAt(proyek.getCreatedAt());
        proyekResponseDTO.setUpdatedAt(proyek.getUpdatedAt());

        if (proyek.getListPekerja() != null) {
            List<PekerjaResponseDTO> listPekerjaResponseDTO = new ArrayList<>();
            proyek.getListPekerja().forEach(pekerja -> {
                PekerjaResponseDTO pekerjaResponseDTO = new PekerjaResponseDTO();
                pekerjaResponseDTO.setId(pekerja.getId());
                pekerjaResponseDTO.setNama(pekerja.getNama());
                pekerjaResponseDTO.setUsia(pekerja.getUsia());
                pekerjaResponseDTO.setPekerjaan(pekerja.getPekerjaan());
                pekerjaResponseDTO.setBiografi(pekerja.getBiografi());
                pekerjaResponseDTO.setCreatedAt(pekerja.getCreatedAt());
                pekerjaResponseDTO.setUpdatedAt(pekerja.getUpdatedAt());
                listPekerjaResponseDTO.add(pekerjaResponseDTO);
            });
            proyekResponseDTO.setListPekerja(listPekerjaResponseDTO);
        }


        return proyekResponseDTO;
    }

    private DeveloperResponseDTO developerToDeveloperResponseDTO(Developer developer) {
        DeveloperResponseDTO developerResponseDTO = new DeveloperResponseDTO();
        developerResponseDTO.setId(developer.getId());
        developerResponseDTO.setNama(developer.getNama());
        developerResponseDTO.setAlamat(developer.getAlamat());
        developerResponseDTO.setEmail(developer.getEmail());
        developerResponseDTO.setTanggalBerdiri(developer.getTanggalBerdiri());
        developerResponseDTO.setCreatedAt(developer.getCreatedAt());
        developerResponseDTO.setUpdatedAt(developer.getUpdatedAt());
        return developerResponseDTO;
    }

    @Override
    public List<ProyekResponseDTO> getProyekByNama(String namaProyek) {
        List<Proyek> proyekList = proyekDb.findByNamaIgnoreCase(namaProyek);
        List<ProyekResponseDTO> proyekResponseDTOList = new ArrayList<>();
        proyekList.forEach(proyek -> {
            proyekResponseDTOList.add(proyekToProyekResponseDTO(proyek));
        });
        return proyekResponseDTOList;
    }

    @Override
    public List<ProyekResponseDTO> getAllProyek() {
        List<Proyek> proyekList = proyekDb.findAll();
        List<ProyekResponseDTO> proyekResponseDTOList = new ArrayList<>();
        proyekList.forEach(proyek -> {
            proyekResponseDTOList.add(proyekToProyekResponseDTO(proyek));
        });
        return proyekResponseDTOList;
    }
    
}
