# app.service
This app has been created to work with authentication, authorization on java technology using spring-boot 3, spring-security 6 and JWT.

## Steps to run:
1. Generate SSL certificate with keytool. <br>
    Example:<br>
    keytool -genkeypair -alias authalias -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore app.p12 -validity 3650
   
2. Create a security-application.properties file in main/resources folder with the following content:<br>
   spring.datasource.url= [url database]<br>
   spring.datasource.username=[url_database]<br>
   spring.datasource.password=[password database]<br>
   server.ssl.key-store-type=[alg SSL certificate]<br>
   server.ssl.key-store=[SSL certificate's path]<br>
   server.ssl.key-store-password=[SSL certificate's password]<br>
   server.ssl.key-alias=[SSL certificate's alias]<br>
   server.ssl.enabled=true<br>
   server.port=[port's app]<br>
   application.security.jwt.expiration=[expiration time]<br>
   Example:<br>
   spring.datasource.url=jdbc:h2:file:./data/db<br>
   spring.datasource.username=sa<br>
   spring.datasource.password=thisisasecurepassword<br>
   server.ssl.key-store-type=PKCS12<br>
   server.ssl.key-store=classpath:keys/app.p12 #If app.p12 file has saved in main/resources/keys folder<br>
   server.ssl.key-store-password=secureforcertificateinkeytool<br>
   server.ssl.key-alias=authalias<br>
   server.ssl.enabled=true<br>
   server.port=8443<br>
   application.security.jwt.expiration=3600000 #1 Hour<br>
   
3. Create a import.sql file in main/resources folder, with an initial insert sql command for an ADMIN user. <br>
   Example content:<br>
   INSERT INTO _user (user_name, password,role) VALUES ('user1', '$2a$10$L2FKbq2uNDXsD3WQbIvit.GOjvzCr2pa4BnmYaQBHKVPjm9nB9LEo','ADMIN')
