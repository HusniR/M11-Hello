echo Stopping container hello
sudo docker stop hello
sudo docker rm hello
sudo docker network rm mynet
status=$?
if [ $status -ne 0 ]; then
	echo status=$status
fi
