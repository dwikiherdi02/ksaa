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
    
## Tampilan Aplikasi

![Hello World](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEYAAAAUCAAAAAAVAxSkAAABrUlEQVQ4y+3TPUvDQBgH8OdDOGa+oUMgk2MpdHIIgpSUiqC0OKirgxYX8QVFRQRpBRF8KShqLbgIYkUEteCgFVuqUEVxEIkvJFhae3m8S2KbSkcFBw9yHP88+eXucgH8kQZ/jSm4VDaIy9RKCpKac9NKgU4uEJNwhHhK3qvPBVO8rxRWmFXPF+NSM1KVMbwriAMwhDgVcrxeMZm85GR0PhvGJAAmyozJsbsxgNEir4iEjIK0SYqGd8sOR3rJAGN2BCEkOxhxMhpd8Mk0CXtZacxi1hr20mI/rzgnxayoidevcGuHXTC/q6QuYSMt1jC+gBIiMg12v2vb5NlklChiWnhmFZpwvxDGzuUzV8kOg+N8UUvNBp64vy9q3UN7gDXhwWLY2nMC3zRDibfsY7wjEkY79CdMZhrxSqqzxf4ZRPXwzWJirMicDa5KwiPeARygHXKNMQHEy3rMopDR20XNZGbJzUtrwDC/KshlLDWyqdmhxZzCsdYmf2fWZPoxCEDyfIvdtNQH0PRkH6Q51g8rFO3Qzxh2LbItcDCOpmuOsV7ntNaERe3v/lP/zO8yn4N+yNPrekmPAAAAAElFTkSuQmCC)

## License

**It's Free Software, Hell Yeah!**
