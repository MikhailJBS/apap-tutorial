package apap.tutorial.manpromanpro.model;
import apap.tutorial.manpromanpro.model.Status;

import java.util.UUID;
import java.util.Date;

public class Proyek {
    private UUID id;
    private String nama;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private Status status; 
    private String developer;

    public Proyek(String developer, UUID id, String nama, Status status, Date tanggalMulai, Date tanggalSelesai) {
        this.developer = developer;
        this.id = id;
        this.nama = nama;
        this.status = status;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
    }
    
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
}