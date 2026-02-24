// Nama Praktikan:Arya Pratama Sinambela
// NIM Praktikan: 12S24017 

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Input Data Mentah
        System.out.println("Masukkan data mahasiswa (format:[nilai] nama mahasiswa, dst :");
        String dataMentah = input.nextLine();

        // 2. Logika Pemisahan (Parsing) menggunakan Regex
        // Pattern ini mencari angka yang berada di dalam kurung siku []
        Pattern pattern = Pattern.compile("\\[(\\d+)\\]");
        Matcher matcher = pattern.matcher(dataMentah);

        int totalNilai = 0;
        int jumlahData = 0;

        System.out.println("\n--- Hasil Ekstraksi Nilai ---");
        
        // Loop selama ditemukan pola [angka]
        while (matcher.find()) {
            // Mengambil angka dari Group 1 (isi di dalam kurung)
            int nilai = Integer.parseInt(matcher.group(1));
            totalNilai += nilai;
            jumlahData++;
            
            System.out.println("Data ke-" + jumlahData + ": " + nilai);
        }

        // 3. Output Final
        if (jumlahData > 0) {
            System.out.println("-----------------------------");
            System.out.println("Jumlah Mahasiswa (N) : " + jumlahData);
            System.out.println("Total Nilai Kelompok : " + totalNilai);
            System.out.println("Rata-rata            : " + (double) totalNilai / jumlahData);
        } else {
            System.out.println("Format data tidak valid atau data kosong.");
        }

        input.close();
    }
}