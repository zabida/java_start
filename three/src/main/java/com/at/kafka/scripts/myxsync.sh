#!/usr/bin/env bash

FILE=$1
DEFAULT_SYNC_DIR="$HOME/.bashrc $HOME/.bin/ /opt/module"

if [ $# -lt 1 ]; then
  echo 缺少参数
  exit
fi

if [ $1 == "all" ];then
  echo "!!!!!!同步使用默认的文件/文件夹"
  FILE=$DEFAULT_SYNC_DIR
fi

for host in mac170 mac171 mac172
do
  if [ $host == "$HOSTNAME" ];then
    echo "$HOSTNAME"本机跳过
  else
    echo ============$host=========
    for file in $FILE
    do
      if [ -e $file ]
        then
          # 获取父目录
          pdir=$(cd -P "$(dirname $file)" || exit ; pwd)
          # 获取当前文件名
          fname=$(basename "$file")
          echo "--------同步$pdir/$fname -> $pdir/  ----------"
          ssh $host "mkdir -p $pdir"
          rsync -av $pdir/$fname $host:$pdir/
      else
        echo "$file" does not exists!
      fi
    done
  fi
done
