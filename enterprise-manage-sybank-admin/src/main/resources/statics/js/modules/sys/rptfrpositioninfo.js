$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptfrpositioninfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会员ID', name: 'memId', index: 'mem_id', width: 80 }, 			
			{ label: '企业ID', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '法定代表人姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '企业(机构)名称', name: 'entname', index: 'entname', width: 80 }, 			
			{ label: '注册号', name: 'regno', index: 'regno', width: 80 }, 			
			{ label: '企业(机构)类型', name: 'enttype', index: 'enttype', width: 80 }, 			
			{ label: '', name: 'regcap', index: 'regcap', width: 80 }, 			
			{ label: '注册资本币种', name: 'regcapcur', index: 'regcapcur', width: 80 }, 			
			{ label: '企业状态', name: 'entstatus', index: 'entstatus', width: 80 }, 			
			{ label: '注销日期', name: 'candate', index: 'candate', width: 80 }, 			
			{ label: '吊销日期', name: 'revdate', index: 'revdate', width: 80 }, 			
			{ label: '登记机关', name: 'regorg', index: 'regorg', width: 80 }, 			
			{ label: '职务', name: 'position', index: 'position', width: 80 }, 			
			{ label: '是否法定代表人', name: 'lerepsign', index: 'lerepsign', width: 80 }, 			
			{ label: '开业日期', name: 'esdate', index: 'esdate', width: 80 }, 			
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
		rptFrpositionInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptFrpositionInfo = {};
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
			var url = vm.rptFrpositionInfo.id == null ? "sys/rptfrpositioninfo/save" : "sys/rptfrpositioninfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptFrpositionInfo),
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
				    url: baseURL + "sys/rptfrpositioninfo/delete",
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
			$.get(baseURL + "sys/rptfrpositioninfo/info/"+id, function(r){
                vm.rptFrpositionInfo = r.rptFrpositionInfo;
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