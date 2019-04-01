#!/bin/bash
# su - db2inst1
# db2 connect to mydb2 user db2inst1 using abc123
# db2 set current schema SYBANK_ENT_MANAGE
# for file in `ls -a /home/sql_import/sql_import_test | grep '.sql'`; do
# echo $file
su - db2inst1 -c "db2 connect to mydb2 user db2inst1 using abc123; db2 set current schema SYBANK_ENT_MANAGE; db2 -tvf /home/db2inst1/sybank_ent_manage/02_导入数据/$file -z /home/db2inst1/sybank_ent_manage/log/$file.log"
# done