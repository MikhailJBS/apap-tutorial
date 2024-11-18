import 'dart:convert';
import 'developer.dart'; // Import the external Developer model
import 'pekerja.dart'; // Import the external Pekerja model

List<Proyek> proyekFromJson(String str) => List<Proyek>.from(json.decode(str).map((x) => Proyek.fromJson(x)));

String proyekToJson(List<Proyek> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Proyek {
    String id;
    String nama;
    String deskripsi;
    DateTime tanggalMulai;
    DateTime tanggalSelesai;
    String status;
    Developer developer; // Use imported Developer class
    List<Pekerja> listPekerja; // Use imported Pekerja class
    DateTime createdAt;
    DateTime updatedAt;
    dynamic deletedAt;

    Proyek({
        required this.id,
        required this.nama,
        required this.deskripsi,
        required this.tanggalMulai,
        required this.tanggalSelesai,
        required this.status,
        required this.developer,
        required this.listPekerja,
        required this.createdAt,
        required this.updatedAt,
        required this.deletedAt,
    });

    factory Proyek.fromJson(Map<String, dynamic> json) => Proyek(
        id: json["id"],
        nama: json["nama"],
        deskripsi: json["deskripsi"],
        tanggalMulai: DateTime.parse(json["tanggalMulai"]),
        tanggalSelesai: DateTime.parse(json["tanggalSelesai"]),
        status: json["status"],
        developer: Developer.fromJson(json["developer"]), // Parse using Developer model
        listPekerja: List<Pekerja>.from(json["listPekerja"].map((x) => Pekerja.fromJson(x))), // Parse using Pekerja model
        createdAt: DateTime.parse(json["createdAt"]),
        updatedAt: DateTime.parse(json["updatedAt"]),
        deletedAt: json["deletedAt"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "nama": nama,
        "deskripsi": deskripsi,
        "tanggalMulai": "${tanggalMulai.year.toString().padLeft(4, '0')}-${tanggalMulai.month.toString().padLeft(2, '0')}-${tanggalMulai.day.toString().padLeft(2, '0')}",
        "tanggalSelesai": "${tanggalSelesai.year.toString().padLeft(4, '0')}-${tanggalSelesai.month.toString().padLeft(2, '0')}-${tanggalSelesai.day.toString().padLeft(2, '0')}",
        "status": status,
        "developer": developer.toJson(),
        "listPekerja": List<dynamic>.from(listPekerja.map((x) => x.toJson())),
        "createdAt": createdAt.toIso8601String(),
        "updatedAt": updatedAt.toIso8601String(),
        "deletedAt": deletedAt,
    };
}
