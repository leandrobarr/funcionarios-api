# funcionarios-api

API para gerenciar os dados dos Funcionários. É possível fazer a inclusão, alteração, consulta, listagem e exclusão de clientes. Neste projeto mostraremos como armazenar arquivos no MySQL.

## Pré-requisitos

1. Java
2. Maven
3. IDE [Intellij](https://www.jetbrains.com/pt-br/idea/) ou [Eclipse](https://https://www.eclipse.org/downloads/)
4. [Mysql](https://www.mysql.com/)
5. [Postman](https://www.postman.com/)

## Configurar banco de dados MySQL

Utilizamos o Docker para executar o MySQL neste exemplo. 
Para aprender mais sobre Docker assista a nossa playlist sobre [Docker](https://www.docker.com/)

Acesse a pasta docker e execute o comando:

```
docker-compose up
```
Se não quiser utilizar o Docker você precisa ter o MySQL instalado no seu computador e precisará criar um banco de dados com o nome `funcionariodb`. Atualize o usuário e senha no arquivo `application.properties` para os dados do seu banco de dados
```
spring.datasource.username=root
spring.datasource.password=root
```
## Iniciar a aplicação
Existem algumas formas de iniciar esta API
```
java -jar target/funcionarios.jar
```
ou utilizando o maven
```
mvn spring-boot:run
```
