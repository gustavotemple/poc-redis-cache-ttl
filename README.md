# poc-redis-cache-ttl
PoC Redis cache TTL

### Build & Run:
+ `./mvnw clean package dockerfile:build`
+ `docker rm -v poc-redis-cache-ttl_pocrediscachettl_1`
+ `docker rm -v poc-redis-cache-ttl_redis_1`
+ `docker-compose up`

https://stackoverflow.com/questions/51269477/java-spring-redis-set-time-to-live-with-annotation/51308129

https://stackoverflow.com/questions/51054774/how-to-configure-different-ttl-for-each-redis-cache-when-using-cacheable-in-spr
