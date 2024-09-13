package apap.tutorial.manpromanpro.controller;

import java.util.UUID;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.service.ProyekService;
import apap.tutorial.manpromanpro.controller.DTO.ProyekDTO;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProyekController {
    
    @Autowired
    private ProyekService proyekService;

    @GetMapping("/")
    private String home() {
        return "home";
    }

    private boolean validateDateInput(Date tanggalMulai, Date tanggalSelesai) {
        return tanggalMulai.before(tanggalSelesai);
    }

    @GetMapping("/proyek/add")
    public String addProyekForm(Model model) {
        var proyekDTO = new ProyekDTO();
        model.addAttribute("proyekDTO", proyekDTO);
        return "form-add-proyek";
    }

    @PostMapping("/proyek/add")
    public String addProyek(@ModelAttribute ProyekDTO proyekDTO, Model model) {
        UUID idProyek = UUID.randomUUID();

        if (validateDateInput(proyekDTO.getTanggalMulai(), proyekDTO.getTanggalSelesai())) {
        
        var proyek = new Proyek(
            proyekDTO.getDeveloper(),
            idProyek,
            proyekDTO.getNama(),
            proyekDTO.getStatus(),
            proyekDTO.getTanggalMulai(),
            proyekDTO.getTanggalSelesai()
        );

        proyekService.createProyek(proyek);

        model.addAttribute("id", proyek.getId());

        model.addAttribute("nama", proyek.getNama());

        return "success-add-proyek";
    }
        return "tanggal-salah";
    }

    @GetMapping("/proyek/viewall")
    public String listProyek(Model model) {
        List<Proyek> listProyek = proyekService.getAllProyek();
        model.addAttribute("listProyek", listProyek);
        return "viewall-proyek";
    }

    @GetMapping("/proyek/{id}")
    public String detailProyek(@PathVariable(value = "id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        model.addAttribute("proyek", proyek);
        return "view-proyek";
    }

    @GetMapping("/proyek/{id}/update")
    public String changeProyekForm(@PathVariable(value = "id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        var proyekDTO = new ProyekDTO();
        proyekDTO.setNama(proyek.getNama());
        proyekDTO.setDeveloper(proyek.getDeveloper());
        proyekDTO.setStatus(proyek.getStatus());
        proyekDTO.setTanggalMulai(proyek.getTanggalMulai());
        proyekDTO.setTanggalSelesai(proyek.getTanggalSelesai());
        proyekDTO.setId(proyek.getId());
        model.addAttribute("proyekDTO", proyekDTO);
        return "form-update-proyek";
    }

    @PostMapping("/proyek/{id}/update")
    public String changeProyek(
        @PathVariable(value = "id") UUID id,
        @ModelAttribute ProyekDTO proyekDTO,
        Model model
    ) {

        if (validateDateInput(proyekDTO.getTanggalMulai(), proyekDTO.getTanggalSelesai())) {

        var proyek = proyekService.getProyekById(id);
        proyek.setNama(proyekDTO.getNama());
        proyek.setDeveloper(proyekDTO.getDeveloper());
        proyek.setStatus(proyekDTO.getStatus());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyekService.updateProyek(proyek);
        model.addAttribute("id", proyek.getId());
        model.addAttribute("nama", proyek.getNama());
        return "success-update-proyek";
        }
        return "tanggal-salah";
    }
    
    @GetMapping("/proyek/{id}/delete")
    public String deleteProyek(@PathVariable(value = "id") UUID id, Model model) {
        Proyek proyek = proyekService.getProyekById(id);
        proyekService.deleteProyek(proyek);
        return "delete-proyek-success";
    }
}
