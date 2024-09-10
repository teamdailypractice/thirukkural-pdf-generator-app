# Error fixes

# 1

* Problem
```
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
Reason: Failed to determine a suitable driver class
```
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