# Optional parameters: DOCKERHUB_USER_ID DOCKERHUB_PASSWORD

mvn --projects main clean install

if [ -n "$SONAR_TOKEN" ]; then
	mvn sonar:sonar -pl !features \
		-Dsonar.projectKey=DevOpsForAgileCoaches \
		-Dsonar.host.url=$SONAR_URL \
		-Dsonar.login=$SONAR_TOKEN
fi

mkdir -p scratch
cp main/target/*.jar scratch

if [ `uname` = 'Linux' ]; then
	sudo docker build -t $IMAGE_NAME -f Dockerfile scratch
	if [ "$#" -eq 2 ]; then
		sudo docker login -u $1 -p $2
		sudo docker push $IMAGE_NAME
	fi
fi
