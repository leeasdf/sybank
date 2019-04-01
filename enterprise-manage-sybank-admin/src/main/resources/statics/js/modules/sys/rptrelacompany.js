$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptrelacompany/list',
        datatype: "json",
        colModel: [			
			{ label: 'relaCompanyId', name: 'relaCompanyId', index: 'rela_company_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '关联企业名称', name: 'companyName', index: 'company_name', width: 80 }, 			
			{ label: '全资子公司,控投子公司;股东公司,同一法人代表公司;母公司', name: 'relaType', index: 'rela_type', width: 80 }			
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
		rptRelaCompany: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptRelaCompany = {};
		},
		update: function (event) {
			var relaCompanyId = getSelectedRow();
			if(relaCompanyId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(relaCompanyId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptRelaCompany.relaCompanyId == null ? "sys/rptrelacompany/save" : "sys/rptrelacompany/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptRelaCompany),
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
			var relaCompanyIds = getSelectedRows();
			if(relaCompanyIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptrelacompany/delete",
                    contentType: "application/json",
				    data: JSON.stringify(relaCompanyIds),
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
		getInfo: function(relaCompanyId){
			$.get(baseURL + "sys/rptrelacompany/info/"+relaCompanyId, function(r){
                vm.rptRelaCompany = r.rptRelaCompany;
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