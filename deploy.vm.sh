sudo docker network create --subnet=${SUBNET_ADDR_RANGE} mynet
sudo docker run -d --net mynet --ip ${SERVICE_HOST} --name hello ${IMAGE_NAME}
