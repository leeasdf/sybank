for element in `ls 12106_26_all2`
do
    ` sort -u "./12106_26_all2/"$element"/successNoData_ename_list.txt" > "./12106_26_all2/"$element"/deal.txt"`
done