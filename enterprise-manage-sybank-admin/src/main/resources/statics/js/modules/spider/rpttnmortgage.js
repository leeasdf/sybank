$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'spider/rpttnmortgage/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '', name: 'equityAmount', index: 'equity_amount', width: 80 }, 			
			{ label: '', name: 'putDate', index: 'put_date', width: 80 }, 			
			{ label: '', name: 'pledgorStr', index: 'pledgor_str', width: 80 }, 			
			{ label: '', name: 'regDate', index: 'reg_date', width: 80 }, 			
			{ label: '', name: 'state', index: 'state', width: 80 }, 			
			{ label: '', name: 'certifNumber', index: 'certif_number', width: 80 }, 			
			{ label: '', name: 'regNumber', index: 'reg_number', width: 80 }, 			
			{ label: '', name: 'pledgee', index: 'pledgee', width: 80 }, 			
			{ label: '', name: 'companyList', index: 'company_list', width: 80 }, 			
			{ label: '', name: 'pledgeeList', index: 'pledgee_list', width: 80 }, 			
			{ label: '', name: 'pledgorList', index: 'pledgor_list', width: 80 }, 			
			{ label: '', name: 'base', index: 'base', width: 80 }, 			
			{ label: '', name: 'pledgor', index: 'pledgor', width: 80 }, 			
			{ label: '', name: 'certifNumberR', index: 'certif_number_r', width: 80 }, 			
			{ label: '', name: 'pledgeeStr', index: 'pledgee_str', width: 80 }, 			
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
		rptTnMortgage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnMortgage = {};
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
			var url = vm.rptTnMortgage.id == null ? "spider/rpttnmortgage/save" : "spider/rpttnmortgage/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnMortgage),
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
				    url: baseURL + "spider/rpttnmortgage/delete",
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
			$.get(baseURL + "spider/rpttnmortgage/info/"+id, function(r){
                vm.rptTnMortgage = r.rptTnMortgage;
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