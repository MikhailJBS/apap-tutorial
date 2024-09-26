package apap.tutorial.manpromanpro.service;

import java.util.List;
import java.util.UUID;
import java.util.Date;

import apap.tutorial.manpromanpro.repository.ProyekDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.manpromanpro.model.Proyek;
import org.springframework.data.domain.Sort;


@Service
public class ProyekServiceImpl implements ProyekService {
    @Autowired
    ProyekDb proyekDb;

    @Override
    public Proyek addProyek(Proyek proyek) {
        return proyekDb.save(proyek);
    }

    @Override
    public List<Proyek> getAllProyek() {
        return proyekDb.findAll();
    }

    @Override
    public Proyek getProyekById(UUID idProyek) {
        for (Proyek proyek : getAllProyek()) {
            if (proyek.getId().equals(idProyek)) {
                return proyek;
            }
        }
        return null;
    }

    @Override
    public Proyek updateProyek(Proyek proyek) {
        Proyek getProyek = getProyekById(proyek.getId());
        if (getProyek != null) {
            getProyek.setNama(proyek.getNama());
            getProyek.setDeskripsi(proyek.getDeskripsi());
            getProyek.setTanggalMulai(proyek.getTanggalMulai());
            getProyek.setTanggalSelesai(proyek.getTanggalSelesai());
            getProyek.setStatus(proyek.getStatus());
            getProyek.setDeveloper(proyek.getDeveloper());
    
            // Update the list of pekerja
            getProyek.setListPekerja(proyek.getListPekerja());
            
            proyekDb.save(getProyek);  // Persist the updated project
    
            return getProyek;
        }
        return null;
    }
    

    @Override
    public void deleteProyek(Proyek proyek) {
        proyek.setDeletedAt(new Date());
        proyekDb.save(proyek);
    }

    @Override
    public List<Proyek> getAllProyek(String nama, String status) {
        // Menggunakan Sort untuk mengurutkan berdasarkan nama proyek (case insensitive)
        Sort sortByNama = Sort.by(Sort.Order.by("nama").ignoreCase());
        
        // Menggunakan derived query method untuk pencarian proyek
        return proyekDb.findByNamaContainingIgnoreCaseAndStatusContainingIgnoreCase(nama, status, sortByNama);
    }

}