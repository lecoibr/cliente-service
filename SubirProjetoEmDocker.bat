@ECHO OFF
set ambiente=%1

ECHO --------------------------------------------
ECHO Compilando o Projeto . . .
ECHO --------------------------------------------
call mvn clean install -DskipTests

ECHO --------------------------------------------
ECHO Limpando imagens e containers antigos . . .
ECHO --------------------------------------------
call docker container stop cliente-service && docker container rm -f cliente-service && docker image rm -f cliente-service

ECHO --------------------------------------------
ECHO Criando a imagem do projeto . . .
ECHO --------------------------------------------
call docker image build -t cliente-service .

ECHO --------------------------------------------
ECHO Criando o container a partir da imagem . . .
ECHO --------------------------------------------

IF "%ambiente%"=="" (
call docker container run --name cliente-service  -d -p 80:80 cliente-service
) ELSE (
call docker container run --name cliente-service  -d -p 80:80 cliente-service --spring.profiles.active=%ambiente%
)

ECHO --------------------------------------------
ECHO Sucesso. Acesse http://localhost/swagger-ui.html
ECHO --------------------------------------------