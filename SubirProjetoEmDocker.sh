#!/bin/sh


echo "--------------------------------------------"
echo "Compilando o Projeto . . ."
echo "--------------------------------------------"
mvn clean install -DskipTests


echo "--------------------------------------------"
echo "Limpando imagens e containers antigos . . ."
echo "--------------------------------------------"
docker container stop cliente-service && docker container rm -f cliente-service && docker image rm -f cliente-service


echo "--------------------------------------------"
echo "Criando a imagem do projeto . . ."
echo "--------------------------------------------"
docker image build -t cliente-service .


echo "--------------------------------------------"
echo "Criando o container a partir da imagem . . ."
echo "--------------------------------------------"

if [[ $1 == '' ]]
then
  docker container run --name cliente-service  -d -p 80:80 cliente-service
else
  docker container run --name cliente-service  -d -p 80:80 cliente-service --spring.profiles.active=$1
fi

echo "--------------------------------------------"
echo "Acesse http://localhost/swagger-ui.html"
echo "--------------------------------------------"
