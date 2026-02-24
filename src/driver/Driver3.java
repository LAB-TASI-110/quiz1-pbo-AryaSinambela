// Nama Praktikan:Arya Pratama Sinambela
// NIM Praktikan: 12S24017 

import java.util.ArrayList;
import java.util.Scanner;

// Class untuk menampung data barang secara dinamis
class ItemLaundry {
    String namaBarang;
    int jumlah;

    ItemLaundry(String namaBarang, int jumlah) {
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
    }
}

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ItemLaundry> listBarang = new ArrayList<>();

        System.out.println("=== SYSTEM OPERASIONAL LAUNDRY DEL (VERSION 3.0) ===");
        
        // 1. Data Mahasiswa
        System.out.print("Nama Asrama     : ");
        String asrama = input.nextLine();
        System.out.print("Nama Mahasiswa  : ");
        String nama = input.nextLine();
        System.out.print("NIM             : ");
        String nim = input.nextLine();

        // 2. Input Barang Dinamis
        System.out.println("\n--- Input Barang (Ketik 'selesai' jika sudah semua) ---");
        while (true) {
            System.out.print("Jenis Barang: ");
            String jenis = input.nextLine();
            
            if (jenis.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Jumlah      : ");
            int qty = input.nextInt();
            input.nextLine(); // Clear buffer

            listBarang.add(new ItemLaundry(jenis, qty));
        }

        // 3. Logistik & Catatan
        System.out.print("\nJam Penjemputan : ");
        String jam = input.nextLine();
        System.out.print("Catatan/Pesan   : ");
        String pesan = input.nextLine();
        if (pesan.trim().isEmpty()) pesan = "- - -";

        // 4. Struk Final yang Rapi
        System.out.println("\n========================================");
        System.out.println("          LOG LAUNDRY MAHASISWA         ");
        System.out.println("========================================");
        System.out.println("NIM/Nama    : " + nim + " / " + nama);
        System.out.println("Asrama      : " + asrama);
        System.out.println("----------------------------------------");
        System.out.printf("%-20s | %-10s\n", "ITEM", "QTY");
        System.out.println("----------------------------------------");
        
        for (ItemLaundry item : listBarang) {
            System.out.printf("%-20s | %-10d pcs\n", item.namaBarang, item.jumlah);
        }

        System.out.println("----------------------------------------");
        System.out.println("PENJEMPUTAN : " + jam);
        System.out.println("CATATAN     : " + pesan);
        System.out.println("PEMBAYARAN  : WAJIB BULANAN (LUNAS)");
        System.out.println("========================================");
        
        input.close();
    }
}