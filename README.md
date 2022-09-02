# KSAA APP versi 1.0.0 (public)

Aplikasi **Koperasi Syariah Al - Amin** merupakan tugas proyek Pemrograman Visual Universitas Indraprasta PGRI. Aplikasi ini dibuat dengan menggunakan bahasa pemrograman java dan *MySQL* sebagai tempat penyimpanan datanya (*database*).

## #Fitur

#### Dashboard

#### Master
- Master Pengguna
- Master Investor
- Master Nasabah
- Master Karyawan
- Master Jabatan
- Master Pengajuan
- Master Pembayaran

#### Laporan 
- Laporan Pembayaran
- Laporan Pengajuan Lunas
- Laporan Pengajuan Menunggak

## #Cara Instalasi Aplikasi

- *Install* Apache NetBeans IDE minimal versi 14
- *Clone* atau *download* aplikasi KSAA
```sh
git clone --branch master https://github.com/dwikiherdi02/ksaa.git <direktori aplikasi>
```
- *Import database* KSAA. *file database* ada di folder <root>/db/ksaa_final.sql
```sh
mysql -h localhost -u [USER] -p [DATABASE NAME] < [FILE DATABASE]
```
- Konfigurasi koneksi ke database di file <root>/src/app/config/DB.java
```sh
package app.config;

public class DB {
    public static final String HOST = "[HOST]";
    public static final int PORT    = [PORT];
    public static final String NAME = "[DATABASE NAME]";
    public static final String USER = "[USER]";
    public static final String PASS = "[PASSWORD]";
}
```
- *Install* semua *plugin* JAR yang ada di folder <root>/library-jar/
- *Install* plugin AbsoluteLaout.jar jika plugin tidak ditemukan. file berada di aplikasi Netbeans, contoh: **C:\Program Files\NetBeans-14\netbeans\java\modules\ext\AbsoluteLayout.jar**
- *Run & Debug* file <root>/src/resources/views/layout/Login.java
- Gunakan user **"DDD"** dan password **"1"** untuk login aplikasi
- Dan fuala aplikasi berhasil di jalankan

## License

**It's Free Software, Hell Yeah!**
