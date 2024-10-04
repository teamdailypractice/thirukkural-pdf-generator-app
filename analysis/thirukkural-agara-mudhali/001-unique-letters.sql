WITH test AS(
SELECT
a.id || '' as 'id',
a.kural_id || '' as 'id_kural',
REPLACE(a.line1,'‘','') AS line1_without_punctuation,
a.line1,
a.line2
FROM thirukkural a
WHERE kural_id <= 1080)
SELECT distinct line1_without_punctuation from test
order by line1_without_punctuation
