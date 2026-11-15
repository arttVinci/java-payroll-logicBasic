import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.InputMismatchException;

public class GajiKaryawan {
    String golongan;
    int jam_lembur;

    int index_golongan = -1;
    Double total_penghasilan, gaji_lembur, gaji_golongan;

    double[] gaji = {5000000, 6500000, 9500000};
    int[] persenLembur = {30, 32, 34, 36, 38};

    void setGajiGolongan(String golonganInput) {
        if (golonganInput.equalsIgnoreCase("A")) {
            index_golongan = 0;
        } else if (golonganInput.equalsIgnoreCase("B")) {
            index_golongan = 1;
        } else if (golonganInput.equalsIgnoreCase("C")) {
            index_golongan = 2;
        } else {
            index_golongan = -1;
        }

        if (index_golongan != -1) {
            this.gaji_golongan = gaji[index_golongan];
        } else {
            this.gaji_golongan = 0.0;
        }
    }
    
    double getGajiLembur(int jam_lembur, double gaji_pokok) {
        if (jam_lembur <= 0) {
            return 0;
        }

        int persentase = 0;

        if (jam_lembur == 1) {
            persentase = persenLembur[0];
        } else if (jam_lembur == 2) {
            persentase = persenLembur[1];
        } else if (jam_lembur == 3) {
            persentase = persenLembur[2];
        } else if (jam_lembur == 4) {
            persentase = persenLembur[3];
        } else if (jam_lembur >= 5) {
            persentase = persenLembur[4];
        }

        return (persentase / 100.0) * gaji_pokok;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GajiKaryawan karyawan = new GajiKaryawan();

        while (true) {
            System.out.print("Masukkan Golongan (A/B/C): ");
            karyawan.golongan = scan.next();

            karyawan.setGajiGolongan(karyawan.golongan);

            if (karyawan.gaji_golongan > 0) {
                break;
            } else {
                System.out.println("Input salah! Harap masukkan A, B, atau C.");
            }
        }

        while (true) {
            try {
                System.out.print("Masukkan Jam Lembur : ");
                karyawan.jam_lembur = scan.nextInt();

                if (karyawan.jam_lembur < 0) {
                    System.out.println("Input salah! Jam lembur tidak boleh minus.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input salah! Harap masukkan ANGKA.");
                scan.next();
            }
        }

        karyawan.gaji_lembur = karyawan.getGajiLembur(karyawan.jam_lembur, karyawan.gaji_golongan);
        karyawan.total_penghasilan = karyawan.gaji_golongan + karyawan.gaji_lembur;

        Locale locale = Locale.of("id", "ID"); 
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        formatter.setMaximumFractionDigits(0);

        System.out.println("\n--- Rincian Gaji Karyawan ---");
        System.out.println("Golongan         : " + karyawan.golongan.toUpperCase());
        System.out.println("Gaji Pokok       : " + formatter.format(karyawan.gaji_golongan));
        System.out.println("Lama Lembur      : " + karyawan.jam_lembur + " Jam");
        System.out.println("Gaji Lembur      : " + formatter.format(karyawan.gaji_lembur));
        System.out.println("--------------------------------- +");
        System.out.println("Total Penghasilan: " + formatter.format(karyawan.total_penghasilan));

        scan.close();
    }
}
