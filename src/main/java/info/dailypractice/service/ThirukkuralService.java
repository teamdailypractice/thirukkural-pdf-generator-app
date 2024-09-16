package info.dailypractice.service;

import info.dailypractice.dao.ThirukkuralRepository;
import info.dailypractice.dao.ThirukkuralRepositoryCustom;
import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.Thirukkural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirukkuralService {
    @Autowired
    private ThirukkuralRepository thirukkuralRepository;

    @Autowired
    private ThirukkuralRepositoryCustom thirukkuralRepositoryCustom;

    public void save(Thirukkural thirukkural) {

        Thirukkural saved = this.thirukkuralRepository.save(thirukkural);

    }

    public List<Thirukkural> findAll() {
        return (List<Thirukkural>) this.thirukkuralRepository.findAll();

    }
    //getAllThirukkuralWithLabel
    public List<ThirukkuralLabelDto> getAllThirukkuralWithLabel(int authorId) {
        return (List<ThirukkuralLabelDto>) this.thirukkuralRepositoryCustom.getThirukkuralLabelMapping(authorId);
    }
}

