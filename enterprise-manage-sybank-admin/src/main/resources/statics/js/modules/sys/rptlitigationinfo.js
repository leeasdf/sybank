$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptlitigationinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会员ID', name: 'memId', index: 'mem_id', width: 80 }, 			
			{ label: '企业ID', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '信息ID', name: 'dataId', index: 'data_id', width: 80 }, 			
			{ label: '类型', name: 'type', index: 'type', width: 80 }, 			
			{ label: '文书类型', name: 'caseType', index: 'case_type', width: 80 }, 			
			{ label: '', name: 'title', index: 'title', width: 80 }, 			
			{ label: '', name: 'body', index: 'body', width: 80 }, 			
			{ label: '时间', name: 'sortTime', index: 'sort_time', width: 80 }, 			
			{ label: '法院名称', name: 'court', index: 'court', width: 80 }, 			
			{ label: '案号', name: 'caseNo', index: 'case_no', width: 80 }, 			
			{ label: '', name: 'party', index: 'party', width: 80 }, 			
			{ label: '案由', name: 'caseCause', index: 'case_cause', width: 80 }, 			
			{ label: '执行状态', name: 'status', index: 'status', width: 80 }, 			
			{ label: '执行标的', name: 'execMoney', index: 'exec_money', width: 80 }, 			
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
		rptLitigationInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptLitigationInfo = {};
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
			var url = vm.rptLitigationInfo.id == null ? "sys/rptlitigationinfo/save" : "sys/rptlitigationinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptLitigationInfo),
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
				    url: baseURL + "sys/rptlitigationinfo/delete",
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
			$.get(baseURL + "sys/rptlitigationinfo/info/"+id, function(r){
                vm.rptLitigationInfo = r.rptLitigationInfo;
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