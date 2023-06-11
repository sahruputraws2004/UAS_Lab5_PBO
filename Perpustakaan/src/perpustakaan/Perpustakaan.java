/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perpustakaan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author TUF GAMING 15
 */
public class Perpustakaan {

    private List<Anggota> daftarAnggota;
    private List<Buku> daftarBuku;
    private List<BukuDipinjam> daftarBukuDipinjam;

    public Perpustakaan() {
        daftarAnggota = new ArrayList<>();
        daftarBuku = new ArrayList<>();
        daftarBukuDipinjam = new ArrayList<>();
    }

    public void pendaftaranAnggota(String idAnggota, String namaAnggota) {
        Anggota anggota = new Anggota(idAnggota, namaAnggota);
        daftarAnggota.add(anggota);
        System.out.println("Anggota ID " + idAnggota + " dengan nama " + namaAnggota + " berhasil didaftarkan.");
    }

    public void pendaftaranBuku(String kodeBuku, String namaBuku, String pengarang) {
        Buku buku = new BukuImpl(kodeBuku, namaBuku, pengarang);
        daftarBuku.add(buku);
        System.out.println("Buku dengan kode " + kodeBuku + " berhasil didaftarkan.");
    }

    public void daftarAnggota() {
        System.out.println("Daftar Anggota Perpustakaan:");
        for (Anggota anggota : daftarAnggota) {
            System.out.println("ID      : " + anggota.getIdAnggota());
            System.out.println("Nama    : " + anggota.getNamaAnggota());
            System.out.println("------------");
            
        }
    }

    public void daftarBuku() {
        System.out.println("Daftar Buku Perpustakaan:");
        for (Buku buku : daftarBuku) {
            System.out.println("Kode       : " + buku.getKodeBuku());
            System.out.println("Nama       : " + buku.getNamaBuku());
            System.out.println("Pengarang  : " + buku.getPengarang());
            System.out.println("------------");
        }
    }

    public void hapusBuku(String kodeBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getKodeBuku().equals(kodeBuku)) {
                daftarBuku.remove(buku);
                System.out.println("Buku dengan kode " + kodeBuku + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Buku dengan kode " + kodeBuku + " tidak ditemukan.");
    }

    public void peminjamanBuku(String idPeminjam, String namaPeminjam, String kodeBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getKodeBuku().equals(kodeBuku)) {
                BukuDipinjam bukuDipinjam = new BukuDipinjam(
                    buku.getKodeBuku(),
                    buku.getNamaBuku(),
                    buku.getPengarang(),
                    idPeminjam,
                    namaPeminjam
                );
                daftarBukuDipinjam.add(bukuDipinjam);
                daftarBuku.remove(buku);
                System.out.println("Buku dengan kode " + kodeBuku + " berhasil dipinjam oleh " + namaPeminjam);
                return;
            }
        }
        System.out.println("Buku dengan kode " + kodeBuku + " tidak ditemukan.");
    }

    public void daftarBukuDipinjam() {
        System.out.println("Daftar Buku yang Sedang Dipinjam:");
        for (BukuDipinjam bukuDipinjam : daftarBukuDipinjam) {
            System.out.println("ID Peminjam     : " + bukuDipinjam.getIdPeminjam());
            System.out.println("Nama Peminjam   : " + bukuDipinjam.getNamaPeminjam());
            System.out.println("Kode Buku       : " + bukuDipinjam.getKodeBuku());        
            System.out.println("Nama Buku       : " + bukuDipinjam.getNamaBuku());                   
        }
    }

    public void pengembalianBuku(String kodeBuku) {
        for (BukuDipinjam bukuDipinjam : daftarBukuDipinjam) {
            if (bukuDipinjam.getKodeBuku().equals(kodeBuku)) {
                Buku buku = new BukuImpl(
                    bukuDipinjam.getKodeBuku(),
                    bukuDipinjam.getNamaBuku(),
                    bukuDipinjam.getPengarang()
                );
                daftarBuku.add(buku);
                daftarBukuDipinjam.remove(bukuDipinjam);
                System.out.println("Buku dengan kode " + kodeBuku + " berhasil dikembalikan.");
                return;
            }
        }
        System.out.println("Buku dengan kode " + kodeBuku + " tidak ditemukan atau tidak sedang dipinjam.");
    }
    
    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("::: Sistem Informasi Manajemen Perpustakaan :::");
            System.out.println("-----------------------------------------------\n");
            System.out.println("1. Pendaftaran Anggota");
            System.out.println("2. Pendaftaran Buku");
            System.out.println("3. Daftar Anggota");
            System.out.println("4. Daftar Buku");
            System.out.println("5. Hapus Data Buku");
            System.out.println("6. Peminjaman Buku");
            System.out.println("7. Daftar Buku yang Sedang Dipinjam");
            System.out.println("8. Pengembalian Buku");
            System.out.println("9. Keluar\n");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID Anggota: ");
                    String idAnggota = scanner.next();
                    System.out.print("Masukkan Nama Anggota: ");
                    String namaAnggota = scanner.next();
                    perpustakaan.pendaftaranAnggota(idAnggota, namaAnggota);
                    break;
                case 2:
                    System.out.print("Masukkan Kode Buku: ");
                    String kodeBuku = scanner.next();
                    System.out.print("Masukkan Nama Buku: ");
                    String namaBuku = scanner.next();
                    System.out.print("Masukkan Pengarang Buku: ");
                    String pengarang = scanner.next();
                    perpustakaan.pendaftaranBuku(kodeBuku, namaBuku, pengarang);
                    break;
                case 3:
                    perpustakaan.daftarAnggota();
                    break;
                case 4:
                    perpustakaan.daftarBuku();
                    break;
                case 5:
                    System.out.print("Masukkan Kode Buku yang Akan Dihapus: ");
                    String kodeBukuHapus = scanner.next();
                    perpustakaan.hapusBuku(kodeBukuHapus);
                    break;
                case 6:
                    System.out.print("Masukkan ID Peminjam: ");
                    String idPeminjam = scanner.next();
                    System.out.print("Masukkan Nama Peminjam: ");
                    String namaPeminjam = scanner.next();
                    System.out.print("Masukkan Kode Buku yang Dipinjam: ");
                    String kodeBukuPinjam = scanner.next();
                    perpustakaan.peminjamanBuku(idPeminjam, namaPeminjam, kodeBukuPinjam);
                    break;
                case 7:
                    perpustakaan.daftarBukuDipinjam();
                    break;
                case 8:
                    System.out.print("Masukkan Kode Buku yang Dikembalikan: ");
                    String kodeBukuKembali = scanner.next();
                    perpustakaan.pengembalianBuku(kodeBukuKembali);
                    break;
                case 9:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia.");
                    break;
            }
            System.out.println();
        } while (pilihan != 9);

        scanner.close();
    }
    
}
