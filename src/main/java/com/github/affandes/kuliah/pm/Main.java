package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Scanner;

public class BrowserHistory {
    private LinkedList<String> history; // Menyimpan history browser

    public BrowserHistory() {
        history = new LinkedList<>(); // Inisialisasi LinkedList
    }

    // Fungsi untuk menampilkan semua history dari yang paling baru
    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
            return;
        }

        System.out.println("History Browser:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
    }

    // Fungsi untuk menambahkan website baru ke dalam daftar history
    public void browse(String website) {
        history.add(website); // Menambahkan website ke history
        System.out.println("Anda telah mengunjungi: " + website);
    }

    // Fungsi untuk kembali ke website sebelumnya dan menghapus history terakhir
    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk dikembalikan.");
            return;
        }

        String lastWebsite = history.removeLast(); // Menghapus website terakhir dari history
        System.out.println("Anda kembali dari: " + lastWebsite);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Browse (Kunjungi Website)");
            System.out.println("2. View History");
            System.out.println("3. Back (Kembali ke Website Sebelumnya)");
            System.out.println("4. Exit");
            System.out.print("Pilih opsi (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL website: ");
                    String website = scanner.nextLine();
                    browserHistory.browse(website);
                    break;
                case 2:
                    browserHistory.view();
                    break;
                case 3:
                    browserHistory.back();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
