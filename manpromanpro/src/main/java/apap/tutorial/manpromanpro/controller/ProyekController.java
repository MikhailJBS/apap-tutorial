package apap.tutorial.manpromanpro.controller;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/proyek/add")
    public String addProyekForm(Model model) {
        var proyekDTO = new ProyekDTO();
        model.addAttribute("proyekDTO", proyekDTO);
        return "form-add-proyek";
    }

    @PostMapping("/proyek/add")
    public String addProyek(@ModelAttribute ProyekDTO proyekDTO, Model model) {
        UUID idProyek = UUID.randomUUID();
        
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

    @GetMapping("/proyek/viewall")
    public String listProyek(Model model) {
        List<Proyek> listProyek = proyekService.getAllProyek();
        model.addAttribute("listProyek", listProyek);
        return "viewall-proyek";
    }

    @GetMapping("/proyek")
    public String detailProyek(@RequestParam(value = "id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        model.addAttribute("proyek", proyek);
        return "view-proyek";
    }   
    
}