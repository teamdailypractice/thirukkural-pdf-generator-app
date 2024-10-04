package info.dailypractice.dao;

import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.Thirukkural;
import info.dailypractice.entity.ThirukkuralAgaraMudhali;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

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
                            c.name_en,
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

    public List<ThirukkuralLabelDto> getThirukkuralLabelMapping(int authorId, int firstKuralId, int lastKuralId) {
        String sql = """
                SELECT
                            a.kural_id,
                            a.line1,
                            a.line2,
                            b.group_id,
                            c.name_ta,
                            c.name_en,
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
                            AND a.kural_id >= %d
                            AND a.kural_id <= %d
                            AND e.id = %d
                            ORDER by a.kural_id
                """.formatted(firstKuralId, lastKuralId, authorId);

        String finalQuery = sql;
        Query query = entityManager.createNativeQuery(finalQuery, ThirukkuralLabelDto.class);
        List<ThirukkuralLabelDto> resultList = (List<ThirukkuralLabelDto>) query.getResultList();
        return resultList;
    }

    public List<ThirukkuralAgaraMudhali> getAgaraMudhaliItems(int firstKuralId, int lastKuralId, String startingCharacter) {
        String sql = """
                WITH author_1 AS (
                SELECT thirukkural_id, urai as tamil
                FROM thirukkural_author_urai WHERE author_id = 1),
                author_4 AS (
                SELECT thirukkural_id, urai as english
                FROM thirukkural_author_urai WHERE author_id = 4),
                author_5 AS (
                SELECT thirukkural_id, urai as en_explanation
                FROM thirukkural_author_urai WHERE author_id = 5),
                kural as (
                SELECT
                a.id,
                a.kural_id,
                a.line1,
                REPLACE(REPLACE(REPLACE(REPLACE(a.line1,'-',''),'‘',''),',',' '),'’','')
                as cleaned_line1,
                a.line2
                FROM
                thirukkural a
                )
                SELECT
                a.id
                ,a.kural_id
                ,a.line1
                ,a.cleaned_line1
                ,a.line2
                ,c.group_id
                --,c.name_ta AS title_ta,
                ,c.group_id || "_" || REPLACE(c.name_ta, ' ', '_') AS id_title_ta
                --,c.name_en AS title_en,
                ,c.group_id || "_" || REPLACE(c.name_en, ' ', '_') AS id_title_en
                ,d.tamil
                ,e.english
                --,f.en_explanation
                FROM kural a
                LEFT OUTER JOIN thirukkural_label_mapping b
                ON a.kural_id = b.thirukkural_id
                LEFT OUTER JOIN thirukkural_label c
                ON b.group_id = c.group_id
                LEFT OUTER JOIN author_1 d
                ON d.thirukkural_id = a.kural_id
                LEFT OUTER JOIN author_4 e
                ON e.thirukkural_id = a.kural_id
                LEFT OUTER JOIN author_5 f
                ON f.thirukkural_id = a.kural_id
                WHERE c.is_primary = 1
                AND a.kural_id >= %d
                AND a.kural_id <= %d
                and a.cleaned_line1 like %s
                AND c.is_primary = 1
                ORDER by a.cleaned_line1
                """.formatted(firstKuralId, lastKuralId, "'" + startingCharacter + "%'");

//        System.out.println(sql);

        Query query = entityManager.createNativeQuery(sql, ThirukkuralAgaraMudhali.class);
        List<ThirukkuralAgaraMudhali> resultList = (List<ThirukkuralAgaraMudhali>) query.getResultList();
        return resultList;
    }

}
