package apap.tutorial.manpromanpro.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.repository.PekerjaDb;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PekerjaServiceImpl implements PekerjaService {
    @Autowired
    PekerjaDb pekerjaDb;

    @Override
    public Pekerja addPekerja(Pekerja pekerja) {
        return pekerjaDb.save(pekerja);
    }

    @Override
    public List<Pekerja> getAllPekerja() {
        return pekerjaDb.findAll(Sort.by(Sort.Order.asc("nama").ignoreCase()));
    }

    @Override
    public void deleteListPekerja(List<Pekerja> listPekerja) {
        var pekerjaToDelete = new ArrayList<Pekerja>();

        if (listPekerja != null) {
            for (Pekerja pekerja : listPekerja) {
                if (pekerja.getListProyek() == null || pekerja.getListProyek().isEmpty()) {
                    pekerjaToDelete.add(pekerja);
                }
            }
        }

        for (Pekerja pekerja : pekerjaToDelete) {
            pekerja.setDeletedAt(new Date());
            pekerjaDb.save(pekerja);
        }
    }
    
}
