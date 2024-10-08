# What is the need for this project?

* The project can generate Thirukkural in any desired PDF format
  * Freemarker templates for each of the **author** are configured
  * On running the command, the templates generate **typesetting** files. File extension **.typ**
  * Typesetting files can be compiled into PDFs, using `typst` application
* Why **Typst** for pdf generation?
  * Granular control over different types of PDFs
  * Support for mathematics equation and science formula
  * Declarative, simple to use
  * Just like HTML for web, typst for PDF generation
  * Typst documentation: https://typst.app/docs/
   
* [All Thirukkural content is read from an SQLite database.](https://github.com/teamdailypractice/thirukkural-admin-ui-app/blob/main/thirukkuralAdmin/dev.sqlite)

## Software pre-requisites

* Java 21 or above
* IntelliJ-IDEA community edition 2024 or above

## Setting up java SDK using SDKMan - Linux/Unix/MacOS

```bash
curl -s "https://get.sdkman.io" | bash
source "/Users/biden/.sdkman/bin/sdkman-init.sh"
sdk install java 21.0.3-oracle
```

## Build and Run

* Open `application.properties` in the directory: `src/main/resources` and update the property `spring.datasource.url` to the right path
* It should be in **unix format** - directories separated by **forward slash**, even in windows
* Example - Windows
`spring.datasource.url=jdbc:sqlite:file:D:/git/thirukkural-admin-ui-app/thirukkuralAdmin/dev.sqlite`
* Example - Linux/Unix/MacOS
* `spring.datasource.url=jdbc:sqlite:file:/Users/biden/Downloads/thirukkural-admin-ui-app-main/thirukkuralAdmin/dev.sqlite` 
* Test-path in `bash` 
* `[ -f /path/to/file ] && echo "File exists" || echo "File does not exist"`
* Run the project from `bash` command-line

```bash
sdk use java 21.0.3-oracle
./mvnw spring-boot:run
```

## Execute project specific commands 

* Check `booksettings.json` file in `data-in\data` directory
* Update the below path correctly: `templateFileAbsolutePath` and `outputFileAbsolutePath`. 
* Use **Find and Replace** as there are many places to update
* The path should be in `unix` format even in windows machine
* windows OS example: `"templateFileAbsolutePath": "D:/git/spring-boot-learning/data-jpa-sqlite/data-in/templates/thirukkural/thirukkural-only/book1.ftl"`
* Linux/Unix/MacOS example: `"templateFileAbsolutePath": "/Users/biden/Downloads/thirukkural-pdf-generator-app/data-in/templates/thirukkural/thirukkural-only/book1.ftl"`
* After the path is updated in the file, in `bash` command line - `shell:>`
* Run the below command. update the path correctly in `unix format` even in `windows machine`
* windows OS example: `generate-book-type-setting D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/book-settings.json`
* Linux/Unix/MacOS example: `generate-book-type-setting /Users/biden/Downloads/thirukkural-pdf-generator-app/data-in/data/book-settings.json`
* on successful running of the above command, it produces many `.typ` files in `data-out` directory
* These files can be converted to PDF files

## Final commands to produce output files to data-out directory

* Run the project
* From spring shell in the command `shell:>` run the below commands
* **Note**: Each configuration json file has to checked and updated with the correct absolute path before running any of the below commands
* agaramudhali website pages -  `generate-agara-mudhali-files D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/agara-mudhali-settings.json`
* agaramudhali web site home page - `generate-agara-mudhali-home-page D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/agara-mudhali-home-settings.json`
* Books download listing - `generate-book-home-page D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/book-settings.json`
* Thirukkural Topics listing - `generate-thirukkural-topics-home-page D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/thirukkural-topics-home-settings.json`
* Thirukkural Pdf files generation - `generate-book-type-setting D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/book-settings.json`
* Thirukkural Question Answer generation - `generate-thirukkural-question-answer D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/question-answer-01.json`
* Thirukkural Question Answer generation - `generate-thirukkural-question-answer-home D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/question-answer-home.json D:/git/spring-boot-learning/data-jpa-sqlite/data-in/data/question-answer-01.json`

## How to get typst executable - only needed for pdf generation?

* Download typst from here <https://github.com/typst/typst/releases/>
* MacOS - https://github.com/typst/typst/releases/download/v0.11.1/typst-aarch64-apple-darwin.tar.xz
* Extract typst executable into a directory and  add the directory to `PATH`  variable
* Open a new shell/cmd and run the below commands

```bash
cd data-out
typst compile thirukkural-only.typ  
```
* The above command will produce `thirukkural-only.pdf` file

## Base project - Spring boot

* Clone the project
* `git clone https://github.com/spring-guides/gs-accessing-data-jpa.git`


