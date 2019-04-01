$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'spider/rpttnpurchaseland/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '', name: 'plId', index: 'pl_id', width: 80 }, 			
			{ label: '', name: 'adminRegion', index: 'admin_region', width: 80 }, 			
			{ label: '', name: 'elecSupervisorNo', index: 'elec_supervisor_no', width: 80 }, 			
			{ label: '', name: 'signedDate', index: 'signed_date', width: 80 }, 			
			{ label: '', name: 'totalArea', index: 'total_area', width: 80 }, 			
			{ label: '', name: 'location', index: 'location', width: 80 }, 			
			{ label: '', name: 'assignee', index: 'assignee', width: 80 }, 			
			{ label: '', name: 'parentCompany', index: 'parent_company', width: 80 }, 			
			{ label: '', name: 'purpose', index: 'purpose', width: 80 }, 			
			{ label: '', name: 'supplyWay', index: 'supply_way', width: 80 }, 			
			{ label: '', name: 'minVolume', index: 'min_volume', width: 80 }, 			
			{ label: '', name: 'maxVolume', index: 'max_volume', width: 80 }, 			
			{ label: '', name: 'dealPrice', index: 'deal_price', width: 80 }, 			
			{ label: '', name: 'startTime', index: 'start_time', width: 80 }, 			
			{ label: '', name: 'linkUrl', index: 'link_url', width: 80 }, 			
			{ label: '', name: 'endTime', index: 'end_time', width: 80 }, 			
			{ label: '创建时间', name: 'plCreateTime', index: 'pl_create_time', width: 80 }, 			
			{ label: '修改时间', name: 'plUpdateTime', index: 'pl_update_time', width: 80 }, 			
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
		rptTnPurchaseland: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnPurchaseland = {};
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
			var url = vm.rptTnPurchaseland.id == null ? "spider/rpttnpurchaseland/save" : "spider/rpttnpurchaseland/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnPurchaseland),
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
				    url: baseURL + "spider/rpttnpurchaseland/delete",
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
			$.get(baseURL + "spider/rpttnpurchaseland/info/"+id, function(r){
                vm.rptTnPurchaseland = r.rptTnPurchaseland;
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