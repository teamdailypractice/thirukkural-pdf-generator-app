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
WHERE a.kural_id <= 1080
and a.cleaned_line1 like 'ய%'
AND c.is_primary = 1
ORDER by a.cleaned_line1