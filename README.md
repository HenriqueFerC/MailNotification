Microsserviço enviador de e-mails.

Tecnologias utilizadas nesse projeto: Spring Boot, Gradle, Docker, Apache Kafka, Java Mail Sender

Link do projeto que consome esse microsserviço: https://github.com/HenriqueFerC/MailNotification

Requisitos e orientações para rodar a aplicação: Ter em sua máquina o Docker instalado. Clone o repositório em uma pasta com `git clone https://github.com/HenriqueFerC/MailNotification`. Configure o application.properties de acordo com o passo a passo abaixo. Abra o terminal e rode : "docker-compose up --build". Após isso, o projeto estará rodando na sua máquina na porta 8081.

applcation.properties:

```
spring.application.name=MailNotification

email.host=
email.sender.name=PicPaySimplified

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=
spring.mail.password=
spring.mail.protocol=smtp
spring.mail.properties.sockets.port=456
spring.mail.properties.sockets.class=javax.net.ssl.SSLSocketFactory
spring.mail.properties.sockets.fallback=false
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.timeout=3000
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
thymeleaf.enabled=true

server.port=8081
```
