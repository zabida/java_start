#!/usr/bin/env bash
source /etc/profile

PKG=dex-1.0.0.jar
PROJECT_DIR=/opt/project/dex-program/dex
LOG_DIR=/opt/project/dex-program/dex

echo "-----当前jar包------: $PKG"
cd $PROJECT_DIR || exit
echo "------当前目录------: $(pwd)"

MODE=$1
if [ -z "$MODE" ];then
  MODE=start
fi

PID=""
function getPID() {
  PID=$(ps -ef | grep "$1" | grep -v grep |awk '{print $2}')
}

function killPid() {
    if [ -z "$1" ];then
      echo "没有需要关停的进程号"
      return 0
    fi

    if [ ${#1} -lt 3 ];then
      echo "传入筛选条件太短: ${#1}"
      return 2
    fi

    echo "将杀掉$1"
    ps -ef|grep "$1"| grep -v grep |awk '{print $2}'|xargs kill -9
    if [ $? -eq 0 ];then
      echo "进程$1 杀成功"
    else
      echo "进程$1 杀失败"
    fi
}

function getCMD() {
  CMD=$(ps -ef | grep $1 | grep -v grep |awk '{for (i=8;i<=NF;i=i+1) printf " "$i;print ""}')
  echo "$1相关运行命令: $CMD"
}

function startServ() {
  nohup java -jar $PROJECT_DIR/$PKG -Xms4096m -Xmx4096m --spring.profiles.active=uat2 >nohup.out 2>&1  &
  sleep 1
  getPID "$PKG"
  if [ -n "$PID" ];then
    echo "启动成功， pid: $PID"
  else
    echo "启动失败"
  fi
}

# 检查是否已有进程在运行
getPID $PKG
# 开始
case $MODE in
  "start")
     if [ -n "$PID" ]; then
       echo "已有程序在运行: --> $PID"
       getCMD $PKG
       exit 1;
     fi
     startServ
    ;;
  "restart")
    if [ -n "$PID" ];then
       echo "有程序在运行: $PID"
       killPid $PID
       sleep 1
    fi
    startServ
    ;;
  "stop")
    if [ -n "$PID" ]; then
      killPid $PID
      echo "关停完成"
    else
      echo "无进程关停"
    fi
    ;;
  *|help|h)
    echo "start|restart|stop  -> eg: ./issuse.sh restart"
    ;;
esac


