package info.dailypractice.html;

import info.dailypractice.dao.ThirukkuralRepositoryCustom;
import info.dailypractice.entity.ThirukkuralAgaraMudhali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgaraMudhaliService {
    @Autowired
    private ThirukkuralRepositoryCustom thirukkuralRepositoryCustom;


    public AgaraMudhaliService() {
    }

    @Override
    public String toString() {
        return "AgaraMudhaliService{" +
               '}';
    }

    public List<ThirukkuralAgaraMudhali> getAgaraMudhaliItems(int firstKuralId, int lastKuralId, String startingCharacter) {
        return thirukkuralRepositoryCustom.getAgaraMudhaliItems(firstKuralId, lastKuralId, startingCharacter);
    }
}
