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


## Update 2: author id: 2 

useless characters: @@@@@@ kural id: 416
Bakctick not closed - kural id : 2

## Errors in pdf template

* Problem - Single quote in line 10559  of typ file
```typ
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  [1318], [தும்முச் செறுப்ப, அழுதாள், ‘நுமர் உள்ளல் \ எம்மை மறைத்திரோ?’ என்று. \ ]
)
[அவளுடைய ஊடலுக்கு அஞ்சி யான் தும்மலை அடக்கிக் கொள்ள \`உம்மவர் உம்மை நினைப்பதை எமக்குத் தெரியாமல் மறைக்கின்றீரோ\` என்று அழுதாள்.]

```
* Issue:  kural - id: 1318 urai_id = 1 Single quoe
* Fix: Update the ``` with `'
* Where to fix? database or in the template?
  
