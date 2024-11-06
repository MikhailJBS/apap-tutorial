import type { PekerjaInterface } from "./pekerja.interface";
import type { DeveloperInterface } from "./developer.interface";

export interface ProjectInterface {
    id: string,
    nama: string,
    deskripsi: string,
    status: string,
    tanggalMulai: Date,
    tanggalSelesai: Date,
    createdAt: Date,
    updatedAt: Date,
    developer: DeveloperInterface,
    listPekerja: PekerjaInterface[]
}

export interface ProjectRequestInterface {
    nama: string,
    deskripsi: string,
    status: string,
    tanggalMulai: string,
    tanggalSelesai: string,
    developerId: string,
}