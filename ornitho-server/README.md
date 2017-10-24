# ornitho-server

## Development MongoDB

[MongoDB Docker image](https://hub.docker.com/_/mongo/)

Instructions:

sudo docker pull mongo
sudo docker run -p 27017:27017 -v /home/projects/ornitho/etc/data:/data/db --name ornithongo-dev -d mongo

