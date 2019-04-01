$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptlitigantinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'litigantInfoId', name: 'litigantInfoId', index: 'litigant_info_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '案号', name: 'caseNo', index: 'case_no', width: 80 }, 			
			{ label: '法院名称', name: 'courtName', index: 'court_name', width: 80 }, 			
			{ label: '涉案内容', name: 'litigantContent', index: 'litigant_content', width: 80 }, 			
			{ label: '结案时间', name: 'litigantTime', index: 'litigant_time', width: 80 }			
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
		rptLitigantInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptLitigantInfo = {};
		},
		update: function (event) {
			var litigantInfoId = getSelectedRow();
			if(litigantInfoId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(litigantInfoId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptLitigantInfo.litigantInfoId == null ? "sys/rptlitigantinfo/save" : "sys/rptlitigantinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptLitigantInfo),
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
			var litigantInfoIds = getSelectedRows();
			if(litigantInfoIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptlitigantinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(litigantInfoIds),
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
		getInfo: function(litigantInfoId){
			$.get(baseURL + "sys/rptlitigantinfo/info/"+litigantInfoId, function(r){
                vm.rptLitigantInfo = r.rptLitigantInfo;
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