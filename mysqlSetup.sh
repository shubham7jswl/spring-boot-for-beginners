#commands to run if you want a msql terminal based client
docker run --name=mysql-container -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
docker exec -it mysql-container mysql -u root -p

#commands to run if you want a msql desktop based client like dbeaver etc.
docker run --name=mysql-container -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:latest
