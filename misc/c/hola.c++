docker run -d --name proyecto -p 6379:6379 redis:7 redis-server --requirepass redisdb
docker exec -it proyecto redis-cli