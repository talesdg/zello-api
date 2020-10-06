
## Criar o schema no banco de dados
### Nome do schema: zello
```
CREATE SCHEMA IF NOT EXISTS `zello` DEFAULT CHARACTER SET latin1 ;
USE `zello` ;
```
> Ou se preferir, utilize o arquivo: script.sql
## Importar o projeto
```
Importar o projeto atevéz no maven
```
## Verifique as credenciais do banco no arquivo application.properties
```
server.port=${port:8088

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/zello

spring.datasource.username=root

spring.datasource.password==root

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

> Informe a porta no services do frontend

## Iniciar a aplicação
```
RUN AS Spring Boot App
```
## Inserir os perfis iniciais
```
INSERT INTO `zello`.`perfil` (`nome`) VALUES ('comum');
INSERT INTO `zello`.`perfil` (`nome`) VALUES ('gestor');
INSERT INTO `zello`.`perfil` (`nome`) VALUES ('admin');
```
> Caso queira realizar teste das requisições, foi disponibilizado a collection do Insomnia: Collection_Zello.json