--author_id = 1
SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where author_id = 1 and urai like '%‘%'

UPDATE thirukkural_author_urai
SET urai = REPLACE(urai, '`','‘')
where author_id = 1 and urai like '%`%'

--author_id = 2
SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where author_id = 2 and urai like '%@@@@@%'


UPDATE thirukkural_author_urai
SET urai = REPLACE(urai, '@@@@@','')
where author_id = 2 and urai like '%@@@@@%'