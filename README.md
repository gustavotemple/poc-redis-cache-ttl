# PoC Redis cache TTL
Multi `RedisCacheManager` approach, better alternative than the `spring.cache.redis.time-to-live` configuration.

### Build & Run:
+ `docker rm -v <OLD_CONTAINERS>`
+ `./mvnw clean package dockerfile:build`
+ `docker-compose up`

### References:

https://stackoverflow.com/questions/51269477/java-spring-redis-set-time-to-live-with-annotation/51308129

https://stackoverflow.com/questions/51054774/how-to-configure-different-ttl-for-each-redis-cache-when-using-cacheable-in-spr
