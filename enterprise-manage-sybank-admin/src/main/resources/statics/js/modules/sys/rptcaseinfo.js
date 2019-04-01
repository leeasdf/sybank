$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptcaseinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会员ID', name: 'memid', index: 'memId', width: 80 }, 			
			{ label: '企业ID', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '案发时间', name: 'casetime', index: 'casetime', width: 80 }, 			
			{ label: '案由', name: 'casereason', index: 'casereason', width: 80 }, 			
			{ label: '案值', name: 'caseval', index: 'caseval', width: 80 }, 			
			{ label: '案件类型', name: 'casetype', index: 'casetype', width: 80 }, 			
			{ label: '执行类别', name: 'exesort', index: 'exesort', width: 80 }, 			
			{ label: '案件结果', name: 'caseresult', index: 'caseresult', width: 80 }, 			
			{ label: '处罚决定文书', name: 'pendecno', index: 'pendecno', width: 80 }, 			
			{ label: '处罚决定书签发日期', name: 'pendecissdate', index: 'pendecissdate', width: 80 }, 			
			{ label: '作出行政处罚决定机关名称', name: 'penauth', index: 'penauth', width: 80 }, 			
			{ label: '主要违法事实', name: 'illegfact', index: 'illegfact', width: 80 }, 			
			{ label: '处罚依据', name: 'penbasis', index: 'penbasis', width: 80 }, 			
			{ label: '处罚种类', name: 'pentype', index: 'pentype', width: 80 }, 			
			{ label: '处罚结果', name: 'penresult', index: 'penresult', width: 80 }, 			
			{ label: '处罚金额', name: 'penam', index: 'penam', width: 80 }, 			
			{ label: '处罚执行情况', name: 'penexest', index: 'penexest', width: 80 }, 			
			{ label: '创建人ID', name: 'creator', index: 'creator', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '修改人ID', name: 'updater', index: 'updater', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '数据状态：1-正常 0-删除', name: 'dataState', index: 'data_state', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		rptCaseInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptCaseInfo = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptCaseInfo.id == null ? "sys/rptcaseinfo/save" : "sys/rptcaseinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptCaseInfo),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptcaseinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "sys/rptcaseinfo/info/"+id, function(r){
                vm.rptCaseInfo = r.rptCaseInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});