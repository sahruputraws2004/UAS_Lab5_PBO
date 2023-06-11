/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

/**
 *
 * @author TUF GAMING 15
 */
public class Anggota {
    private String idAnggota;
    private String namaAnggota;

    public Anggota(String idAnggota, String namaAnggota) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }
}
