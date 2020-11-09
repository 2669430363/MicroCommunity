#!/bin/bash
#### debug model prod
#nohup java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar -Dspring.profiles.active=dev target/LogService.jar $1 > log.log 2>&1 &

#### normal prod model
#nohup java -jar -Dspring.profiles.active=prod $1 target/LogService.jar > log.log $1 2>&1 &

#### normal test model
#nohup java -jar -Dspring.profiles.active=test $1 target/LogService.jar > log.log $1 2>&1 &

#### normal dev model
nohup java -jar -Dspring.profiles.active=$1 $2 target/LogService.jar > log.log $1 2>&1 &

tail -100f log.log