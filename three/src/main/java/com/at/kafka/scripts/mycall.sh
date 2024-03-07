#!/usr/bin/env bash

host="mac170 mac171 mac172"

CMD=$1
if [ $# -eq 0 ];then
  CMD=jps
fi

for i in $host ; do
  echo -----------查询$i的jps -------------
  ssh $i "source ~/.bashrc && ${CMD}"
done
