# Updates done in Thirukkural DB after extraction

## Update 1 - replace backticks

* Find
```sql
SELECT id,thirukkural_id,author_id,urai FROM thirukkural_author_urai
where author_id = 1 and urai like '%`%'
```
* Update
```sql
UPDATE thirukkural_author_urai 
SET urai = REPLACE(urai, '`','‘')
where author_id = 1 and urai like '%`%'
```
* Run and verify
* 