package apap.tutorial.manpromanpro.service;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import apap.tutorial.manpromanpro.model.Proyek;
import org.springframework.stereotype.Service;

@Service
public class ProyekServiceImpl implements ProyekService {
    private List<Proyek> listProyek = new ArrayList<Proyek>();

    @Override
    public void createProyek(Proyek proyek) {
        listProyek.add(proyek);
    }

    @Override
    public List<Proyek> getAllProyek() {
        return listProyek;
    }

    @Override
    public Proyek getProyekById(UUID id) {
        for (Proyek proyek : listProyek) {
            if (proyek.getId().equals(id)) {
                return proyek;
            }
        }
        return null;
    }
}
