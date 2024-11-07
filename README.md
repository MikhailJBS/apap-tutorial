
  

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

---

##  Tutorial 3

###  Apa yang telah saya pelajari hari ini
Pada Lab Tutorial 3 kali ini, saya telah mempelajari banyak hal terkait penggunaan database pada Spring Boot. Saya mempelajari bagaimana cara membuat database dengan Docker, bagaimana cara menghubungkan database dengan Spring Boot, serta bagaimana cara membuat relasi antar tabel di database. Saya juga mempelajari cara menggunakan JPA Repository untuk mengakses data dari database dan melakukan operasi CRUD, dan melakukan data processing lebih lanjut.


###  Pertanyaan

1. Jelaskan seluruh configuration properties (application, datasource, jpa) yang terdapat di dalam file application.yml!

Application:
* spring.application.name: Nama aplikasi Spring Boot, pada proyek ini bernama manpromanpro

Datasource:
* spring.datasource.url: URL dari database yang digunakan, pada proyek ini menggunakan database yang kita luncurkan dengan docker pada port 15001 dengan database yang bernama manpromanpro
* spring.datasource.username: Username dari database yang digunakan, pada proyek ini menggunakan username default postgres
* spring.datasource.password: Password dari database yang digunakan, pada proyek ini menggunakan password default postgres

JPA:
* spring.jpa.hibernate.ddl-auto: Mode DDL yang digunakan, pada proyek ini menggunakan mode create yang menyebabkan setiap kali aplikasi dijalankan, tabel akan dibuat ulang
* spring.jpa.properties.hibernate.dialect: Dialect Hibernate yang digunakan, pada proyek ini menggunakan dialect PostgreSQL
* spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation: Konfigurasi Hibernate yang digunakan, pada proyek ini menggunakan konfigurasi true

2. Pada tutorial ini, kita menggunakan docker container untuk membentuk database. Apa keuntungan menggunakan docker container dibandingkan tanpa menggunakannya?

Berikut adalah beberapa keuntungan menggunakan docker container dibandingkan tanpa menggunakannya:
- Portability: Docker container dapat dijalankan di berbagai platform yang mendukung Docker, sehingga memudahkan dalam deployment aplikasi.
- Scalability: Docker container memungkinkan untuk membuat dan menghapus container dengan cepat, sehingga memudahkan dalam scaling aplikasi.
- Isolation: Docker container memungkinkan untuk menjalankan aplikasi dalam lingkungan yang terisolasi, sehingga meminimalisir konflik antar aplikasi.
- Easy Configuration: Docker container memungkinkan untuk membuat dan mengatur container dengan mudah, sehingga memudahkan dalam konfigurasi aplikasi.
- Automation & CI/CD: Docker container memungkinkan untuk membuat dan mengatur container secara otomatis, sehingga memudahkan dalam otomatisasi deployment aplikasi.


3. Jelaskan secara singkat apa itu dan kegunaan dari annotation dibawah ini
(@Entity, @Table, @Column)

* @Entity: Annotation ini digunakan untuk menandai bahwa sebuah class merupakan sebuah entity dalam ERD, sehingga class tersebut akan dipetakan ke tabel di dalam database. Kegunaannya adalah untuk memberitahu JPA bahwa class tersebut merupakan entity dan akan dikelola oleh JPA.

* @Table: Annotation ini digunakan untuk menandai bahwa sebuah class akan dijadikan sebagai sebuah tabel di database, dan digunakan untuk mengatur nama tabel yang akan dipetakan di database. Kegunaannya adalah untuk memberi nama atau mengatur nama tabel. Tanpa anotasi ini, JPA akan menggunakan nama class sebagai nama tabel tersebut

* @Column: Annotation ini digunakan untuk menandai bahwa sebuah field akan dijadikan sebagai sebuah kolom di database, dan digunakan untuk mengatur nama kolom yang akan dijadikan.


4. Pada model, kita dapat menentukan relasi antarmodel dengan menggunakan JPA Annotation. Sebutkan seluruh JPA Annotation yang dapat digunakan untuk mendefinisikan relasi antarmodel beserta perbedaannya!

Berikut adalah beberapa JPA Annotation yang dapat digunakan untuk mendefinisikan relasi antarmodel:

* @OneToOne: Annotation ini digunakan untuk mendefinisikan relasi one-to-one antarmodel. Perbedaannya adalah bahwa setiap instance dari entity akan memiliki satu instance dari entity lainnya. Contohnya: Setiap User memiliki satu Profile.

* @OneToMany: Annotation ini digunakan untuk mendefinisikan relasi one-to-many antarmodel. Perbedaannya adalah bahwa setiap instance dari entity akan memiliki banyak instance dari entity lainnya. Contohnya: Seorang Author memiliki banyak Book. 

* @ManyToOne: Annotation ini digunakan untuk mendefinisikan relasi many-to-one antarmodel. Perbedaannya adalah bahwa banyak instance dari entity akan memiliki satu instance dari entity lainnya. Contohnya: Banyak Book ditulis oleh satu Author.

* @ManyToMany: Annotation ini digunakan untuk mendefinisikan relasi many-to-many antarmodel. Perbedaannya adalah bahwa banyak instance dari entity akan memiliki banyak instance dari entity lainnya. Contohnya: Banyak Student bisa mengambil banyak Course.


5. Pada model Proyek, terdapat annotation @JoinTable seperti berikut:
```
@JoinTable(
    name = "pekerja_proyek",
    joinColumns = @JoinColumn(name = "id_proyek"),
    inverseJoinColumns = @JoinColumn(name = "id_peekerja"))
List<Pekerja> listPekerja;
```
Jelaskan kegunaan annotation tersebut beserta seluruh parameternya!

* `@JoinTable`: digunakan untuk menentukan tabel penghubung yang mengelola hubungan antara dua entitas. Dalam relasi Many-to-Many, setiap entitas akan memiliki banyak hubungan dengan entitas lainnya, sehingga diperlukan tabel join untuk menyimpan hubungan tersebut.

Parameter:
* `name`: digunakan untuk menentukan nama tabel join yang akan digunakan. Pada proyek ini, nama tabel join yang digunakan adalah "pekerja_proyek".

* `joinColumns`: digunakan untuk menentukan kolom yang akan dijadikan sebagai foreign key dari entitas yang memiliki relasi. Pada proyek ini, kolom "id_proyek" akan dijadikan sebagai foreign key dari entitas Proyek.

* `inverseJoinColumns`: digunakan untuk menentukan kolom yang akan dijadikan sebagai foreign key dari entitas lain yang memiliki relasi. Pada proyek ini, kolom "id_pekerja" akan dijadikan sebagai foreign key dari entitas Pekerja.

* `List<Pekerja> listPekerja`: digunakan untuk menyimpan daftar pekerja yang bekerja pada proyek tersebut.


6. Jelaskan mengapa kita harus membentuk JPA Repository!

JPA Repository digunakan untuk mengakses dan memanipulasi data dari database. Dengan menggunakan JPA Repository, kita dapat melakukan operasi CRUD (Create, Read, Update, Delete) pada data dengan mudah dan efisien.

JPA Repository menyediakan berbagai method yang dapat digunakan untuk mengakses data dari database, sehingga memudahkan dalam pengembangan aplikasi. Selain itu, JPA Repository juga menyediakan fitur-fitur seperti pagination, sorting, dan query methods yang dapat digunakan untuk mengakses data dengan lebih efisien.

Beberapa keuntungan dari menggunakan JPA Repository adalah: Tidak perlu menulis query SQL secara manual, Operasi CRUD tanpa adanya boilerplate code, dukungan yang baik untuk pembuatan Custom Query.

7. Sebutkan beberapa alternatif dari Java Faker!

Beberapa alternatif dari Java Faker adalah:
* RandomBeans (EasyRandom): Library yang digunakan untuk membuat objek Java secara acak berdasarkan tipe dan struktur kelas untuk kebutuhan pengujian.
* MockNeat: Library yang digunakan untuk membuat data palsu secara acak untuk pengujian dan pengembangan.
* DataFactory: Library yang digunakan untuk membuat data palsu secara acak untuk pengujian dan pengembangan. Digunakan untuk mengisi database dengan data test atau pembuatan mock object.
* JFairy: Library yang digunakan untuk membuat data palsu secara acak dengan mudah dan nyaman.
* Chance.js: Library yang digunakan untuk membuat data palsu secara acak untuk pengujian dan pengembangan yang dibuat untuk aplikasi berbasis JavaScript.

---

##  Tutorial 4

###  Apa yang telah saya pelajari hari ini
Pada lab tutorial 4 kali ini, saya telah mempelajari banyak hal terkait penggunaan Thymeleaf dan Spring Boot. Saya mempelajari bagaimana cara membuat form pada Spring Boot dengan Thymeleaf, bagaimana cara mengakses data dari database dengan JPA Repository, serta bagaimana cara menampilkan data dari database ke dalam view dengan Thymeleaf. Saya juga mempelajari cara menggunakan Thymeleaf untuk membuat form, dynamic form, menampilkan data, dan melakukan operasi CRUD pada data. Selain itu, salah satu yang paling penting dari tutorial ini adalah pemisahan antara db saat testing dan db saat production. Saya juga mempelajari prinsip modularity dan reusability dalam bentuk penggunaan fragment pada Thymeleaf.


###  Pertanyaan

1. Jelaskan apa yang terjadi ketika pengguna mengakses URL yang tidak valid? (Contoh: localhost:8080/abcde)

Pada tutorial ini, kita ditugaskan untuk membuat error page untuk kode error 404 dan 500. Jika pengguna mengakses URL yang tidak valid seperti contoh localhost:8080/abcde, maka Spring Boot akan menangani request tersebut dan mengembalikan error page yang telah kita buat. Error page tersebut akan menampilkan pesan error yang sesuai dengan kode error yang dihasilkan. Pada kasus ini, jika pengguna mengakses URL yang tidak valid, maka Spring Boot akan mengembalikan error page dengan pesan error "Halaman Tidak Ditemukan".

(source: https://www.baeldung.com/spring-boot-custom-error-page)

2. Apa yang dimaksud dengan spring profiles dan apa kegunaannya?

Spring Profiles adalah fitur yang digunakan untuk mengatur konfigurasi aplikasi berdasarkan environment yang berbeda. Dengan menggunakan Spring Profiles, kita dapat mengatur konfigurasi aplikasi berdasarkan environment seperti development, testing, dan production. Kegunaannya adalah untuk memisahkan konfigurasi aplikasi berdasarkan environment yang berbeda, sehingga memudahkan dalam pengembangan dan deployment aplikasi.

Pada tutorial ini, kita menggunakan Spring Profiles untuk memisahkan konfigurasi database berdasarkan environment yang berbeda. Dengan menggunakan Spring Profiles, kita dapat mengatur konfigurasi database berdasarkan environment development dan production. Pemisahan ini dilakukan untuk memisahkan database yang digunakan saat testing dan saat production untuk mempermudah dalam pengembangan, terutama dalam pengetesan.

(source: https://www.baeldung.com/spring-profiles)

3. Jelaskan cara kerja “th:include” dan juga “th:replace” dan apa hubungan antar keduanya?

`th:include` digunakan untuk menyisipkan fragment ke dalam template. Fragment adalah bagian dari template yang dapat digunakan kembali di berbagai template. Dengan menggunakan `th:include`, kita dapat menyisipkan fragment ke dalam template utama. `th:include` digunakan untuk menyisipkan fragment ke dalam template tanpa mengganti konten yang ada di dalam template.

`th:replace` digunakan untuk mengganti konten yang ada di dalam template dengan fragment. Dengan menggunakan `th:replace`, kita dapat mengganti konten yang ada di dalam template dengan fragment. `th:replace` digunakan untuk mengganti konten yang ada di dalam template dengan fragment.

Hubungan antara `th:include` dan `th:replace` adalah keduanya digunakan untuk menyisipkan fragment ke dalam template. Perbedaannya adalah `th:include` digunakan untuk menyisipkan fragment ke dalam template tanpa mengganti konten yang ada di dalam template, sedangkan `th:replace` digunakan untuk mengganti konten yang ada di dalam template dengan fragment.

(source: https://stackoverflow.com/questions/37103958/difference-between-thymeleaf-include-and-replace)

4. Apakah ada format lain dalam menuliskan konfigurasi pada spring boot selain dalam format yml? Jika ada, sebutkan dan jelaskan perbedaannya!

Selain dalam format yml, konfigurasi pada Spring Boot juga dapat dituliskan dalam format properties. Format properties adalah format konfigurasi yang menggunakan file .properties untuk menuliskan konfigurasi aplikasi. Perbedaannya adalah format yml menggunakan file .yml untuk menuliskan konfigurasi aplikasi, sedangkan format properties menggunakan file .properties untuk menuliskan konfigurasi aplikasi.

Beberapa perbedaan antara format yml dan properties adalah:
- Format yml menggunakan file .yml untuk menuliskan konfigurasi aplikasi, sedangkan format properties menggunakan file .properties untuk menuliskan konfigurasi aplikasi.
- Format yml menggunakan indentasi untuk menentukan struktur konfigurasi, sedangkan format properties menggunakan key-value pairs untuk menentukan konfigurasi.

(source: https://www.baeldung.com/spring-boot-yaml-vs-properties)

5. Mengapa kita memerlukan dua environment yang berbeda (dev & prod), dan apa implikasinya jika tidak dibuat demikian?

Kita memerlukan dua environment yang berbeda (development dan production) untuk memisahkan konfigurasi aplikasi berdasarkan environment yang berbeda. Dengan menggunakan dua environment yang berbeda, kita dapat mengatur konfigurasi aplikasi berdasarkan environment development dan production. Implikasinya jika tidak dibuat demikian adalah konfigurasi aplikasi akan sulit untuk diatur dan membingungkan, karena konfigurasi aplikasi akan bercampur antara environment development dan production. Dengan menggunakan dua environment yang berbeda, kita dapat memisahkan konfigurasi aplikasi berdasarkan environment yang berbeda, sehingga memudahkan dalam pengembangan dan deployment aplikasi. Pemisahan ini akan sangat membantu dalam pengetesan menggunakan db serta mempermudah dalam pengembangan, terutama dalam pengetesan.

(source: https://www.baeldung.com/spring-profiles)

6. Apa saja error yang mungkin terjadi pada aplikasi yang sudah dibuat? Berikan penjelasan dan sebutkan minimal dua jenis error.

Dua error yang mungkin terjadi pada aplikasi yang sudah dibuat adalah:
- Error 404: Not Found. Error ini terjadi ketika pengguna mengakses URL yang tidak valid atau tidak ditemukan. Error ini disebabkan karena URL yang diakses tidak sesuai dengan URL yang ada di aplikasi. Misal pengguna mengakses URL yang tidak valid seperti localhost:8080/abcde.
- Error 500: Internal Server Error. Error ini terjadi ketika terjadi kesalahan pada server saat memproses request dari pengguna. Error ini disebabkan karena terjadi kesalahan pada server saat memproses request dari pengguna. Misal terjadi kesalahan pada server saat memproses request dari pengguna.

(source: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

---

##  Tutorial 5

###  Apa yang telah saya pelajari hari ini
Pada lab tutorial 5 kali ini, saya telah mempelajari banyak hal terkait penggunaan RESTful API pada Spring Boot. Saya mempelajari bagaimana cara membuat RESTful API dengan Spring Boot, bagaimana cara mengakses data dari database dengan JPA Repository, serta bagaimana cara menampilkan data dari database ke dalam RESTful API. Saya juga mempelajari cara menggunakan Postman untuk melakukan request ke RESTful API, serta bagaimana cara melakukan operasi CRUD pada data melalui RESTful API. Selain itu, saya juga mempelajari cara melakukan error handling pada RESTful API dengan menggunakan @ControllerAdvice dan @RestControllerAdvice.

###  Pertanyaan

1. Sebelumnya kita sudah mengetahui pada saat mengirimkan sebuah HTTP Response perlu memasukkan kode status yang berperan memberikan informasi dari response yang akan diterima. Untuk kode status sendiri dikelompokkan menjadi 5 jenis yaitu kode status dengan awalan 1xx, 2xx, 3xx, 4xx, dan 5xx. Coba jelaskan arti dari masing-masing kode status (selain 2xx) dan kapan kita harus menggunakan kode status tersebut!.

Kode status HTTP dibagi menjadi 5 kategori berdasarkan rentang angka pertama dari kode status tersebut:

- 1xx - Informational: Kode status ini digunakan untuk memberikan informasi bahwa request diterima dan sedang diproses. Kode status ini digunakan untuk memberikan informasi bahwa request diterima dan sedang diproses. Contoh: 100 Continue, 101 Switching Protocols.

- 2xx - Success: Kode status ini digunakan untuk memberikan informasi bahwa request berhasil diproses. Kode status ini digunakan untuk memberikan informasi bahwa request berhasil diproses. Contoh: 200 OK, 201 Created.

- 3xx - Redirection: Kode status ini digunakan untuk memberikan informasi bahwa request harus dialihkan ke lokasi lain. Kode status ini digunakan untuk memberikan informasi bahwa request harus dialihkan ke lokasi lain. Contoh: 301 Moved Permanently, 302 Found.

- 4xx - Client Error: Kode status ini digunakan untuk memberikan informasi bahwa terjadi kesalahan pada sisi klien. Kode status ini digunakan untuk memberikan informasi bahwa terjadi kesalahan pada sisi klien. Contoh: 400 Bad Request, 401 Unauthorized.

- 5xx - Server Error: Kode status ini digunakan untuk memberikan informasi bahwa terjadi kesalahan pada sisi server. Kode status ini digunakan untuk memberikan informasi bahwa terjadi kesalahan pada sisi server. Contoh: 500 Internal Server Error, 501 Not Implemented.

(Source: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

2. Jelaskan fungsi dari anotasi @JsonInclude, @JsonFormat, dan @JsonIgnore!.

Berikut adalah penjelasan dari masing-masing anotasi:

- @JsonInclude: Annotation ini digunakan untuk mengatur bagaimana Jackson mengabaikan properti yang memiliki nilai null saat serialisasi objek menjadi JSON. Kegunaannya adalah untuk mengatur bagaimana Jackson mengabaikan properti yang memiliki

- @JsonFormat: Annotation ini digunakan untuk mengatur format dari properti saat serialisasi objek menjadi JSON. Kegunaannya adalah untuk mengatur format dari properti saat serialisasi objek menjadi JSON.

- @JsonIgnore: Annotation ini digunakan untuk mengabaikan properti saat serialisasi objek menjadi JSON. Kegunaannya adalah untuk mengabaikan properti saat serialisasi objek menjadi JSON.

(Source: https://www.baeldung.com/jackson-annotations)

3. Berikan dua contoh tipe requestBody dan dua contoh tipe responseBody yang dapat digunakan pada RESTful API selain tipe application/json! Serta jelaskan juga kapan sebaiknya menggunakan tipe tersebut!.

Berikut adalah dua contoh tipe requestBody dan dua contoh tipe responseBody yang dapat digunakan pada RESTful API selain tipe application/json:

- Tipe RequestBody:
  - application/xml: Tipe ini digunakan untuk mengirim data dalam format XML. Sebaiknya digunakan jika aplikasi membutuhkan data dalam format XML.
  - application/x-www-form-urlencoded: Tipe ini digunakan untuk mengirim data dalam format form-urlencoded. Sebaiknya digunakan jika aplikasi membutuhkan data dalam format form-urlencoded.

- Tipe ResponseBody:
    - application/xml: Tipe ini digunakan untuk mengirim data dalam format XML. Sebaiknya digunakan jika aplikasi membutuhkan data dalam format XML.
    - application/x-www-form-urlencoded: Tipe ini digunakan untuk mengirim data dalam format form-urlencoded. Sebaiknya digunakan jika aplikasi membutuhkan data dalam format form-urlencoded.

(Source: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type)

4. Jelaskan fungsi dari anotasi @ControllerAdvice dan @RestControllerAdvice!.

Berikut adalah penjelasan dari masing-masing anotasi:

- @ControllerAdvice: Annotation ini digunakan untuk memberikan global exception handling pada aplikasi Spring. Kegunaannya adalah untuk memberikan global exception handling pada aplikasi Spring.

- @RestControllerAdvice: Annotation ini digunakan untuk memberikan global exception handling pada aplikasi Spring yang mengembalikan response dalam format JSON. Kegunaannya adalah untuk memberikan global exception handling pada aplikasi Spring yang mengembalikan response dalam format JSON.

(Source: https://www.baeldung.com/exception-handling-for-rest-with-spring)

5. Jelaskan fungsi dari object class webClient! Apakah ada alternatif lain yang dapat kita gunakan selain object class webClient?

WebClient adalah kelas yang digunakan untuk membuat HTTP requests pada aplikasi Spring. Kegunaannya adalah untuk membuat HTTP requests pada aplikasi Spring. WebClient digunakan untuk membuat HTTP requests ke server dan mengambil response dari server. Alternatif lain yang dapat digunakan selain WebClient adalah RestTemplate. RestTemplate adalah kelas yang digunakan untuk membuat HTTP requests pada aplikasi Spring. Kegunaannya adalah untuk membuat HTTP requests pada aplikasi Spring. RestTemplate digunakan untuk membuat HTTP requests ke server dan mengambil response dari server.

(Source: https://www.baeldung.com/spring-webclient-resttemplate)

---

##  Tutorial 6

###  Apa yang telah saya pelajari hari ini


###  Pertanyaan

1. Perhatikan apa yang terjadi pada file index.html pada branch feat/tutorial-6-advancedgit-1. Apa yang terjadi setelah git cherry-pick dilakukan? Apakah kita bisa melakukan cherrypick tanpa harus melakukan commit?

- setelah git cherry-pick dilakukan, file index.html pada branch feat/tutorial-6-advancedgit-1 akan berubah sesuai dengan perubahan yang ada pada commit yang di-cherry-pick yaitu penambahan kode head HTML dari branch tut6-for-cherrypick. Perubahan tersebut akan diaplikasikan pada branch feat/tutorial-6-advancedgit-1.

- Kita tidak bisa melakukan cherrypick tanpa harus melakukan commit. Cherrypick adalah proses untuk mengambil commit tertentu dari branch lain dan menerapkannya pada branch yang sedang aktif. Untuk menerapkan commit tersebut, kita harus melakukan commit terlebih dahulu setelah cherrypick dilakukan.

source: https://www.git-scm.com/docs/git-cherry-pick

2. Apa yang menjadi penyebab dari CONFLICT tersebut?

- Pada branch feat/tutorial-6-advancedgit-1 dan tut6-for-merge sama-sama melakukan perubahan pada file index.html yakni pada bagian body. Karena kedua branch tersebut melakukan perubahan pada bagian yang sama, maka terjadi conflict saat dilakukan merge.

- Git tidak bisa menentukan perubahan mana yang harus diterapkan karena kedua branch tersebut melakukan perubahan pada bagian yang sama. Sehingga, Git menandai perubahan tersebut sebagai conflict.

source: https://www.git-scm.com/docs/git-merge

3. Jelaskan perbedaan dari "rebase –continue", "rebase –skip", dan "rebase –abort"!

- rebase --continue: Perintah ini digunakan untuk melanjutkan proses rebase setelah menyelesaikan konflik pada commit yang di-rebase. Perintah ini digunakan setelah menyelesaikan konflik pada commit yang di-rebase.

- rebase --skip: Perintah ini digunakan untuk melewati commit yang sedang di-rebase dan melanjutkan proses rebase ke commit berikutnya. Perintah ini digunakan untuk melewati commit yang sedang di-rebase dan melanjutkan proses rebase ke commit berikutnya.

- rebase --abort: Perintah ini digunakan untuk membatalkan proses rebase dan mengembalikan branch ke kondisi sebelum rebase. Perintah ini digunakan untuk membatalkan proses rebase dan mengembalikan branch ke kondisi sebelum rebase.

source: https://www.git-scm.com/docs/git-rebase

4. Apa perbedaan Git Merge dengan Git Rebase? Buatlah/carilah ilustrasi yang dapat menggambarkan perbedaanya! Anda bisa menggunakan commit history (git log –oneline) Anda setelah melakukan rebase.

Git Merge:
- Membuuat commit baru yang menggabungkan dua branch yang bernama merge commit.
- Mempertaahankan history commit dari kedua branch yang di-merge.

Git Rebase:
- Memindahkan base commit dari branch yang di-rebase ke base commit dari branch tujuan.
- Mengubah history commit dari branch yang di-rebase menjadi linear.
- Menghasilkan grafik commit yang lebih bersih dan linear.

source: https://www.git-scm.com/docs/git-merge

source: https://www.git-scm.com/docs/git-rebase

5. Mengapa hal pada langkah no 4 bisa terjadi? Mengapa git stash menjadi solusinya?

- Langkah 4 gagal karena Git mencegah perpindahan branch ketika ada uncommited changes untuk mencegah kehilangan perubahan yang belum disimpan.

Git stash menjadi solusi karena:
- Stash digunakan untuk menyimpan perubahan yang belum di-commit kedalam temporary storage.
- Perubahan yang di-stash dapat diambil kembali nanti menggunakan stash pop
- Memungkinkan perpindahan branch dengan aman tanpa harus melakukan commit prematur.

source: https://www.git-scm.com/docs/git-stash

6. Sebutkan dan jelaskan tiga tipe dari Git Reset!

- Git Reset --soft: Mengubah HEAD ke commit yang ditentukan tanpa mengubah staging area dan working directory. Perubahan yang ada di commit tersebut akan kembali ke staging area.

- Git Reset --mixed: Mengubah HEAD ke commit yang ditentukan dan mengubah staging area menjadi seperti commit tersebut. Perubahan yang ada di commit tersebut akan kembali ke staging area. Git reset ini merupakan default dari git reset.

- Git Reset --hard: Mengubah HEAD ke commit yang ditentukan dan menghapus perubahan yang ada di staging area dan working directory. Perubahan yang ada di commit tersebut akan hilang.

source: https://www.git-scm.com/docs/git-reset

7. Apa itu git revert? Apa perbedaannya dengan git reset?

Git Revert: Git revert digunakan untuk membuat commit baru yang membatalkan perubahan dari commit sebelumnya. Git revert membuat commit baru yang membatalkan perubahan dari commit sebelumnya. Berikut adalah ciri ciri Git revert:
- Membuat commit baru yang membatalkan perubahan dari commit sebelumnya.
- Tidak mengubah history commit yang sudah ada.
- Lebih aman untuk digunakan pada branch yang sudah di-push.
- Dapat dibatalkan karena membuat commit baru.

Git Reset: Git reset digunakan untuk mengubah HEAD ke commit yang ditentukan dan mengubah staging area dan working directory sesuai dengan commit tersebut. Git reset mengubah HEAD ke commit yang ditentukan dan mengubah staging area dan working directory sesuai dengan commit tersebut. Berikut adalah ciri ciri Git reset:
- Mengembalikan HEAD ke commit yang ditentukan dengan menghapus commit setelahnya.
- Mengubah history commit yang sudah ada.
- Lebih sulit dibatalkan karena menghapus commit yang sudah ada.

source: https://www.git-scm.com/docs/git-revert

source: https://www.git-scm.com/docs/git-reset

8. Buatlah grafik yang menggambarkan alur commit pada bagian Git Flow and Branching ini serta jelaskan! Grafik dapat berupa tulis tangan maupun menggunakan software.

![Git Flow and Branching](https://i.imgur.com/jZMOEI4.png)

- Dimulai dari branch main dengan commit pertama.
- Dibuat branch development dan ditambahkan base.html
- Dari development, dibuat branch feature-a dan dilakukan edit pada base.html
- Feature-a di merge ke development
- Dibuat branch feature-b dari development dan dilakukan edit pada base.html
- Terjadi conflict saat rebase feature-b ke development
- Conflict diresolve dan feature-b di merge ke development

source: https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-

9. Apa kegunaan dari langkah di atas? (Setup HTTP Header Manager)

- HTTP Header Manager digunakan untuk menambahkan header. Pada tutorial ini, kita menambahkan content-type header dengan value application/json pada HTTP Header Manager. Kegunaannya adalah untuk menentukan tipe konten yang dikirimkan dalam request, dalam hal ini adalah application/json.

10. Apa itu JSON Extractor? Sebutkan semua kegunaannya di Test Plan ini! HINT: Lanjut ke langkah-langkah berikutnya untuk mengetahui jawabannya.

- JSON Extractor adalah komponen yang digunakan untuk mengekstrak data dari response JSON dan menyimpannya ke dalam variabel. Kegunaannya adalah untuk mengekstrak data dari response JSON dan menyimpannya ke dalam variabel. Pada tutorial ini, kita menggunakan JSON Extractor untuk mengekstrak id dari response JSON pertama dan menyimpannya ke dalam variabel id.

11. Apa itu Assertions dalam JMeter? Sebutkan contoh 3 Assertions dan kegunaannya!

Terdapat 3 jenis Assertions dalam JMeter:

- Response Assertion: Assertion ini digunakan untuk memeriksa response dari server apakah sesuai dengan kondisi yang diinginkan. Kegunaannya adalah untuk memeriksa response dari server apakah sesuai dengan kondisi yang diinginkan.

- JSON Assertion: Assertion ini digunakan untuk memeriksa response JSON dari server apakah sesuai dengan kondisi yang diinginkan. Kegunaannya adalah untuk memeriksa response JSON dari server apakah sesuai dengan kondisi yang diinginkan.

- Duration Assertion: Assertion ini digunakan untuk memeriksa durasi response dari server apakah sesuai dengan kondisi yang diinginkan. Kegunaannya adalah untuk memeriksa durasi response dari server apakah sesuai dengan kondisi yang diinginkan.

12. Apa itu Number of Threads dan Ramp-up Period? Apa hubungan antar keduanya?

- Number of Threads: Number of Threads adalah jumlah pengguna virtual yang akan melakukan request ke server. Kegunaannya adalah untuk menentukan jumlah pengguna virtual yang akan melakukan request ke server.

- Ramp-up Period: Ramp-up Period adalah waktu yang dibutuhkan untuk semua pengguna virtual untuk memulai request ke server. Kegunaannya adalah untuk menentukan waktu yang dibutuhkan untuk semua pengguna virtual untuk memulai request ke server.

- Hubungan antara Number of Threads dan Ramp-up Period adalah Number of Threads menentukan jumlah pengguna virtual yang akan melakukan request ke server, sedangkan Ramp-up Period menentukan waktu yang dibutuhkan untuk semua pengguna virtual untuk memulai request ke server. Misal dengan 1000 threads dan 100 ramp-up period, JMeter akan membuat 10 thread baru setiap detik setiap 1 detik.

13. Gunakan angka 1000 untuk Number of Threads dan 100 untuk Ramp-up period. Jalankan Test Plan dengan konfigurasi tersebut. Kemudian, perhatikan Summary Report, View Result Tree, Graph Result, dan Assertion Result. Buatlah penjelasan minimal 2 paragraf untuk menjelaskan temuan menarik kalian terhadap hasil-hasil tersebut. Sertakan screenshot dari keempat result tersebut. Sertakan juga info mengenai prosesor, RAM, dan penggunaan hardisk HDD atau SSD dari perangkat Anda. (Jika perangkat Anda tidak kuat dengan angka konfigurasi tersebut, silakan turunkan angkanya).

![Summary Report](https://i.imgur.com/H19kFxb.jpeg)

- Dari Summary Report terlihat bahwa jumlah request yang berhasil adalah 1000, sedangkan jumlah request yang gagal adalah 0. Hal ini menunjukkan bahwa semua request berhasil dilakukan tanpa ada request yang gagal. Durasi rata-rata request adalah 26 detik, dengan rata-rata paling tinggi berada saat request search proyek by nama. Selain itu, waktu request terlama ada pada 99 detik pada search proyek juga, dan paling sedikit ada 0 detik yakni pada request random (API yang simple)

- Kita juga dapat lihat jika persentase error tertinggi ada pada request search proyek by nama (34%) dan juga random (49%). Pada kasus search by nama, somehow banyak yang mengalami error 500 saat ditengah-tengah proses, tetapi saat menuju akhir, reponse 200 semua. Sedangkan pada random error terjadi karena response di random, dari 1000 request, kita mendapat 490 response yang error.

![View Result Tree](https://i.imgur.com/KqVjYZl.jpeg)

- Dari View Result Tree, kita dapat melihat detail dari setiap request yang dilakukan. Kita dapat melihat response code, response message, dan response data dari setiap request. Dari View Result Tree, kita dapat melihat bahwa setiap request yang dilakukan memberikan response code 200 yang artinya request berhasil dilakukan kecuali pada request random yang tidak semuanya berhasil karena response di-randomize.

![Graph Result](https://i.imgur.com/94fF4m1.jpeg)

- Dari Graph Result, kita dapat melihat bahwa terdapat trend meningkat pada response time individual dan garis rata-rata menunjukan bahwa aplikasi menghadapi degradasi performa seiring bertambahnya jumlah request.

- Standar deviasi yang besar juga mengindikasikan adanya variasi yang besar pada response time individual. Hal ini menunjukkan bahwa server kadang-kadang dapat menghandle request secara cepat, namun kadang-kadang juga membutuhkan waktu yang lama untuk merespon request. Hal ini karena terdapat request yang simple seperti random atau get by id, dan juga request yang kompleks seperti search by nama.

- Fluktuasi Throughput juga menunjukkan adanya ketidakstabilan yang mungkin disebabkan oleh ketidakmampuan server untuk mengikuti load yang terus meningkat

![Assertion Result](https://i.imgur.com/Qhwhuaa.jpeg)

- Dari Assertion Result, kita dapat melihat bahwa semua assertion yang dilakukan berhasil. Hal ini menunjukkan bahwa response dari server sesuai dengan kondisi yang diinginkan. Assertion Result menunjukkan bahwa semua response dari server sesuai dengan kondisi yang diinginkan.

![Hardware When Running](https://i.imgur.com/qDzmdMh.jpeg)
![Hardware Usage When Running](https://i.imgur.com/FuRGUBE.jpeg)

- Spesifikasi perangkat yang digunakan:
  - Processor: AMD Ryzen 5 5600X (12 Threads)
  - RAM: 13.9 GB
  - Hardisk: NVME Gen.3 SSD

- Saat running pada puncaknya, kita dapat melihat CPU dan RAM usage yang cukup tinggi, bahkan hampir maksimal. Hal ini menunjukkan bahwa JMeter membutuhkan sumber daya yang cukup besar untuk menjalankan 1000 threads dengan ramp-up period 100. Penggunaan SSD tidak terlalu tinggi karena JMeter lebih banyak menggunakan CPU dan RAM untuk menjalankan test plan.

![Hardware after Finished](https://i.imgur.com/gUAkdss.jpeg)

- Saat selesai, penggunaan CPU dan RAM kembali normal menjadi sangat rendah dan resource usage yang digunakan oleh JMeter kembali ke kondisi normal.

14. Sembari menjalankan Test Plan, perhatikan pergerakan grafik pada JConsole. Buatlah penjelasan minimal 2 paragraf untuk menjelaskan temuan menarik kalian terhadap hasil-hasil tersebut. Sertakan screenshot dari grafik-grafik tersebut

![JConsole Before Test](https://i.imgur.com/AdJMXwD.jpeg)

- Pada JConsole sebelum test, kita dapat melihat bahwa penggunaan CPU dan RAM masih normal dan terbilang rendah. CPU Usage hanya 0.1% dan thread yang digunakan hanya 50.

![JConsole At Peak](https://i.imgur.com/WFOsPzh.jpeg)

- Pada JConsole saat test berjalan pada puncaknya, kita dapat melihat bahwa penggunaan CPU dan RAM meningkat drastis. CPU Usage mencapai 7.3% dan RAM yang digunakan meningkat 100% menjadi 300MB. Thread juga meningkat menjadi 237 thread yang digunakan.

![JConsole After Test](https://i.imgur.com/xxR8REI.jpeg)

- Pada JConsole setelah test selesai, penggunaan CPU dan RAM kembali normal menjadi sangat rendah dan resource usage yang digunakan oleh JMeter kembali ke kondisi normal. CPU Usage kembali ke 0.1% dan RAM yang digunakan kembali ke 100MB. Thread juga kembali ke 50 thread yang digunakan.

15. Apa itu Load Testing? Buatlah kesimpulan dari pengerjaan tutorial JMeter & JConsole ini.

- Load Testing adalah proses pengujian performa aplikasi dengan memberikan beban yang tinggi untuk melihat bagaimana aplikasi merespon terhadap beban tersebut. Load Testing digunakan untuk mengukur performa aplikasi saat menerima beban yang tinggi dan melihat bagaimana aplikasi merespon terhadap beban tersebut.

- Dari pengerjaan tutorial JMeter & JConsole ini, kita dapat melihat bahwa penggunaan CPU dan RAM meningkat drastis saat test berjalan pada puncaknya. Hal ini menunjukkan bahwa JMeter membutuhkan sumber daya yang cukup besar untuk menjalankan 1000 threads dengan ramp-up period 100. Penggunaan SSD tidak terlalu tinggi karena JMeter lebih banyak menggunakan CPU dan RAM untuk menjalankan test plan. Pada JConsole, kita dapat melihat bahwa penggunaan CPU dan RAM meningkat drastis saat test berjalan pada puncaknya. CPU Usage mencapai 7.3% dan RAM yang digunakan meningkat 100% menjadi 300MB. Thread juga meningkat menjadi 237 thread yang

---

##  Tutorial 7

###  Apa yang telah saya pelajari hari ini
Pada Tutorial 7 ini, saya belajar banyak hal, pertama saya belajar cara mengkonfigurasi sebuah project VueJS dengan Vite dari awal. Saya juga mempelajari cara mengkonfigurasi CORS untuk penggunaan REST API yang telah saya bikin sebelumnya di Springboot dan juga cara mengakses REST API tersebut pada frontend VueJS. Selain itu, saya juga belajar cara menggunakan Vuex untuk state management pada VueJS dan juga cara menggunakan Vue Router untuk routing pada VueJS.

###  Pertanyaan

1. Jelaskan apa saja maksud dari pilihan konfigurasi pada awal inisialiasi proyek vue!

- Project name: Nama proyek yang akan dibuat. Nama proyek yang kita buat adalah manpromanpro-frontend.
- Add TypeScript: Menambahkan TypeScript ke proyek. Untuk opsi ini, kita memlih ya kae kita akan menggunakan TypeScript dalam proyek ini.
- Add JSX Support: Menambahkan JSX Support ke proyek. Untuk opsi ini, kita memilih ya.
- Add Vue Router for single page application development: Menambahkan Vue Router untuk pengembangan aplikasi single page. Untuk opsi ini, kita memilih ya karena kita membutuhkannya.
- Add End-to-end testing with Solution: Menambahkan End-to-end testing solution. Untuk opsi ini, kita memilih no.
- Add ESLint: Menambahkan ESLint ke proyek. Untuk opsi ini, kita memilih ya karena ESLint digunakan untuk memeriksa kode JavaScript dan memastikan bahwa kode tersebut mematuhi standar tertentu.
- Add prettier for code formatting: Menambahkan Prettier untuk code formatting. Untuk opsi ini, kita memilih ya karena Prettier digunakan untuk memformat kode JavaScript agar lebih rapi dan mudah dibaca.
- Add Pinia for state management: Menambahkan Pinia untuk state management. Untuk opsi ini, kita memilih ya karena Pinia digunakan untuk mengelola state pada aplikasi Vue.
- Add Vue DevTools 7 extension for debugging: Menambahkan Vue DevTools 7 extension untuk debugging. Untuk opsi ini, kita memilih no karena kita tidak membutuhkannya.

2. Apa itu vite? apakah kita dapat menggunakan vue tanpa vite? Jelaskan!

- Vite adalah build tool yang digunakan untuk mengembangkan aplikasi web modern. Vite digunakan untuk mempercepat proses pengembangan aplikasi web dengan menyediakan fitur-fitur seperti hot module replacement, fast refresh, dan bundling yang cepat. Vite menggunakan bundler yang berbasis ES Module untuk mempercepat proses bundling dan memungkinkan pengembangan aplikasi web yang lebih cepat. Tanpa Vite, kita masih dapat menggunakan Vue untuk mengembangkan aplikasi web. Namun, dengan menggunakan Vite, proses pengembangan aplikasi web menjadi lebih cepat dan efisien.

source: https://vitejs.dev/

3. Jelaskan masing-masing fungsi dari assets, components, router, stores, dan view pada proyek aplikasi Vue JS!

- assets: Folder ini digunakan untuk menyimpan aset seperti gambar, video, dan file lainnya yang digunakan dalam proyek Vue. Aset ini dapat digunakan dalam komponen Vue untuk menampilkan gambar, video, dan file lainnya.
- components: Folder ini digunakan untuk menyimpan komponen Vue yang digunakan dalam proyek Vue. Komponen Vue adalah bagian dari aplikasi Vue yang dapat digunakan kembali dan dapat diintegrasikan ke dalam aplikasi Vue.
- router: Folder ini digunakan untuk menyimpan konfigurasi router Vue. Router Vue digunakan untuk mengatur navigasi antar halaman dalam aplikasi Vue.
- stores: Folder ini digunakan untuk menyimpan konfigurasi store Vue. Store Vue digunakan untuk mengelola state dalam aplikasi Vue.
- view: Folder ini digunakan untuk menyimpan halaman Vue yang digunakan dalam proyek Vue. Halaman Vue adalah bagian dari aplikasi Vue yang menampilkan konten ke pengguna.

source: https://v3.vuejs.org/guide/introduction.html

4. Kenapa agar Vue JS dapat mengakses REST API yang ada pada Spring Boot, kalian harus menambahkan konfigurasi CORS terlebih dahulu?

- CORS (Cross-Origin Resource Sharing) adalah mekanisme yang digunakan oleh browser untuk memungkinkan request dari domain yang berbeda. Jika aplikasi Vue JS dan REST API yang ada pada Spring Boot berjalan pada domain yang berbeda, maka browser akan mencegah request dari aplikasi Vue JS ke REST API karena keamanan. Untuk mengatasi masalah ini, kita harus menambahkan konfigurasi CORS pada REST API yang ada pada Spring Boot agar aplikasi Vue JS dapat mengakses REST API tersebut.

source: https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS

5. Jelaskan apa kegunaan interface pada typescript dan apa perbedaannya dengan types serta kapan harus menggunakan yang mana!

- Interface pada TypeScript digunakan untuk mendefinisikan struktur data yang digunakan dalam aplikasi TypeScript. Interface digunakan untuk mendefinisikan tipe data yang digunakan dalam aplikasi TypeScript. Perbedaan antara interface dan types adalah interface digunakan untuk mendefinisikan struktur data, sedangkan types digunakan untuk mendefinisikan tipe data. Kita harus menggunakan interface jika kita ingin mendefinisikan struktur data yang digunakan dalam aplikasi TypeScript, sedangkan kita harus menggunakan types jika kita ingin mendefinisikan tipe data yang digunakan dalam aplikasi TypeScript.

source: https://www.typescriptlang.org/docs/handbook/2/everyday-types.html