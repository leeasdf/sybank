#!/bin/bash
prjSrc=${WORKSPACE}
prjPub=/data/webapp
prjPubName=enterprise-manage-sybank-admin
prjName=enterprise-manage-sybank-admin
switchFile=/data/webapp/start.sh

cd ${prjSrc}
mvn clean package -Dmaven.test.skip=true

cd ${prjSrc}/${prjName}/target

scp ${prjPubName}.jar root@172.19.160.66:${prjPub}/${prjPubName}/
ssh root@172.19.160.66 <<remote
cd ${prjPub}
sh ${switchFile} start