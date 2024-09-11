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