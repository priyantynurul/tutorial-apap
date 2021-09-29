package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService{

    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public void updateBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public List<BioskopModel> getBioskopList() { return bioskopDB.findAll(Sort.by(Sort.Direction.ASC, "namaBioskop")); }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {
            bioskopDB.delete(bioskop);
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }

    @Override
    public boolean isOpen(BioskopModel bioskop) {
        LocalTime time = LocalTime.now();
        if(time.isAfter(bioskop.getWaktuBuka()) && time.isBefore(bioskop.getWaktuTutup())){return true;}
        else{return false;}
    }

    @Override
    public boolean isDijaga(BioskopModel bioskop) {
        if(bioskop.getListPenjaga().isEmpty()){return false;}
        else{return true;}
    }
}
