$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/ulocationinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'locationId', name: 'locationId', index: 'location_id', width: 50, key: true },
			{ label: '名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '转换拼音', name: 'transalteName', index: 'transalte_name', width: 80 }, 			
			{ label: '父级ID', name: 'parentId', index: 'parent_id', width: 80 }, 			
			{ label: '排序', name: 'orderNum', index: 'order_num', width: 80 }, 			
			{ label: '数据状态', name: 'dataStatus', index: 'data_status', width: 80 }, 			
			{ label: '创建人', name: 'creator', index: 'creator', width: 80 }, 			
			{ label: '修改人', name: 'updator', index: 'updator', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }			
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
		uLocationInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.uLocationInfo = {};
		},
		update: function (event) {
			var locationId = getSelectedRow();
			if(locationId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(locationId)
		},
		saveOrUpdate: function (event) {
			var url = vm.uLocationInfo.locationId == null ? "sys/ulocationinfo/save" : "sys/ulocationinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.uLocationInfo),
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
			var locationIds = getSelectedRows();
			if(locationIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/ulocationinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(locationIds),
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
		getInfo: function(locationId){
			$.get(baseURL + "sys/ulocationinfo/info/"+locationId, function(r){
                vm.uLocationInfo = r.uLocationInfo;
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