#!/bin/bash

cd /home/gaoziqiang/YZYWeiXin
mvn clean package
echo "---mvn clean package　成功!---"
cd /home/gaoziqiang/YZYWeiXin/target
#覆盖掉tomcat/webapps目录下的原war包
scp YZYWeiXin.war root@120.24.50.47:/root/devel/tomcat/tomcat9.0/webapps
echo "---scp成功!---"
echo "---操作完成!---"
#ssh 120.24.50.47 -lroot './deploy.sh'
#'cd devel/tomcat/tomcat9.0/bin'
#'./shutdown.sh'
#'./startup.sh'
#'exit'

