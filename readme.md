# What is the need for this project?
* Ultimately, the project can generate Thirukkural in any desired PDF format.
  1. All Freemarker templates are configured in this project.
  1. The templates generate typesetting files.
  1. Typesetting files can be compiled into PDFs.
  1. Typesetting was chosen for programmatic access and granular control over different types of PDFs, especially for generating exercises.
1. All Thirukkural content is read from an SQLite database.

# Setting up java SDK using SDKMan
```bash
curl -s "https://get.sdkman.io" | bash
source "/Users/biden/.sdkman/bin/sdkman-init.sh"
sdk install java 21.0.3-oracle
```
## Build and Run

* Open application.properties and add db.path
   * /Users/biden/git/thirukkural-pdf-generator-app-master/src/main/resources/application.properties
   * /Users/biden/Downloads/thirukkural-admin-ui-app-main/thirukkuralAdmin/dev.sqlite
```bash
sdk use java 21.0.3-oracle
./mvnw spring-boot:run
```
## execute commands

* Check `booksettings.json` file in `data-in\data` directory
* Update the below path correctly: `templateFileAbsolutePath` and `outputFileAbsolutePath`  

* In `shell:>` run the below command. update the path correctly in unix format
`generate-book-type-setting D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/book-settings.json`

## How to get typst

* download typst from here <https://github.com/typst/typst/releases/>
* apple - https://github.com/typst/typst/releases/download/v0.11.1/typst-aarch64-apple-darwin.tar.xz

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
