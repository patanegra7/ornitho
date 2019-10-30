# ornitho-server

## Development MongoDB

[MongoDB Docker image](https://hub.docker.com/_/mongo/)

Instructions:

sudo docker pull mongo
sudo docker run -p 27017:27017 -v /home/projects/ornitho/etc/data:/data/db --name ornithongo-dev -d mongo

Notas:

Clasificación de las aves:

Reino				M						Animal
subreino									
fílum				M						Vertebrados
subfílum
clase				M						Aves
subclase
superorden
orden				M						Paseriformes
suborden									Passeres
superfamilia
familia				M						Paseridos / Passeridae
subfamilia
tribu
genero				m						Passer (se escribe en mayúsuculas)
subgenero			m
superespecie
especie				m						domesticus
subespecie			m

M: se escribe en mayúsuculas
m: se escribe en minúsculas

En la app sólo consideraremos orden-familia-genero-especie-subespecie