drop table customer;
drop table HTE_customer;
drop table customer_seq;

select t1_0.id,t1_0.kural_id,t1_0.line1,t1_0.line2 from thirukkural t1_0

SELECT id,thirukkural_id,group_id FROM thirukkural_label_mapping
where thirukkural_id > 1320;

SELECT id,group_id,name_ta,is_primary,name_en,name_ta_en FROM thirukkural_label
WHERE group_id > 100;
SELECT

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

SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where author_id = 1 and thirukkural_id > 1300;

SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where thirukkural_id = 1321;


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

SELECT id,thirukkural_id,author_id,REPLACE(urai,'`', '‘') FROM thirukkural_author_urai
where author_id = 1 and urai like '%`%'

SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where author_id = 1 and urai like '%’%'


SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where author_id = 6 and urai like '%`%'

