#!/usr/bin/env bash

host="mac170 mac171 mac172"

case $1 in
"start"){
  for i in $host
  do
    echo " --------启动 $i Kafka-------"
    ssh $i "source ~/.bashrc && kafka-server-start.sh -daemon $KAFKA_HOME/config/server.properties"
  done
};;

"stop"){
  for i in $host
  do
    echo " --------停止 $i Kafka-------"
    ssh $i "source ~/.bashrc && kafka-server-stop.sh "
  done
};;
esac
