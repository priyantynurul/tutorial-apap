package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface BioskopService {
    //Method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    //Method untuk memperbarui Bioskop
    void updateBioskop(BioskopModel bioskop);

    //Method untuk menghapus penjaga
    void deleteBioskop(BioskopModel bioskop);

    //Method untuk mendapatkan daftar Bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //Method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
    BioskopModel getBioskopByNoBioskop(Long noBioskop);

    //Method untuk mengecek buka/tutup bioskop
    boolean isOpen(BioskopModel bioskop);

    //Method untuk mengecek buka/tutup bioskop
    boolean isDijaga(BioskopModel bioskop);
}
