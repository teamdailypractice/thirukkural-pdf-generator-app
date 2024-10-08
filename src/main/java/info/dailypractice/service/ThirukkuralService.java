package info.dailypractice.service;

import info.dailypractice.dao.ThirukkuralRepository;
import info.dailypractice.dao.ThirukkuralRepositoryCustom;
import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.dto.ThirukkuralTopicDto;
import info.dailypractice.entity.Thirukkural;
import info.dailypractice.entity.ThirukkuralAgaraMudhali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //getAllThirukkuralWithLabel
    public List<ThirukkuralLabelDto> getAllThirukkuralWithLabel(int authorId, int firstKuralId, int lastKuralId) {
        return (List<ThirukkuralLabelDto>) this.thirukkuralRepositoryCustom.getThirukkuralLabelMapping(authorId,firstKuralId,lastKuralId);
    }

    //getAllThirukkuralWithLabel
    public List<ThirukkuralAgaraMudhali> getAgaraMudhaliItems(int firstKuralId,  int lastKuralId, String startingCharacter) {
        return (List<ThirukkuralAgaraMudhali>) this.thirukkuralRepositoryCustom.getAgaraMudhaliItems(firstKuralId,lastKuralId,startingCharacter);
    }

    public List<ThirukkuralTopicDto> getThirukkuralTopicNames(int firstTopicId, int lastTopicId) {
        return (List<ThirukkuralTopicDto>) this.thirukkuralRepositoryCustom.getThirukkuralTopicNames(firstTopicId,lastTopicId);
    }

    public List<ThirukkuralAgaraMudhali> getThirukkuralDetails(int firstKuralId, int lastKuralId, Integer[] kuralIds){
//        It needs to be in the same order.
        //It could not be ordered in the SQL
        //Easy is to order here and then return the result
        ArrayList<ThirukkuralAgaraMudhali> orderedItems = new ArrayList<>();
        List<ThirukkuralAgaraMudhali> thirukkuralDetails = this.thirukkuralRepositoryCustom.getThirukkuralDetails(firstKuralId, lastKuralId, kuralIds);
        for (int i = 0; i < kuralIds.length; i++) {
            int kuralIdToBeSearched = kuralIds[i];
            Optional<ThirukkuralAgaraMudhali> optionalThirukkuralAgaraMudhali = thirukkuralDetails
                    .stream()
                    .filter(item -> item.getKural_id() == kuralIdToBeSearched)
                    .findFirst();
            optionalThirukkuralAgaraMudhali.ifPresent(orderedItems::add);
        }
        return orderedItems;
    }
}

