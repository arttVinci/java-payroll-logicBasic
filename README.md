# Program Perhitungan Gaji Karyawan

Program berbasis konsol (CLI) sederhana menggunakan bahasa pemrograman Java untuk menghitung rincian gaji karyawan, mencakup gaji pokok berdasarkan golongan, perhitungan bonus lembur, serta total penghasilan yang diformat dalam mata uang Rupiah (IDR).

## Deskripsi Singkat

Program ini meminta pengguna memasukkan golongan karyawan serta jumlah jam lembur. Berdasarkan masukan tersebut, sistem akan menentukan gaji pokok, menghitung persentase lembur terhadap gaji pokok, menjumlahkan total penghasilan, dan menampilkan rincian pembayaran ke layar.

## Ketentuan dan Logika Perhitungan

### 1. Golongan dan Gaji Pokok

Gaji pokok ditentukan oleh golongan karyawan:

| Golongan | Gaji Pokok |
| --- | --- |
| A | Rp 5.000.000 |
| B | Rp 6.500.000 |
| C | Rp 9.500.000 |

Input golongan bersifat *case-insensitive* (dapat menggunakan huruf kecil maupun huruf besar).

### 2. Tarif Lembur

Penghitungan gaji lembur menggunakan persentase dari gaji pokok berdasarkan durasi jam lembur:

| Lama Lembur | Persentase dari Gaji Pokok |
| --- | --- |
| 1 Jam | 30% |
| 2 Jam | 32% |
| 3 Jam | 34% |
| 4 Jam | 36% |
| >= 5 Jam | 38% |

Catatan: Jika jam lembur bernilai 0 atau kurang, maka gaji lembur bernilai Rp 0.

### 3. Rumus Total Penghasilan

- Gaji Lembur = Persentase Lembur * Gaji Pokok
- Total Penghasilan = Gaji Pokok + Gaji Lembur

## Fitur Utama

1. Validasi Input Golongan:
   Pengguna wajib memasukkan pilihan yang valid (A, B, atau C). Jika input salah, program akan mengulang permintaan input hingga benar.

2. Validasi Input Jam Lembur:
   Menggunakan penanganan eksepsi `InputMismatchException` untuk mencegah program crash saat pengguna memasukkan tipe data non-angka. Selain itu, terdapat validasi agar nilai jam lembur tidak bernilai negatif.

3. Format Mata Uang Otomatis:
   Hasil perhitungan ditampilkan dalam format mata uang Rupiah Indonesia (Rp) tanpa desimal pecahan menggunakan kelas bawaan Java `Locale` dan `NumberFormat`.

## Struktur Kode

File: `GajiKaryawan.java`

- Atribut:
  - `golongan`: Menyimpan teks golongan yang diinput pengguna.
  - `jam_lembur`: Menyimpan durasi lembur dalam satuan jam.
  - `index_golongan`: Penanda indeks array untuk menentukan besaran gaji pokok.
  - `gaji_golongan`: Menyimpan nominal gaji pokok sesuai golongan.
  - `gaji_lembur`: Menyimpan hasil perhitungan nominal lembur.
  - `total_penghasilan`: Menyimpan total keseluruhan gaji pokok ditambah lembur.
  - `listGajiPokok`: Array berisi daftar besaran gaji pokok `{5000000, 6500000, 9500000}`.
  - `listPersenLembur`: Array berisi daftar persentase pengali lembur `{0.30, 0.32, 0.34, 0.36, 0.38}`.

- Metode:
  - `void setGajiGolongan(String golonganInput)`:
    Mencocokkan input golongan (A, B, C) untuk menentukan nilai `index_golongan` dan menetapkan nilai `gaji_golongan`.
  - `double getGajiLembur(int jam_lembur, double gaji_pokok)`:
    Menghitung besaran rupiah gaji lembur berdasarkan parameter jam lembur dan gaji pokok.
  - `public static void main(String[] args)`:
    Titik masuk utama eksekusi program. Menangani alur pembacaan input dari pengguna, pemanggilan fungsi kalkulasi, pemformatan rupiah, serta pencetakan slip gaji ke layar terminal.

## Persyaratan Sistem

- Java Development Kit (JDK) versi 19 atau lebih baru (karena menggunakan method factory `Locale.of("id")`).

## Cara Menjalankan Program

1. Buka terminal atau Command Prompt pada direktori proyek:
   ```bash
   cd path/ke/java-payroll-logicBasic
   ```

2. Kompilasi program:
   ```bash
   javac GajiKaryawan.java
   ```

3. Jalankan program hasil kompilasi:
   ```bash
   java GajiKaryawan
   ```

## Contoh Interaksi Program

```text
Masukkan Golongan (A/B/C): B
Masukkan Jam Lembur : 3

--- Rincian Gaji Karyawan ---
Golongan         : B
Gaji Pokok       : Rp6.500.000
Lama Lembur      : 3 Jam
Gaji Lembur      : Rp2.210.000
--------------------------------- +
Total Penghasilan: Rp8.710.000
```
