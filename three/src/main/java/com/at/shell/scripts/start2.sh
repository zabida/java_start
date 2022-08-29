#!/usr/bin/env bash
source /etc/profile
echo '<---------开始执行脚本--------->'

MODE=$1
if [ -z "$MODE" ];then
  MODE=s
fi

case $MODE in
  "s")
   echo $MODE s
   ;;
  "sf")
   echo $MODE sf
   ;;
  "k")
   echo $MODE 杀掉
   ;;
  *)
    echo help
    ;;
esac

if [ "$MODE" == "f" ]; then
  echo "将强制关停进程"
fi

PKG=dex-1.0.0.jar
PROJECT_DIR=/opt/project/dex-program/dex
LOG_DIR=/opt/project/dex-program/dex

echo "-----当前jar包------: $PKG"
cd $PROJECT_DIR || exit
echo "------当前目录------: $(pwd)"


PID=""
function getPID() {
  PID=$(ps -ef | grep $1 | grep -v grep |awk '{print $2}')
}


getPID $PKG
CMD=$(ps -ef | grep $PKG | grep -v grep |awk '{for (i=8;i<=NF;i=i+1) printf " "$i;print ""}')

if [ -n "$PID" ]; then
  echo "--当前jar已有进程号--: $PID"
  echo "------进程命令------:$CMD"
  if [ "$MODE" = "f" ]; then
    echo "关掉进程$PID"
    kill -9 "$PID"
  else
    read -p "要先关停进程$PID吗 [Y/N (default Y)]" YN;
    # if [ -z "$YN" -o "$YN" = "Y" -o "$YN" = "y" ]; then
    if [ -z "$YN" ] || [ "$YN" = "Y" ] || [ "$YN" = "y" ]; then
      echo "关停进程$PID"
      kill -9 "$PID"
    else
      echo "未关停已有程序, 退出脚本"
      exit 1;
    fi
  fi
fi

nohup java -jar $PROJECT_DIR/$PKG -Xms4096m -Xmx4096m --spring.profiles.active=uat2 >nohup.out 2>&1  &
sleep 1

getPID $PKG
echo "发布成功, 进程号: $PID"