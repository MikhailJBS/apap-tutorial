package apap.tutorial.manpromanpro.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.manpromanpro.dto.request.AddProyekRequestDTO;
import apap.tutorial.manpromanpro.dto.request.UpdateProyekRequestDTO;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.service.DeveloperService;
import apap.tutorial.manpromanpro.service.ProyekService;
import apap.tutorial.manpromanpro.service.PekerjaService;
import jakarta.validation.Valid;

@Controller
public class ProyekController {
    
    @Autowired
    private ProyekService proyekService;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private PekerjaService pekerjaService;

    enum StatusLevel {
        STARTED,
        ONGOING,
        FINISHED,
    }

    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/proyek/add")
    public String addProyekForm(Model model) {

        var proyekDTO = new AddProyekRequestDTO();

        model.addAttribute("proyekDTO", proyekDTO);
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("statusLevel", StatusLevel.values());
        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());

        return "form-add-proyek";
    }

    @PostMapping("/proyek/add")
    public String addProyek(@Valid @ModelAttribute AddProyekRequestDTO proyekDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
            model.addAttribute("responseMessage", "Error: " + errorMessage);
            return "response-proyek";
        }

        var proyek = new Proyek();
        proyek.setNama(proyekDTO.getNama());
        proyek.setDeskripsi(proyekDTO.getDeskripsi());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setStatus(proyekDTO.getStatus());
        proyek.setDeveloper(proyekDTO.getDeveloper());
        proyek.setListPekerja(proyekDTO.getListPekerja());

        proyekService.addProyek(proyek);
        
        model.addAttribute("responseMessage",
                String.format("Proyek %s dengan ID %s berhasil ditambahkan.", proyek.getNama(), proyek.getId()));

        return "response-proyek";
    }
    
    @PostMapping(value="/proyek/add", params={"addRow"})
    public String addRowDeveloperProyek(@ModelAttribute AddProyekRequestDTO addProyekRequestDTO, Model model) {
        if (addProyekRequestDTO.getListPekerja() == null || addProyekRequestDTO.getListPekerja().isEmpty()) {
            addProyekRequestDTO.setListPekerja(new ArrayList<>());
        }

        addProyekRequestDTO.getListPekerja().add(new Pekerja());

        model.addAttribute("proyekDTO", addProyekRequestDTO);
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-add-proyek";
    }

    @PostMapping(value="/proyek/add", params={"deleteRow"})
    public String deleteRowDeveloperProyek(@ModelAttribute AddProyekRequestDTO addProyekRequestDTO, @RequestParam(value = "deleteRow") int row, Model model) {
        addProyekRequestDTO.getListPekerja().remove(row);

        model.addAttribute("proyekDTO", addProyekRequestDTO);
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-add-proyek";
    }

    @GetMapping("/proyek/{id}")
    public String detailProyek(@PathVariable("id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);

        model.addAttribute("proyek", proyek);

        return "view-proyek";
    }

    @GetMapping("/proyek/{id}/update")
    public String updateProyek(@PathVariable("id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);

        var proyekDTO = new UpdateProyekRequestDTO();
        proyekDTO.setId(proyek.getId());
        proyekDTO.setNama(proyek.getNama());
        proyekDTO.setDeskripsi(proyek.getDeskripsi());
        proyekDTO.setTanggalMulai(proyek.getTanggalMulai());
        proyekDTO.setTanggalSelesai(proyek.getTanggalSelesai());
        proyekDTO.setStatus(proyek.getStatus());
        proyekDTO.setDeveloper(proyek.getDeveloper());

        model.addAttribute("proyekDTO", proyekDTO);
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-update-proyek";
    }

    @PostMapping("/proyek/update")
    public String updateProyek(@Valid @ModelAttribute UpdateProyekRequestDTO proyekDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
            model.addAttribute("responseMessage", "Error: " + errorMessage);
            return "response-proyek";
        }

        var proyekFromDTO = new Proyek();
        proyekFromDTO.setId(proyekDTO.getId());
        proyekFromDTO.setNama(proyekDTO.getNama());
        proyekFromDTO.setDeskripsi(proyekDTO.getDeskripsi());
        proyekFromDTO.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyekFromDTO.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyekFromDTO.setStatus(proyekDTO.getStatus());
        proyekFromDTO.setDeveloper(proyekDTO.getDeveloper());

        var proyek = proyekService.updateProyek(proyekFromDTO);

        model.addAttribute("responseMessage",
                String.format("Proyek %s dengan ID %s berhasil diupdate.", proyek.getNama(), proyek.getId()));

        return "response-proyek";
    }

    @GetMapping("/proyek/{id}/delete")
    public String deleteProyek(@PathVariable("id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        proyekService.deleteProyek(proyek);
    
        model.addAttribute("responseMessage",
                String.format("Proyek %s dengan ID %s berhasil dihapus.", proyek.getNama(), proyek.getId()));
    
        return "response-proyek";
    }    

    @GetMapping("/proyek/viewall")
    public String listProyek(
            @RequestParam(value = "nama", required = false, defaultValue = "") String nama,
            @RequestParam(value = "status", required = false, defaultValue = "") String status,
            Model model) {
        
        // Memanggil service untuk mendapatkan list proyek berdasarkan nama dan status
        List<Proyek> listProyek = proyekService.getAllProyek(nama, status);
        
        model.addAttribute("listProyek", listProyek);
        model.addAttribute("nama", nama); // Untuk menampilkan kembali input nama di search bar
        model.addAttribute("status", status); // Untuk menampilkan kembali pilihan status di dropdown


        return "viewall-proyek";
    }

}