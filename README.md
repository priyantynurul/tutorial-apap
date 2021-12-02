# Tutorial APAP
## Authors
* **Priyanty Nurul Fatimah** - *1906353681* - *C*

## Tutorial 8
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?

Langkahnya adalah dengan me-reset state di dalam fungsi handleSubmitItem(). Karena handle submit item adalah 
fungsi untuk mensubmit form tambah item dan setState adalah fungsi untuk menetapkan state objek pada sesi 
tersebut. Sehingga digunakan setState dengan value default pada fungsi handleSubmitItem().

![image](https://user-images.githubusercontent.com/90324988/144417133-70a9016f-2ff1-4634-b024-b0b4d9d3b3d3.png)

2. Jelaskan fungsi dari async dan await!

Async — await adalah salah satu fitur baru dari javascript yang di gunakan untuk menangani hasil dari sebuah promise.
Caranya adalah dengan menambahkan kata ‘async’ di depan sebuah fungsi untuk mengubahnya menjadi asynchronous.
Sedangkan await berfungsi untuk menunda sebuah kode di jalankan, sampai proses asynchronous berhasil.

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle
pada pertanyaan ini.

Step 1
![image](https://user-images.githubusercontent.com/90324988/144417504-3d1ac9eb-d409-471a-81af-e804549c9bc9.png)
![image](https://user-images.githubusercontent.com/90324988/144417527-df6f01e4-1247-469d-bdd7-ec20496028d4.png)
![image](https://user-images.githubusercontent.com/90324988/144417550-cde4ae28-0d1b-4b62-9917-1ae251ad8adb.png)

Step 2
![image](https://user-images.githubusercontent.com/90324988/144417588-1947f0f8-4c7e-4d2d-9a0f-3261a8384a9d.png)

Step 3
![image](https://user-images.githubusercontent.com/90324988/144417665-ce8a9ff3-5c8e-4a52-a82d-0eb2e9d180bf.png)

Step 6
![image](https://user-images.githubusercontent.com/90324988/144417700-a5c65f6f-7325-44f5-9e6f-8fc2e5e56eee.png)

Step 7
a.
![image](https://user-images.githubusercontent.com/90324988/144417782-2ed0624e-ee4f-4c4b-bb67-e55b103253ce.png)

b.
![image](https://user-images.githubusercontent.com/90324988/144417809-047bf99e-d869-4e3c-89c7-71764e178413.png)

c.
![image](https://user-images.githubusercontent.com/90324988/144417837-76b1d7ef-c024-457f-96af-d822e18559f1.png)

Step 8
![image](https://user-images.githubusercontent.com/90324988/144417931-43688352-1d34-40ba-96ac-8b0afc66cf21.png)

Step 9
![image](https://user-images.githubusercontent.com/90324988/144417955-fc63638c-c348-4ec2-84c9-1fbb9a68960e.png)

Step 9 Additional
![image](https://user-images.githubusercontent.com/90324988/144418002-9d962c86-1ee5-4e7f-9a5b-fc23e3cc34cd.png)
![image](https://user-images.githubusercontent.com/90324988/144418037-7cccdda2-ebc8-4945-9272-eb52986584d1.png)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.

componentDidMount: dipanggil pada fase mounting, fungsinya untuk memanipulasi DOM dan request data.

shouldComponentUpdate : dipanggil pada fase updating, tugasnya adalah untuk menentukan apakah sebuah component 
akan di render ulang atau tidak. Method ini akan mengembalikan nilai boolean true & false, jika true maka 
component akan di render ulang atau sebaliknya.

componentDidUpdate : dipanggil pada fase updating, fungsinya sama dengan componentDidMount yaitu untuk manipulasi 
DOM dan request data.

componentWillReceiveProps : dipanggil pada fase updating, fungsi ini akan di eksekusi apabila state yang ada di 
component akan di update atau di ubah dengan nilai props yang baru.

componentWillUnmount: dipanggil pada fase unmounting, yang di jalankan sebelum sebuah component di hapus dari DOM

Source:
https://medium.com/codeacademia/apa-itu-component-lifecycle-di-react-bfcb64f64e0e


## Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
sebagai ilustrasi dari apa yang Anda jelaskan.

Nomor 1
**Class Based**
Saya menambahkan handler handleDeleteItemFromCart untuk 
memberikan arahan pada sistem untuk menghapus item dari List cart apabila 
tombol trash ditekan. Hal itu pula yang menyebabkan saya harus menambahkan 
atribut handleDeleteItemFromCart untuk menjadi props yang di-oper ke List MyCart.

<img width="437" alt="image" src="https://user-images.githubusercontent.com/90324988/143278458-a3091d26-7ce9-4cb6-918b-d95562f3ab60.png">
<img width="325" alt="image" src="https://user-images.githubusercontent.com/90324988/143278494-2dfaaa95-8ff9-492d-8bea-d756f0a750fb.png">


**Functional Based**
Saya melakukan hal yang sama dengan class based, hanya saja implementasi codenya 
berbeda karena pada functional based sudah menggunakan useState.

<img width="442" alt="image" src="https://user-images.githubusercontent.com/90324988/143277800-4b9739de-324c-4d2b-aa12-0808d9ceb00d.png">
<img width="289" alt="image" src="https://user-images.githubusercontent.com/90324988/143277856-7fc8d6cf-f73a-4ad5-9593-7d8517a9ec65.png">


Nomor 2
**Class Based**
Saya melakukan kalkulasi pada atribut handleDeleteItemFromCart dan atribut 
handleAddItemToCart. Di mana pada atribut delete tiap kali item dihapus dari My Cart, maka
saldo bertambah kembali sesuai dengan harga item. Sedangkan pada atribut add 
tiap kali item ditambah ke My Cart, maka saldo berkurang sesuai dengan 
harga item. Kemudian akan diset balance-nya.

<img width="452" alt="image" src="https://user-images.githubusercontent.com/90324988/143278262-fee4d5df-69fd-44ac-9593-422f726e7c4e.png">
<img width="463" alt="image" src="https://user-images.githubusercontent.com/90324988/143278350-d7f95077-04e9-41b3-98fe-a0d1d34869db.png">
<img width="416" alt="image" src="https://user-images.githubusercontent.com/90324988/143278400-fe6ead19-6c56-4b7f-a3c7-150a75bfef3c.png">


**Functional Based**
Saya melakukan hal yang sama dengan class based, hanya saja implementasi codenya 
berbeda karena pada functional based sudah menggunakan useState.

<img width="461" alt="image" src="https://user-images.githubusercontent.com/90324988/143277952-023aee20-b694-4b58-bf38-303ee9be3b95.png">
<img width="443" alt="image" src="https://user-images.githubusercontent.com/90324988/143278006-f28c28f9-c9f0-4572-ada1-7d47b3fc3ac7.png">


Nomor 3
**Class Base**
Saya menambahkan fungsi untuk mengeluarkan alert pada atribut handleAddItemToCart 
sehingga apabila hasil kalkulasi < 0 maka add item tidak dapat dilakukan dan 
akan muncul alert.

<img width="295" alt="image" src="https://user-images.githubusercontent.com/90324988/143278150-f2083255-9cfd-40bb-9ff0-48722c9a2d0b.png">


**Functional Based**
Saya melakukan hal yang sama dengan class based, hanya saja implementasi codenya 
berbeda karena pada functional based sudah menggunakan useState.

<img width="281" alt="image" src="https://user-images.githubusercontent.com/90324988/143278088-030fbd83-4102-425b-b2af-5afbfbf69804.png">



2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan
props?

State adalah atribut yang akan dijadikan patokan untuk trigger suatu event.
Props adalah atribut yang bisa dipass.

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam
React? sebutkan alasannya.

Kita sebaiknya menggunakan component agar kita dapat me-reuse UI object

4. Apa perbedaan class component dan functional component?

Class component merupakan code berbasis class.
Functional component merupakan code yang berbasis fungsi. Memungkinkan menggunakan 
state dan fitur React lainnya tanpa perlu menulis sebuah class baru. Functional 
component dilengkapi dengan useState sehingga bisa langsung mengubah atribut state 
dengan cara setStateAttributeName(value).

5. Dalam react, apakah perbedaan component dan element?

Component adalah fungsi atau kelas yang dapat menerima dan mengembalikan input 
berupa element.

Element adalah objek yang tidak dapat diubah atau diterapkan metode terhadapnya.

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

