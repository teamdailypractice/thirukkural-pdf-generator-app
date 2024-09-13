-- Select only Kural
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
ORDER by a.kural_id;


-- Select kural and urai

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
            AND e.id = 1
            ORDER by a.kural_id;