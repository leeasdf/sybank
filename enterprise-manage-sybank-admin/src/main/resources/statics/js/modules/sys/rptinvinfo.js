$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptinvinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'invInfoId', name: 'invInfoId', index: 'inv_info_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '公司名称', name: 'companyName', index: 'company_name', width: 80 }, 			
			{ label: '认缴出资额', name: 'subAmount', index: 'sub_amount', width: 80 }, 			
			{ label: '实缴出资额', name: 'paidAmount', index: 'paid_amount', width: 80 }, 			
			{ label: '占股比例', name: 'shareRatio', index: 'share_ratio', width: 80 }			
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
		rptInvInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptInvInfo = {};
		},
		update: function (event) {
			var invInfoId = getSelectedRow();
			if(invInfoId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(invInfoId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptInvInfo.invInfoId == null ? "sys/rptinvinfo/save" : "sys/rptinvinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptInvInfo),
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
			var invInfoIds = getSelectedRows();
			if(invInfoIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptinvinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(invInfoIds),
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
		getInfo: function(invInfoId){
			$.get(baseURL + "sys/rptinvinfo/info/"+invInfoId, function(r){
                vm.rptInvInfo = r.rptInvInfo;
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