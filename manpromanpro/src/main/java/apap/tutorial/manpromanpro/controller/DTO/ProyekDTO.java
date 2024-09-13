package apap.tutorial.manpromanpro.controller.DTO;
import apap.tutorial.manpromanpro.model.Status;

import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProyekDTO {
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    private UUID id;
    private String nama;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;
    private Status status;
    private String developer;

    public ProyekDTO(){

    }

    public ProyekDTO(UUID id, String nama, Date tanggalMulai, Date tanggalSelesai, Status status, String developer) {
        this.id = id;
        this.nama = nama;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.status = status;
        this.developer = developer;
    }
}
