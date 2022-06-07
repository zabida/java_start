#!/usr/bin/env bash

host="mac170 mac171 mac172"
case $1 in
"start") {
  for i in $host ; do
      echo --------zookeeper $i 启动 ---------
      ssh $i "source ~/.bashrc && zkServer.sh start"
  done
};;
"stop") {
  for i in $host ; do
      echo --------zookeeper $i 停止 ---------
      ssh $i "source ~/.bashrc && zkServer.sh stop"
  done
};;
"status") {
  for i in $host ; do
      echo --------zookeeper $i 状态 ---------
      ssh $i "source ~/.bashrc && zkServer.sh status"
  done
};;

esac
