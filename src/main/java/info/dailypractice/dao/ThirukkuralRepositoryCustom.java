package info.dailypractice.dao;

import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.Thirukkural;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThirukkuralRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ThirukkuralLabelDto> getThirukkuralLabelMapping() {
        String sql = """
                SELECT
                    a.kural_id,
                    a.line1,
                    a.line2,
                    b.group_id,
                    c.name_ta
                    FROM thirukkural a
                    JOIN thirukkural_label_mapping b
                    ON a.kural_id = b.thirukkural_id
                    JOIN thirukkural_label c
                    ON b.group_id = c.group_id
                    AND c.is_primary = 1
                    ORDER by a.kural_id
                """;
        Query query = entityManager.createNativeQuery(sql, ThirukkuralLabelDto.class);
        List<ThirukkuralLabelDto> resultList = query.getResultList();
        return resultList;
    }

}
