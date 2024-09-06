
#  Tutorial APAP

  

##  Authors

  

*  **Mikhail Haritz** - *2206082764* - *A*

---

##  Tutorial 1

###  Apa yang telah saya pelajari hari ini

Pada lab hari ini saya telah mempelajari beberapa dasar-dasar dari pengembangan perangkat lunak menggunakan SpringBoot serta GitLab. Saya mempelajari cara banyak terkait pengembangan dengan SpringBoot dimana saya mempelajari berbagai hal penting terutama terkait MVC dimana ada templates sebagai view untuk HTML, directory Controller untuk aspek controller dari aplikasi, serta model sebagai backend dari aplikasi itu sendiri. Saya juga mempelajari cara untuk membuat form dengan DTO.

###  GitLab

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

Issue Tracker merupakan salah satu tool paling dibutuhkan dalam pengembangan. Terdapat banyak sekali masalah yang dapat diatasi oleh Issue Tracker, beberapa diantaranya yang paling penting adalah terkait pengubahan kode dan adanya bug. Dengan adanya issue tracker, mengendalikan kedua hal tersebut akan menjadi jauh lebih mudah, terutama jika dalam lingkungan pengembangan perangkat lunak dalam grup.

2. Saat membuat Merge Request, terdapat 2 merge options yang diceklis. Jelaskan fungsi dari kedua pilihan tersebut! Mengapa hanya squash yang diceklis?

Terdapat 2 merge options.

Delete Source Branch: Hal ini berarti bahwa jika nanti kita melakukan merge, maka branch yang akan di merge akan dihapus ketika perubahan pada branch itu telah di merge ke branch utama/yang akan di merge

Squash Commits: Opsi ini adalah opsi untuk menggabungkan beberapa commit menjadi satu commit. Hal ini digunakan untuk merapihkan history branch sebelum di merge ke main.

###  Spring

4. Apa itu library & dependency?

Library & dependency merupakan dua konsep yang sangat mirip. Library adalah sekumpulan kode yang dapat membantu dan mempersingkat proses programming kita dan bersifat reusable. Pada Spring, library kerap digunakan untuk hal-hal seperti logging, koneksi ke database, dll. Contoh nyata library yang digunakan pada sebuah aplikasi Spring adalah Spring Security. Dependency merupakan kumpulan library Spring yang dibutuhkan untuk aplikasi agar bisa berjalan, sesuai namanya, aplikasi akan dependent akan beberapa dependency untuk berjalan.

5. Apa itu Gradle? Mengapa kita menggunakan Gradle? Apakah ada alternatif dari Gradle?

Gradle merupakan tool built automation berbasis java yang digunakan untuk build, deploy, bahkan test aplikasi berbasis java lainnya. Pada aplikasi Spring, Gradle digunakan untuk mengelola dependency yang dibutuhkan aplikasi Spring juga.

Gradle digunakan karena merupakan salah satu tool paling banyak digunakan di dunia untuk pengembangan aplikasi java. Namun ada beberapa alternatif dari gradle yakni Maven atau Ant yang bekerja serupa

  

###  Apa yang belum saya pahami

Tutorial pada kali ini sangat baik karena saya mengerti banyak hal terkait pengembangan aplikasi Spring dengan singkat. Namun ada beberapa hal yang belum saya pahami.

-  [ ] Kenapa saya menggunakan Lombok?

-  [ ] Apa yang dimaksud kode boilerplate dan mengapa harus dikurangi?