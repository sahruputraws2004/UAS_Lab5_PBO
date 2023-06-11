/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

/**
 *
 * @author TUF GAMING 15
 */
public class BukuDipinjam extends Buku {
    private String idPeminjam;
    private String namaPeminjam;

    public BukuDipinjam(String kodeBuku, String namaBuku, String pengarang, String idPeminjam, String namaPeminjam) {
        super(kodeBuku, namaBuku, pengarang);
        this.idPeminjam = idPeminjam;
        this.namaPeminjam = namaPeminjam;
    }

    public String getIdPeminjam() {
        return idPeminjam;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }
}
