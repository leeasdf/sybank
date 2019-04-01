$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptfinacebaseinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'financeId', name: 'financeId', index: 'finance_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '时间段  开始时间', name: 'financeMonth', index: 'finance_month', width: 80 }, 			
			{ label: '', name: 'totalAssets', index: 'total_assets', width: 80 }, 			
			{ label: '', name: 'totalLiabilities', index: 'total_liabilities', width: 80 }, 			
			{ label: '', name: 'saleIncome', index: 'sale_income', width: 80 }, 			
			{ label: '', name: 'netProfits', index: 'net_profits', width: 80 }			
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
		rptFinaceBaseInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptFinaceBaseInfo = {};
		},
		update: function (event) {
			var financeId = getSelectedRow();
			if(financeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(financeId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptFinaceBaseInfo.financeId == null ? "sys/rptfinacebaseinfo/save" : "sys/rptfinacebaseinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptFinaceBaseInfo),
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
			var financeIds = getSelectedRows();
			if(financeIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptfinacebaseinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(financeIds),
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
		getInfo: function(financeId){
			$.get(baseURL + "sys/rptfinacebaseinfo/info/"+financeId, function(r){
                vm.rptFinaceBaseInfo = r.rptFinaceBaseInfo;
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