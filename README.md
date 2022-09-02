# CLIENTE - SERVICE #


### Pré-requisitos: ###

* Maven
* Java 11
* Banco de dados PostgreSQL

### Compilação: ###

* Na raiz do projeto, executar: `mvn clean install`

### Execução:

>> 1 - <u>Usando o arquivo compilado na pasta "target":</u>

>>> `java -jar cliente-service.jar`

>> 2 - <u>Usando Docker:</u>

>>> Na raiz do projeto, executar os comandos abaixo em sequência:

>>> `mvn clean install`

>>> `docker container stop cliente-service && docker container rm -f cliente-service && docker image rm -f cliente-service`

>>> `docker image build -t cliente-service .`

>>> `docker container run --name cliente-service  -d -p 80:80 cliente-service`

>> 3 - <u>Usando o arquivo SubirProjetoEmDocker.bat (WINDOWS):</u>

>>> Na raiz do projeto, executar: `SubirProjetoEmDocker.bat`

>> 4 - <u>Usando o arquivo SubirProjetoEmDocker.sh (LINUX):</u>

>>> Na raiz do projeto, executar: `./SubirProjetoEmDocker.sh`

### Para visualizar as APIs, acessar o Swagger: ###

* `http://localhost/swagger-ui.html`

ou

* `http://52.22.90.248/swagger-ui.html`

