// Nama Praktikan:Arya Pratama Sinambela
// NIM Praktikan: 12S24017 

import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Driver1 {
    public static void main(String[] args) {
        // 1. Inisialisasi Database Menu
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("ngs", 15000); // Nasi Goreng Spesial
        menu.put("ap",  20000); // Ayam Penyet
        menu.put("sa",  25000); // Sate Ayam
        menu.put("bu",  18000); // Bakso Urat
        menu.put("map", 15000); // Mie Ayam Pangsit
        menu.put("gg",  15000); // Gado-Gado
        menu.put("sam", 17000); // Soto Ayam
        menu.put("rd",  25000); // Rendang Daging
        menu.put("ib",  35000); // Ikan Bakar
        menu.put("nuk", 20000); // Nasi Uduk Komplit

        // 2. Data Berat Badan
        double beratUcok = 100.0;
        double beratButet = 50.0;
        double totalBerat = beratUcok + beratButet;

        // 3. Input dari User
        Scanner input = new Scanner(System.in);
        System.out.println("=== SISTEM KASIR OTOMATIS BERDASARKAN PROPORSI ===");
        System.out.print("Masukkan kode makanan (contoh: ib, ngs, rd): ");
        String kode = input.nextLine().toLowerCase();

        // 4. Proses Logika
        if (menu.containsKey(kode)) {
            int hargaTotal = menu.get(kode);
            
            // Hitung pembagian bayar berdasarkan rasio tubuh (2:1)
            double bayarUcok = (beratUcok / totalBerat) * hargaTotal;
            double bayarButet = (beratButet / totalBerat) * hargaTotal;

            // Logika Penentuan Kupon
            String warnaKupon = "";
            int persenDiskon = 0;

            if (hargaTotal >= 35000) {
                warnaKupon = "Ungu/Super";
                persenDiskon = 25;
            } else if (hargaTotal >= 30000) {
                warnaKupon = "Hijau";
                persenDiskon = 20;
            } else if (hargaTotal >= 25000) {
                warnaKupon = "Merah";
                persenDiskon = 15;
            } else if (hargaTotal >= 20000) {
                warnaKupon = "Kuning";
                persenDiskon = 10;
            } else {
                warnaKupon = "Biru";
                persenDiskon = 5;
            }

            // 5. Output Struk Pembayaran
            DecimalFormat df = new DecimalFormat("###,###");
            System.out.println("\n--- HASIL PERHITUNGAN ---");
            System.out.println("Total Belanja  : Rp " + df.format(hargaTotal));
            System.out.println("Ucok (100kg)   : Rp " + df.format(bayarUcok));
            System.out.println("Butet (50kg)   : Rp " + df.format(bayarButet));
            System.out.println("-------------------------");
            System.out.println("SELAMAT! Anda mendapatkan:");
            System.out.println("Kupon " + warnaKupon + " (Diskon " + persenDiskon + "%)");
            
        } else {
            System.out.println("Maaf, kode makanan '" + kode + "' tidak terdaftar.");
        }

        input.close();
    }
}