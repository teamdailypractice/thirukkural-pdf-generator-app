package info.dailypractice.service;

import info.dailypractice.dao.ThirukkuralRepository;
import info.dailypractice.entity.Customer;
import info.dailypractice.entity.Thirukkural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirukkuralService {
    @Autowired
    private ThirukkuralRepository thirukkuralRepository;

    public void save(Thirukkural thirukkural) {

        Thirukkural saved = this.thirukkuralRepository.save(thirukkural);

    }

    public List<Thirukkural> findAll() {
        return (List<Thirukkural>) this.thirukkuralRepository.findAll();

    }
}

