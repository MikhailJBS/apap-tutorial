class Pekerja {
    int id;
    String nama;
    int usia;
    String pekerjaan;
    String biografi;
    DateTime createdAt;
    DateTime updatedAt;

    Pekerja({
        required this.id,
        required this.nama,
        required this.usia,
        required this.pekerjaan,
        required this.biografi,
        required this.createdAt,
        required this.updatedAt,
    });

    factory Pekerja.fromJson(Map<String, dynamic> json) => Pekerja(
        id: json["id"],
        nama: json["nama"],
        usia: json["usia"],
        pekerjaan: json["pekerjaan"],
        biografi: json["biografi"],
        createdAt: DateTime.parse(json["createdAt"]),
        updatedAt: DateTime.parse(json["updatedAt"])
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "nama": nama,
        "usia": usia,
        "pekerjaan": pekerjaan,
        "biografi": biografi,
        "createdAt": createdAt.toIso8601String(),
        "updatedAt": updatedAt.toIso8601String()
    };
}