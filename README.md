# O TEMPO - SERVICE #


### Pré-requisitos: ###

* Maven
* Java 11
* Banco de dados PostgreSQL

### Compilação: ###

* Na raiz do projeto, executar: `mvn clean install`

### Execução:

>> 1 - <u>Usando o código fonte:</u> 

>>> Na raiz do projeto, executar: `mvn spring-boot:run`

>> 2 - <u>Usando o arquivo compilado:</u>

>>> `java -jar cliente-service.jar`

>> 3 - <u>Usando Docker:</u>

>>> Na raiz do projeto, executar os comandos abaixo em sequência:

>>> `mvn clean install`

>>> `docker container stop cliente-service && docker container rm -f cliente-service && docker image rm -f cliente-service`

>>> `docker image build -t cliente-service .`

>>> `docker container run --name cliente-service  -d -p 80:80 cliente-service`

>> 4 - <u>Usando o arquivo SubirProjetoEmDocker.bat (WINDOWS):</u>

>>> Na raiz do projeto, executar: 

>>> Para ambiente LOCAL: `SubirProjetoEmDocker.bat`

>>> Para ambiente de DESENVOLVIMENTO: `SubirProjetoEmDocker.bat dev`

>>> Para ambiente de HOMOLOGACAO: `SubirProjetoEmDocker.bat hmg`

>>> Para ambiente de PRODUÇÃO: `SubirProjetoEmDocker.bat prod`

>> 5 - <u>Usando o arquivo SubirProjetoEmDocker.sh (LINUX):</u>

>>> Na raiz do projeto, executar: 

>>> Para ambiente LOCAL: `./SubirProjetoEmDocker.sh`

>>> Para ambiente de DESENVOLVIMENTO: `./SubirProjetoEmDocker.sh dev`

>>> Para ambiente de HOMOLOGACAO: `./SubirProjetoEmDocker.sh hmg`

>>> Para ambiente de PRODUÇÃO: `./SubirProjetoEmDocker.sh prod`

### Para visualizar as APIs, acessar o Swagger: ###

* `http://localhost/swagger-ui.html`

