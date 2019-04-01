$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptsaleinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'rptSaleId', name: 'rptSaleId', index: 'rpt_sale_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '公司名称', name: 'saleName', index: 'sale_name', width: 80 }, 			
			{ label: '产品类型', name: 'productType', index: 'product_type', width: 80 }, 			
			{ label: '', name: 'saleAmount', index: 'sale_amount', width: 80 }			
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
		rptSaleInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptSaleInfo = {};
		},
		update: function (event) {
			var rptSaleId = getSelectedRow();
			if(rptSaleId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(rptSaleId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptSaleInfo.rptSaleId == null ? "sys/rptsaleinfo/save" : "sys/rptsaleinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptSaleInfo),
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
			var rptSaleIds = getSelectedRows();
			if(rptSaleIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptsaleinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(rptSaleIds),
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
		getInfo: function(rptSaleId){
			$.get(baseURL + "sys/rptsaleinfo/info/"+rptSaleId, function(r){
                vm.rptSaleInfo = r.rptSaleInfo;
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