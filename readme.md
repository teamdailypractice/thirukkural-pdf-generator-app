# Setting up java SDK using SDKMan
```bash
curl -s "https://get.sdkman.io" | bash
source "/Users/bident/.sdkman/bin/sdkman-init.sh"
sdk install java 21.0.3-oracle
```

# spring-data-jpa with sqlite
* Clone the project
* `git clone https://github.com/spring-guides/gs-accessing-data-jpa.git`
* Run as is
* If any error, note it down and Fix
* Make one change
* Run
* Any error fix
* Commit
* Make next change

## Tasks

* Running the project with sqlite dependency
* Running Tests

## Run commands
* In spring cli, when running commands provide the path in unix format
* Incorrect - windows format
  * `generate-book-type-setting D:\git\spring-boot-learning\data-jpa-sqlite\data-in\data\book-settings.json`
* correct - unix format
  * `generate-book-type-setting D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/book-settings.json`

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
  *  
