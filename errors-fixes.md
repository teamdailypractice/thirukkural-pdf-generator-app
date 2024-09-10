# Error fixes

# 1 Error - Running the project

* Problem
```
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
Reason: Failed to determine a suitable driver class
```
* Questions
  * What is the problem?
  * Do I understand the error message?
    * partially?
    * completely?
  * Do I need to google/chat-gpt?
* Solution
  * Configure **application.properties** correctly
  * How?

```properties
# DataSource configuration for SQLite
spring.datasource.url=jdbc:sqlite:file:D:/git/tamilvu-thirukkural/db/dev.sqlite
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect

# Hibernate settings for SQLite
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

# 2 Error - Running the tests

```log
org.springframework.beans.factory.BeanCreationException
Error creating bean with name 'entityManagerFactory' defined in class path resource 
[org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: 
Failed to initialize dependency 'dataSourceScriptDatabaseInitializer' of LoadTimeWeaverAware bean 'entityManagerFactory': 
Error creating bean with name 'dataSourceScriptDatabaseInitializer' 
defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]:
Unsatisfied dependency expressed through method 'dataSourceScriptDatabaseInitializer' parameter 0: Error creating bean with name 'dataSource': 
Failed to replace DataSource with an embedded database for tests. 
If you want an embedded database please put a supported one on the classpath or tune the replace attribute of @AutoConfigureTestDatabase.
```

* Questions
  * What is the problem?
  * Do I read the first error message fully?
  * Do I understand the problem?
    * partially?
    * fully?
  * Do I need to google/chat-gpt?
* Solution
  * Configure an in-memory (embedded) database like H2/Derby/hsqldb
  * How?
  * Add the database driver jar dependency in `pom.xml` file
