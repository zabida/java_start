#!/usr/bin/env bash

host="mac170 mac171 mac172"

# kafka 启动时通过指定JMX_PORT变量，来激活JMX监控
case $1 in
"start"){
  for i in $host
  do
    echo " --------启动 $i Kafka-------"
    ssh $i "source ~/.bashrc && JMX_PORT=9999 kafka-server-start.sh -daemon $KAFKA_HOME/config/server.properties"
  done
};;

"stop"){
  for i in $host
  do
    echo " --------停止 $i Kafka-------"
    ssh $i "source ~/.bashrc && kafka-server-stop.sh "
  done
};;
*){
  echo "请传入参数 eg: kaf.sh start|stop"
};;
esac
