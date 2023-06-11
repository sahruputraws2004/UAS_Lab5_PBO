/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

/**
 *
 * @author TUF GAMING 15
 */
abstract class Buku {
    private String kodeBuku;
    private String namaBuku;
    private String pengarang;

    public Buku(String kodeBuku, String namaBuku, String pengarang) {
        this.kodeBuku = kodeBuku;
        this.namaBuku = namaBuku;
        this.pengarang = pengarang;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public String getPengarang() {
        return pengarang;
    }
}
