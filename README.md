
  

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

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?

- Kolaborasi: Git memungkinkan banyak pengembang untuk bekerja secara bersamaan pada kode yang sama tanpa mengganggu pekerjaan satu sama lain melalui fitur branching dan merging.

- Tracking Perubahan: Setiap perubahan kode tercatat dengan detail, termasuk siapa yang melakukan perubahan dan kapan. Ini memudahkan pelacakan kesalahan dan rollback ke versi sebelumnya jika terjadi masalah.

- Parallel Development: Dengan sistem branching, tim bisa mengembangkan fitur baru atau memperbaiki bug di cabang terpisah tanpa mengganggu stabilitas kode utama.

- Backup Otomatis: Semua perubahan kode tersimpan dalam repository, sehingga kode tidak akan hilang jika terjadi masalah di komputer lokal.

- Integrasi dan Deployment: Git terintegrasi dengan berbagai tools untuk Continuous Integration (CI) dan Continuous Deployment (CD), memudahkan otomatisasi pengujian dan peluncuran aplikasi.

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

---

##  Tutorial 2

###  Apa yang telah saya pelajari hari ini
Pada Lab Tutorial 2 kali ini, saya telah mempelajari banyak hal. Salah satunya adalah terkait service interface dan implementation, serta kegunaannya. Selain itu, saya juga belajar banyak hal terkait best practices dalam menggunakan Spring Boot, seperti menggunakan DTO, service, controller, dan model. Saya juga belajar bagaimana cara menggunakan Thymeleaf untuk membuat form pada Spring Boot untuk menerima input dan bagaimana DTO bisa berguna di dalamnya.



###  Pertanyaan

1. Jelaskan kegunaan DTO pada proyek ini? Apakah bisa jika sebuah proyek tidak menggunakan DTO sama sekali?

DTO digunakan pada proyek ini untuk memindahkan data antar lapisan dalam aplikasi MVC tanpa menyertakan logika bisnis yang rumit. DTO biasanya hanya berisikan setter dan getter yang berfungsi untuk menyederhanakan dan mengontrol data. Pada proyek ini, DTO digunakan untuk memindahkan data dari form ke controller dan dari controller ke view.

(source: https://medium.com/@vishamberlal/understanding-data-transfer-objects-dto-in-spring-boot-ac06b575a1d5)

2. Apa itu UUID? Mengapa UUID digunakan? Pada proyek ini, UUID digunakan sebagai apa?

UUID (Universally Unique Identifier) merupakan identifier yang digunakan untuk mengidentifikasi objek secara unik melalui sebuah value berukuran 128-bit. UUID digunakan untuk menghindari konflik antara identifier yang sama pada objek yang berbeda karena unik, berbeda dengan nama yang bisa sama. Pada proyek ini, UUID digunakan sebagai identifier untuk proyek yang dibuat oleh pengguna.

(source: https://www.techtarget.com/searchapparchitecture/definition/UUID-Universal-Unique-Identifier)

3. Pada service, mengapa perlu ada pemisahan antara interface dan implementasinya? Apa keuntungan pemisahan tersebut?

Keuntungan paling utama adalah modularitas dan reusability. Dengan adanya pemisahan antara interface dan implementasi, kita bisa mengganti implementasi tanpa mengubah interface yang ada. Hal ini memungkinkan kita untuk mengganti implementasi tanpa mengubah kode yang sudah ada. Selain itu, pemisahan ini juga memungkinkan kita untuk menggunakan dependency injection dan membuat unit test lebih mudah. Selain itu, pemisahan ini juga membuat skalabilitas lebih baik dan cepat karena interface bisa dipakai lagi untuk implementasi yang berbeda.

(source: https://medium.com/@meet2sudhakar/why-we-need-a-service-layer-in-spring-boot-rest-api-application-db20e4b2a027#:~:text=This%20separation%20adheres%20to%20the,classes%2C%20you%20promote%20code%20reuse.)

4. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.

Annotation @Autowired merupakan implementasi dari konsep Dependency Injection. Dependency Injection adalah sebuah teknik dimana sebuah objek menerima semua dependensinya dari luar. Dengan menggunakan @Autowired, Spring akan mencari bean yang sesuai dengan tipe yang dideklarasikan dan menginject-nya ke dalam class tersebut. Jadi, setiap sebuah komponen dibuat, container spring akan langsung menyediakan seluruh dependencynya untuk komponen tersebut. Pada proyek ini, @Autowired digunakan untuk menginject service ke dalam controller. Dengan menggunakan @Autowired, Spring akan otomatis mencari dan menginisialisasi instance dari ProyekService dan mengasosiasikannya dengan field proyekService di controller. Contoh implementasinya adalah Ketika aplikasi dijalankan, Spring akan mencari instance yang sesuai untuk field proyekService.
Jika ada bean yang bernama proyekService, maka Spring akan mengasosiasikannya dengan field tersebut.

(source: https://gustavopeiretti.com/spring-boot-autowired-annotation/)

5. Apa perbedaan @GetMapping dan @PostMapping? Kapan @GetMapping dan @PostMapping digunakan?

Secara singkat, @GetMapping untuk menghandle request HTTP GET seperti saat mengambil data dari server tanpa mengubah data tersebut. Sedangkan PostMapping digunakan untuk menghandle request HTTP POST seperti saat mengirimkan data ke server untuk disimpan. @GetMapping digunakan ketika kita ingin mengambil data dari server, sedangkan @PostMapping digunakan ketika kita ingin mengirimkan data ke server.

(source: https://www.javaguides.net/2024/05/getmapping-vs-postmapping-in-spring-boot.html)

6. Apakah terdapat jenis mapping lain yang dapat digunakan? Jelaskan minimal 3 jenis mapping lain!

Ya, berikut adalah beberapa jenis mapping lain yang dapat digunakan:

@PutMapping
Digunakan untuk menghandle request HTTP PUT seperti saat mengupdate data yang sudah ada di server.

@DeleteMapping
Digunakan untuk menghandle request HTTP DELETE seperti saat menghapus data yang sudah ada di server.

@PatchMapping
Digunakan untuk menghandle request HTTP PATCH seperti saat mengupdate data yang sudah ada di server.

(source: https://www.javaguides.net/)

7. Jelaskan proses yang terjadi di controller, model, dan service pada proses create proyek, mulai dari fungsi addFormProyek hingga pengguna menerima halaman success-add-proyek.

Pertama, pengguna akan mengakses halaman form-add-proyek.html yang merupakan form untuk menambahkan proyek. Controller akan mengirimkan objek proyekDTO kepada form itu yang akan kita isi attribut2nya. Ketika tombol submit ditekan, maka akan terjadi POST request yang akan ditangani oleh method @PostMapping di controller yang pada kode ini adalah method addProyek yang akan memproses inputan dari form tersebut. ProyekDTO yang diisi oleh form akan divalidasi dan jika valid, maka akan diubah menjadi objek Proyek melalui proyekService.createProyek(proyek). Ketika tidak terjadi error, maka akan lanjut ke kode selanjutnya yaitu controller akan menambahkan attribute nama dan id proyek ke model dan mengembalikan view success-add-proyek.html yang akan menampilkan halaman sukses menambahkan proyek.

(source: https://www.javaguides.net/)

8. Jelaskan mengenai th:object!

`th:object` adalah atribut yang digunakan untuk mengikat objek model ke dalam form. Atribut ini digunakan untuk menghubungkan objek model dengan form sehingga form dapat mengakses atribut objek model tersebut. Dengan menggunakan `th:object`, kita bisa mengakses atribut objek model dengan menggunakan `th:field` pada form. Lalu ekspresi asterisk `*{}` digunakan untuk mengakses atribut objek model yang telah dihubungkan dengan form tadi.

(source: https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)

9. Jelaskan mengenai th:field!

`th:field` merupakan atribut yang digunakan untuk menghubungkan field dari objek model dengan form. Atribut ini digunakan untuk mengakses field dari objek model yang telah dihubungkan dengan form. Dengan menggunakan `th:field`, kita bisa mengakses field dari objek model tersebut. Lalu ekspresi asterisk `*{}` digunakan untuk mengakses field dari objek model yang telah dihubungkan dengan form tadi.

(source: https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)
 
10. Apakah terdapat jenis “th” lainnya? Jelaskan minimal 3 jenis “th” lainnya yang kamu temukan!

Ya, berikut adalah beberapa jenis "th" lainnya yang dapat digunakan:

`th:text`
Digunakan untuk menampilkan teks dari atribut objek model yang telah dihubungkan dengan form.

`th:each`
Digunakan untuk melakukan iterasi pada objek model yang telah dihubungkan dengan form.

`th:if` dan ``th:unless`
Digunakan untuk melakukan operasi kondisional pada objek model yang telah dihubungkan dengan form.

(source: https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)