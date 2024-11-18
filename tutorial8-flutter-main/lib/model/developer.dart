
class Developer {
    int id;
    String nama;
    String alamat;
    DateTime tanggalBerdiri;
    String email;
    DateTime createdAt;
    DateTime updatedAt;

    Developer({
        required this.id,
        required this.nama,
        required this.alamat,
        required this.tanggalBerdiri,
        required this.email,
        required this.createdAt,
        required this.updatedAt,
    });

    factory Developer.fromJson(Map<String, dynamic> json) => Developer(
        id: json["id"],
        nama: json["nama"],
        alamat: json["alamat"],
        tanggalBerdiri: DateTime.parse(json["tanggalBerdiri"]),
        email: json["email"],
        createdAt: DateTime.parse(json["createdAt"]),
        updatedAt: DateTime.parse(json["updatedAt"])
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "nama": nama,
        "alamat": alamat,
        "tanggalBerdiri": "${tanggalBerdiri.year.toString().padLeft(4, '0')}-${tanggalBerdiri.month.toString().padLeft(2, '0')}-${tanggalBerdiri.day.toString().padLeft(2, '0')}",
        "email": email,
        "createdAt": createdAt.toIso8601String(),
        "updatedAt": updatedAt.toIso8601String()
    };
}