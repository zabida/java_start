From circleci/jdk8:0.1.1

# 声明个命令行参数变量，下面可以使用这个变量。这个变量值可以在docker build的时候通过  --build-arg user=wuze 传入
ARG port

# 设置为环境变量就可以在命令行使用了
ENV PORT=${port}

# 运行下
RUN echo date;sleep 1;echo $PORT

# ENV 可以设置环境变量
ENV project=dex

# 设置工作目录，后面的copy如果使用相对路径的话，就是相对这个工作目录。exec进入后默认进入workdir
WORKDIR /opt/project/${project}/

# 将当前目录下的所有文件拷贝到容器的workdir。拷贝多个文件的时候，容器中的路径得是带/的
COPY * ./

# 指定卷，当容器启动时，没有指定与宿主机绑定的卷的话，这里会在宿主机默认生成一个卷组绑定（/var/lib/docker/valoums/随机uuid），这样可以防止容器挂掉时数据丢失。
VOLUME /opt/project/${project}/log

# 声明暴露的端口，仅声明作用
EXPOSE ${port}

# 容器启动时的命令
CMD java -jar dex-1.0.0.jar --spring.profiles.active=dev --server.port=${PORT}