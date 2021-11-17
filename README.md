# Tutorial APAP
## Authors
* **Priyanty Nurul Fatimah** - *1906353681* - *C*

## Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi untuk memastikan orang ini benar2 terdaftar.
Otorisasi untuk memastikan dia punya kewenangan untuk memakai fitur
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
Dia adalah fitur untuk mengencripsi dan mendekripsi password.

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa
demikian?

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
Agar dapat mengambil role dari user

## Tutorial 5
### What I have learned today
1. Apa itu Postman? Apa kegunaannya?
Postman adalah aplikasi antarmuka untuk melakukan API testing. Gunanya adalah 
untuk menguji request HTTP di mana setelah melakukan request kita akan 
mendapat berbagai jenis response sebagai validasi. Jadi kita dapat 
memvalidasi respon tanpa harus membangun suatu halaman website yang utuh.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties adalah anotasi yang digunakan untuk mengabaikan suatu 
properti logis tertentu yang ditentukan dalam serialisasi dan deserialisasi JSON.

@JsonProperty adalah anotasi untuk menandai bahwa suatu properti merupakan suatu JsonProperty
dan bisa diberikan nama properti dalam tanda kurung yang menyertai anotasi

3. Apa kegunaan atribut WebClient?
WebClient adalah interface yang merepresentasikan titik masuk utama untuk 
melakukan request pada web

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity adalah objek untuk merepresentasikan keseluruhan HTTP response.
Kita bisa mengontrol segala hal yang masuk ke objek tersebut: status code, 
header, and body.

BindingResult adalah objek Spring yang digunakan untuk menampung hasil dari 
validasi dan binding serta berisi error yang mungkin saja terjadi. Objek 
tersebut harus muncul setelah validasi suatu objek, apabila tidak maka Spring
akan gagal untuk memvalidasi objek tersebut dan mengeluarkan exception.

Source:
https://www.encora.com/insights/what-is-postman-api-test#:~:text=Postman%20is%20an%20application%20used,need%20to%20be%20subsequently%20validated.
https://www.concretepage.com/jackson-api/jackson-jsonignore-jsonignoreproperties-and-jsonignoretype
https://www.baeldung.com/spring-5-webclient
https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc/36715053


---
## Tutorial 3
### What I have learned today

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

@AllArgsConstructor : anotasi ini berfungsi untuk menghasilkan konstruktor 
dengan argumen berupa setiap field pada kelas yang diberikan anotasi.

@NoArgsConstructor : anotasi ini menghasilkan konstruktor tanpa parameter untuk
kelas yang diberikan anotasi

@Setter : anotasi ini akan membuatkan setter function secara otomatis untuk setiap
atribut pada kelas yang dianotasi

@Getter : anotasi ini akan membuatkan getter function secara otomatis untuk setiap
atribut pada kelas yang dianotasi

@Entity : anotasi ini berfungsi untuk memberi tanda bahwa suatu kelas dapat dipetakan 
ke suatu tabel

@Table : anotasi ini memiliki fungsi untuk memungkinkan kita untuk menentukan detail
yang akan dimiliki entitas/digunakan dalam database; seperti nama tabel, katalog, schema, 
dan memberikan unique constraints


2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method
tersebut?

=> Kegunaan dari method findByNoBioskop adalah meng-query data dari repository BioskopDB
yang memiliki suatu noBioskop yang spesifik dan mengembalikannya dalam bentuk
objek BioskopModel

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn

@JoinTable : Sepemahamanku anotasi ini seperti salah satu metode pemetaan diagram ER
ke Model Relasional, yaitu cross-reference atau relationship relation. Di mana, 
metode pemetaan ini akan membentuk suatu tabel/relasi baru dari 2 tabel yang saling berelasi.
Dalam hal ini anotasi menggabungkan primary key dari kedua class/tabel yang berelasi 
dalam suatu tabel/relasi baru.

@JoinColumn : Sedangkan anotasi ini yang akan mengambil primary key tersebut 
dan mendefinisikan kolom mana yang akan menjadi rujukan dari foreign key dan dari 
tabel entitas yang mana.


4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull

parameter pada anotasi @JoinColumn di class PenjagaModel memiliki kegunaan sebagai berikut:

name: mendefinisikan nama column yang akan digunakan foreign key pada tabel entitas tersebut
dalam hal ini foreign key bioskop akan memiliki nama kolom no_bioskop pada tabel entitas PenjagaModel

referencedColumnName: mendefinisikan nama kolom yang akan menjadi referenced bagi foreign key

nullable: mendefinisikan not null constraints pada tabel

perbedaan nullable dan @NotNull: mereka berdua sama-sama mencegah penyimpanan 
null values pada basisdata di bawahnya. Perbedaannya adalah @NotNull menjalankan 
pengecekan nilai pada atribut sebelum melakukan query SQL, sehingga apabila atribut diketahui
bernilai null, Hibernate tidak akan menjalankan pemanggilan SQL. Sedangkan nullable akan
menjalankan pengecekan setelah mengeksekusi SQL dan membiarkan database yang melakukan
validasi, sehingga apabila ternyata atribut bernilai null, SQL statement akan gagal.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

FetchType.LAZY: adalah sebuah method untuk mengambil data secara on-demand pada data 
yang sangat besar. Jadi instead of mengambil semua field yang ada kita akan menggunakan 
method get untuk mengambil field yang kita butuhkan saja.

CascadeType.ALL: cascade adalah suatu cara mengaplikasikan tindakan yang dikenakan pada suatu entity
kepada entity lain yang dependent terhadapnya. JPA CascadeType memiliki beberapa mode salah satunya 
mode ALL. Mode ALL berfungsi untuk mengaplikasikan tindakan apapun yang dikenakan pada entity parent 
ke entity childrennya. 

FetchType.EAGER: kebalikan dari LAZY, EAGER akan me-load semua data sekaligus. Biasanya untuk 
relasi one-to-one.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
Quite much actually
- [ ] Ada sangat banyak file dan annotation astaghfirullah
- [ ] Belum begitu paham annotation Qualifier dan Transactional
- [ ] Belum begitu paham bedanya annotation RequestMapping dan GetMapping

Source:
https://stackoverflow.com/questions/29332907/what-is-the-exact-meaning-of-the-jpa-entity-annotation#:~:text=%40Entity%20annotation%20defines%20that%20a,like%20for%20example%20Serializable%20interface.
https://thorben-janssen.com/hibernate-tips-whats-the-difference-between-column-nullable-false-and-notnull/
https://www.baeldung.com/jpa-cascade-types

---
## Tutorial 2
### What I have learned today

Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link
berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20
APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

=> Yang terjadi adalah muncul WhiteLabel Error Page karena pada controller 
=> kita mengarahkan path /bioskop/add untuk membuka template file addbioskop
=> sedangkan ketika mengikuti tutorial pada saat itu kita belum membuat file
=> tersebut, sehingga sistem tidak bisa memunculkan view untuk path tersebut 

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut
merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja
@Autowired tersebut dalam konteks service dan controller yang telah kamu buat

=> Menurut saya anotasi @Autowired pada class Controller merupakan implementasi
=> dari konsep domain model; Di mana, konsepnya adalah instead of membuat secara
=> runut untuk setiap kegiatan (transaksi) yang ingin dilakukan @Autowired menghubungkan
=> fungsi-fungsi tersebut dengan menempatkan sebuah instance dari satu bean ke dalam field
=> yang diinginkan ke dalam sebuah instance dari bean lain. 
=> intinya mempass object/instance hohhoh

Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link
berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20
APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

=> Yang terjadi adalah kembali muncul WhiteLabel Error Page di mana kali ini 
=> hal tersebut disebabkan oleh kurangnya parameter yang wajib diberikan pada 
=> link yaitu parameter jumlahStudio (kita menetapkan status required pada parameter
=> tersebut)

Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung,
link apa yang harus diakses?

=> Link yang harus diakses adalah menggunakan path /bioskop/view dengan 
=> parameter idBioskop atas nama Bioskop Maung
=> contoh: Bioskop Maung memiliki idBioskop = 2; maka link yang harus diakses
=> adalah http://localhost:8080/bioskop/view?idBioskop=2

Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk
mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan
juga bukti screenshotmu.

=> Yang ditampilkan adalah seluruh bioskop yang ditambahkan pada suatu session
=> Berikut adalah hasil ss yang saya lakukan (akan saya masukkan langsung lewat github 
=> atau bisa dicek di dalam folder cineplux ini ^-^)

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
Quite much actually
- [ ] Sudah cukuo mengerti flow-nya ^-^ senang.. hanya saja masih sangat perlu mengulang
- [ ] Materi perkuliahan hari ini agak membingung T^T tapi tidapaa.. nanti kubaca2 lagi

---
## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda
juga boleh menambahkan catatan apapun di bagian ini)

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Based on IBM (n.d) GitHub Issues is a tracking tool that is integrated with your GitHub 
repository. Use GitHub Issues to focus on important tasks and keep plans up to date simultaneously. 
← Back to Develop practices and tools. Track ideas, work, and bugs without leaving GitHub.

2. Apa perbedaan dari git merge dan git merge --squash?

A squash merge is a merge option in Git that will produce a merge commit with only one parent. 
The files are merged exactly as they would be in a normal merge, but the commit metadata is 
changed to show only one of the parent commits. The result is a single commit on the target 
branch with all of the changes from a normal merge.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?

Version control helps teams solve these kinds of problems, tracking every individual change 
by each contributor and helping prevent concurrent work from conflicting. Version control systems 
allow you to compare files, identify differences, and merge the changes if needed prior to 
committing any code. Versioning is also a great way to keep track of application builds by 
being able to identify which version is currently in development, QA, and production.

### Spring
4. Apa itu library & dependency?

Module dependencies are classes, archives, libraries and resources that your module files 
references. While a library is a set of class files stored in an archive or directory.
The analogy is that even though a code library is invented specifically for other 
projects to use, it's not a dependency until this actually happens. If an application uses 
a library, the application has a dependency on that library. Libraries are not the only type 
of dependency an application can have.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?


The Spring Boot Maven Plugin provides Spring Boot support in Apache Maven. It allows you to 
package executable jar or war archives, run Spring Boot applications, generate build information 
and start your Spring Boot application prior to running integration tests. 
Maven it self is described as 'Apache Maven is a Java-based tool for build automation and project 
management (in software development). It is centered around a Project Object Model (POM) described 
in a XML file that describes the project structure and its dependencies to other components and libraries' 
and is an app in the Development category.

The best alternative for Maven is CMake, which is both free and Open Source. 
Other great apps like Maven are GNU Make (Free, Open Source), Gradle (Free, Open Source), 
SCons (Free, Open Source) and Meson (Free, Open Source).

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?

a. Spring enables developers to develop enterprise-class applications using POJOs.
b. Make a Java method execute in a database transaction without having to deal with transaction APIs.
c. Make a local Java method a remote procedure without having to deal with remote APIs.
d. Make a local Java method a management operation without having to deal with JMX APIs.
e. Make a local Java method a message handler without having to deal with JMS APIs.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?

1) The @RequestParam is used to extract query parameters while @PathVariable is used to extract 
data right from the URI.

2) @RequestParam is more useful on a traditional web application where data is mostly passed in the 
query abatements while @PathVariable is more suitable for RESTful web services where URL contains values, 
like http://localhost:8080/book/9783827319333, here data, which is ISBN number is part of URI.

Read more: https://javarevisited.blogspot.com/2017/10/differences-between-requestparam-and-pathvariable-annotations-spring-mvc.html#ixzz75tQDa58v
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
Quite much actually
- [ ] I'm quite confused about how github works, their algorithm, etc.
- [x] I have no idea on how to develop an application but I am eager to learn
- [ ] I know the benefit of version control but I still don't know how to check or where to use it
- [ ] I am confused with all those technical words (jar, POJO, plugin, war archives, API, etc.)
- [ ] I am happy to learn new technical words such as library and dependency. Now I know what are they.
      But, because I still haven't encounter the physical forms of those words I'm not sure how to imagine it.
- [ ] I'm totally confused about the flow of an application, server, database. like how they interact?
Karena …
(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))

Source:
https://www.ibm.com/garage/method/practices/think/tool_github_issues/#:~:text=GitHub%20Issues%20is%20a%20tracking,and%20bugs%20without%20leaving%20GitHub
https://devblogs.microsoft.com/devops/squash-a-whole-new-way-to-merge-pull-requests/#:~:text=A%20squash%20merge%20is%20a,one%20of%20the%20parent%20commits.
https://www.atlassian.com/git/tutorials/what-is-version-control#:~:text=Version%20control%20helps%20teams%20solve,working%20at%20the%20same%20time.
https://stackoverflow.com/questions/12269733/what-is-the-difference-between-module-dependencies-and-libraries-in-intellij#:~:text=13,in%20an%20archive%20or%20directory.
https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/
https://alternativeto.net/software/maven/
https://www.tutorialspoint.com/spring/spring_overview.htm

