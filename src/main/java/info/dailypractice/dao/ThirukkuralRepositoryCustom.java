package info.dailypractice.dao;

import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.Thirukkural;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

@Repository
public class ThirukkuralRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ThirukkuralLabelDto> getThirukkuralLabelMapping(int authorId) {
        String sql = """
                SELECT
                            a.kural_id,
                            a.line1,
                            a.line2,
                            b.group_id,
                            c.name_ta,
                            e.name as author_name_1,
                            d.urai as urai_1
                            FROM thirukkural a
                            JOIN thirukkural_label_mapping b
                            ON a.kural_id = b.thirukkural_id
                            JOIN thirukkural_label c
                            ON b.group_id = c.group_id
                            JOIN thirukkural_author_urai d
                            ON d.thirukkural_id = a.kural_id
                            JOIN author e
                            ON d.author_id = e.id
                            WHERE c.is_primary = 1
                            AND e.id = {0}
                            ORDER by a.kural_id
                """;
        String finalQuery = MessageFormat.format(sql, authorId);
        Query query = entityManager.createNativeQuery(finalQuery, ThirukkuralLabelDto.class);
        List<ThirukkuralLabelDto> resultList = query.getResultList();
        return resultList;
    }

}
