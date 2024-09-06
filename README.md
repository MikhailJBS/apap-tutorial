
  

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
 
4. Apa itu Gradle? Mengapa kita menggunakan Gradle? Apakah ada alternatif dari Gradle?

Gradle merupakan tool built automation berbasis java yang digunakan untuk build, deploy, bahkan test aplikasi berbasis java lainnya. Pada aplikasi Spring, Gradle digunakan untuk mengelola dependency yang dibutuhkan aplikasi Spring juga.

Gradle digunakan karena merupakan salah satu tool paling banyak digunakan di dunia untuk pengembangan aplikasi java. Namun ada beberapa alternatif dari gradle yakni Maven atau Ant yang bekerja serupa

5. Apa perbedaan dari @RequestParam dan @PathVariable?

@RequestParam digunakan untuk mengambil parameter dari query string pada url. @RequestParam cocok untuk menangani input seperti filter atau sorting.

@PathVariabel digunakan untuk mengambil parameter dari bagian path URL. Hal ini digunakan ketika paramter menjadi bagian dari URI.

Perbedaan utamanya adalah:
**@RequestParam** mengambil nilai dari query string atau form data.
**@PathVariable** mengambil nilai dari path (bagian URL).

6. Apa itu DTO? Apakah DTO harus selalu digunakan? Kapan sebaiknya kita menggunakan DTO?

DTO adalah objek yang digunakan untuk memindahkan data antar lapisan dalam aplikasi MVC tanpa menyertakan logika bisnis yang rumit. DTO biasanya hanya berisikan setter dan getter yang berfungsi untuk menyederhanakan dan mengontrol data.

DTO tidak selalu harus digunakan, tapi beberapa kasus DTO sangat berguna dan bahkan diperlukan. Pada aplikasi sederhana dan statis, DTO tidak perlu digunakan, tapi dalam aplikasi yang besar dan kompleks maka DTO sangat dapat membantu.

DTO digunakan pada berbagai macam saat, salah satunya yang paling penting adalah pada saat transformasi data, membuat API publik, serta untuk memudahkan perpindahan data antar layer.

7. Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/roman-converter/MMXXIV sampai dengan muncul keluarannya di browser!

Pertama, request dari browser diteruskan/dipetakan ke method yang sesuai dalam file controller berdasarkan mapping URL yang ada, jika tidak ada maka error. Pada kasus ini tidak error karena ada dan polanya cocok dengan method `romanConverterWithPathVariable` dengan romawi MMXXIV sebagai parameter path. Selanjutnya maka akan mengambil nilai path variable tersebut dari url dan dimasukan ke dalam parameter method yang sama untuk memanggil method `getRomanConverterPage`dengan param `roman = MMXXIV` untuk diproses.

Selanjutnya, variabel tersebut akan dimasukan ke dalam objek `romanConverter` baru dan akan divalidasi apakah sesuai format angka romawi apa tidak, jika ya, maka objek tersebut akan diteruskan kepada `view-conversion-result.html` yang nantinya akan ditampilkan dengan cara menggunakan method yang ada untuk class `romanConverter` yaitu `.getRoman()` untuk mendapatkan romawi nya, dan `.convertRomanToDecimal` untuk mendapatkan angka konversinya.

8. Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/roman-converter?roman=MMXXIV sampai dengan muncul keluarannya di browser!

Pertama, request dari browser diteruskan/dipetakan ke method yang sesuai dalam file controller berdasarkan mapping URL yang ada, jika tidak ada maka error. Pada kasus ini tidak error karena ada dan dengan parameter query roman=MMXIV yang merupakan contoh dari ReqParam yang mengikat nilai `roman` dengan query string MMXIV.

Setelah parameter query diambil, method `romanConverterWithReqParam` memanggil method `getRomanConverterPage` dan meneruskan parameter roman untuk diproses disana. Selanjutnya parameter akan diproses, pertama di cek validasi dari parameter, setelah itu disimpan sebagai atribut model dengan key `romanConverter`. Selanjutnya, method `getRomanConverterPage` mereturn `view-conversion-result.html` dan meneruskan  ke html tersebut dengan cara `mode.addAtribute()` yang pada kasus ini merupakan objek romanConverter. Pada HTML, objek digunakan dan dilakukan beberapa fungsi untuk mendapatkan romawi aslinya serta angka yang telah di convert.

9. Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/convert sampai dengan muncul keluarannya di browser!

Sama seperti sebelumnya, URL akan diproses dan diteruskan pada controller. Pada kali ini, pattern cocok dengan method `getRomanConverterWithView` yang akan menggunakan RequestDTO untuk membantu dalam pengisian form dengan cara `model.addAttribute()`. Selanjutnya, `form.html` akan dibuka dan bisa diisi. Setelah diisi dan di click, maka akan terdapat POST request yang dikirimkan ke server dengan input.

Controller akan memproses inputnya dan menangani POST dengan method `postRomanConverterWithView` dimana input akan divalidasi sebelum diubah menjadi RomanConverter sama seperti proses sebelumnya. Selanjutnya hasil konversi akan dirender kembali oleh `view-conversion-result.html` dengan attribut yang sama seperti proses lainnya diatas.
 
10. Pada Tutorial 1 - Panduan bagian Spring Boot > VS Code / IDE > langkah 4, kita mendapati error. Apa penyebabnya?

Error tersebut terjadi pada saat pertama kita menginisiasi aplikasi Spring. Ada beberapa alasan error tersebut terjadi dan berikut adalah dua alasan utama:

- No Static Resources: Terdapat tulisan seperti itu di layar error. Hal ini dikarenakan tidak adanya HTML ataupun CSS yang bisa dirender oleh view engine.
- Routing/Mapping: Pada saat kita menginisiasi aplikasi, belum ada routing atau mapping apa apa pada controller, hal ini membuat aplikasi tidak tahu apa yang harus diakses di homepage tersebut dan memunculkan error page.   

###  Apa yang belum saya pahami
Tutorial pada kali ini sangat baik karena saya mengerti banyak hal terkait pengembangan aplikasi Spring dengan singkat. Namun ada beberapa hal yang belum saya pahami.
-  [ ] Kenapa saya menggunakan Lombok?
-  [ ] Apa yang dimaksud kode boilerplate dan mengapa harus dikurangi?