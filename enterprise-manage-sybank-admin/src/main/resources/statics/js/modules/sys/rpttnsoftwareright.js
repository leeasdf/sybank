$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rpttnsoftwareright/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '批准日期', name: 'appDate', index: 'app_date', width: 80 }, 			
			{ label: '软件全称', name: 'fullname', index: 'fullname', width: 80 }, 			
			{ label: '软件简称', name: 'simpleName', index: 'simple_name', width: 80 }, 			
			{ label: '登记号', name: 'regnum', index: 'regnum', width: 80 }, 			
			{ label: '分类号', name: 'catnum', index: 'catnum', width: 80 }, 			
			{ label: '版本号', name: 'version', index: 'version', width: 80 }, 			
			{ label: '著作详情信息', name: 'author', index: 'author', width: 80 }, 			
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
		rptTnSoftwareRight: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnSoftwareRight = {};
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
			var url = vm.rptTnSoftwareRight.id == null ? "sys/rpttnsoftwareright/save" : "sys/rpttnsoftwareright/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnSoftwareRight),
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
				    url: baseURL + "sys/rpttnsoftwareright/delete",
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
			$.get(baseURL + "sys/rpttnsoftwareright/info/"+id, function(r){
                vm.rptTnSoftwareRight = r.rptTnSoftwareRight;
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