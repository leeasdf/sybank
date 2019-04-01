$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'spider/rpttnimportexport/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业主键', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entName', index: 'ent_name', width: 80 }, 			
			{ label: '行业种类', name: 'industryCategory', index: 'industry_category', width: 80 }, 			
			{ label: '年报情况', name: 'annualReport', index: 'annual_report', width: 80 }, 			
			{ label: '海关注销标识', name: 'status', index: 'status', width: 80 }, 			
			{ label: '行政区划', name: 'administrativeDivision', index: 'administrative_division', width: 80 }, 			
			{ label: '经营类别', name: 'managementCategory', index: 'management_category', width: 80 }, 			
			{ label: '注册海关', name: 'customsRegisteredAddress', index: 'customs_registered_address', width: 80 }, 			
			{ label: '报关有效期', name: 'validityDate', index: 'validity_date', width: 80 }, 			
			{ label: '经济区划', name: 'economicDivision', index: 'economic_division', width: 80 }, 			
			{ label: '注册日期', name: 'recordDate', index: 'record_date', width: 80 }, 			
			{ label: '海关注册号', name: 'crCode', index: 'cr_code', width: 80 }, 			
			{ label: '特殊贸易区域', name: 'specialTradeArea', index: 'special_trade_area', width: 80 }, 			
			{ label: '跨境贸易电子商务类型', name: 'types', index: 'types', width: 80 }, 			
			{ label: '信用登记', name: 'creditRating', index: 'credit_rating', width: 80 }, 			
			{ label: 'sanction', name: 'sanction', index: 'sanction', width: 80 }, 			
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
		rptTnImportExport: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTnImportExport = {};
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
			var url = vm.rptTnImportExport.id == null ? "spider/rpttnimportexport/save" : "spider/rpttnimportexport/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTnImportExport),
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
				    url: baseURL + "spider/rpttnimportexport/delete",
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
			$.get(baseURL + "spider/rpttnimportexport/info/"+id, function(r){
                vm.rptTnImportExport = r.rptTnImportExport;
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