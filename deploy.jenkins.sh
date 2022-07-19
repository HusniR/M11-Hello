# Optional parameters: DOCKERHUB_USER_ID DOCKERHUB_PASSWORD
sudo docker login  -u $1 -p $2
sudo docker pull ${IMAGE_NAME}
sudo docker network create --subnet=${SUBNET_ADDR_RANGE} mynet
sudo docker run -d --net mynet --ip ${SERVICE_HOST} --name hello ${IMAGE_NAME}
echo Created container hello
