docker build -t sen300bookserviceapi:1 .
docker run -d -p 8081:8080 --name SEN300BookServiceAPI --net netSEN300 sen300bookserviceapi:1