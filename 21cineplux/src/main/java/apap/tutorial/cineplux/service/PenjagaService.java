package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);

    //Method untuk memperbarui Bioskop
    void updatePenjaga(PenjagaModel penjaga);

    //Method untuk menghapus penjaga
    void deletePenjaga(PenjagaModel penjaga);

    //Method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
}
