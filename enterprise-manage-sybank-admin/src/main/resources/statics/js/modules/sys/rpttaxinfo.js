$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rpttaxinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会员主键', name: 'memId', index: 'mem_id', width: 80 }, 			
			{ label: '企业ID', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '所属年度', name: 'year', index: 'year', width: 80 }, 			
			{ label: '机构代码', name: 'orgCode', index: 'org_code', width: 80 }, 			
			{ label: '机构代码', name: 'ename', index: 'ename', width: 80 }, 			
			{ label: '营业收入', name: 'operRevenue', index: 'oper_revenue', width: 80 }, 			
			{ label: '主营业务收入', name: 'mainOperRevenue', index: 'main_oper_revenue', width: 80 }, 			
			{ label: '其他业务收入', name: 'otherOperRevenue', index: 'other_oper_revenue', width: 80 }, 			
			{ label: '营业成本', name: 'operCost', index: 'oper_cost', width: 80 }, 			
			{ label: '主营业务成本', name: 'mainOperCost', index: 'main_oper_cost', width: 80 }, 			
			{ label: '其他业务成本', name: 'otherOperCost', index: 'other_oper_cost', width: 80 }, 			
			{ label: '营业税金及附加信息', name: 'busiTaxSurcharges', index: 'busi_tax_surcharges', width: 80 }, 			
			{ label: '管理费用', name: 'adminExpense', index: 'admin_expense', width: 80 }, 			
			{ label: '销售费用', name: 'operExpense', index: 'oper_expense', width: 80 }, 			
			{ label: '财务费用', name: 'financeExpense', index: 'finance_expense', width: 80 }, 			
			{ label: '财产减值损失', name: 'assetsLoss', index: 'assets_loss', width: 80 }, 			
			{ label: '营业利润', name: 'operProfit', index: 'oper_profit', width: 80 }, 			
			{ label: '营业外收入', name: 'nonBusiIncome', index: 'non_busi_income', width: 80 }, 			
			{ label: '营业外支出', name: 'nonBusiExpense', index: 'non_busi_expense', width: 80 }, 			
			{ label: '利润（亏损）总额', name: 'totalProfitLoss', index: 'total_profit_loss', width: 80 }, 			
			{ label: '所得税', name: 'persIncomeTax', index: 'pers_income_tax', width: 80 }, 			
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
		rptTaxInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptTaxInfo = {};
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
			var url = vm.rptTaxInfo.id == null ? "sys/rpttaxinfo/save" : "sys/rpttaxinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptTaxInfo),
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
				    url: baseURL + "sys/rpttaxinfo/delete",
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
			$.get(baseURL + "sys/rpttaxinfo/info/"+id, function(r){
                vm.rptTaxInfo = r.rptTaxInfo;
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