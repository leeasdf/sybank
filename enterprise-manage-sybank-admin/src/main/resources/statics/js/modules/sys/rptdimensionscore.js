$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptdimensionscore/list',
        datatype: "json",
        colModel: [			
			{ label: 'dimeScoreId', name: 'dimeScoreId', index: 'dime_score_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '企业ID', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '维度类型  1:背景与资质 2：经营能力  3：成长能力 4：履约能力 5：信用水平  6：公共责任', name: 'dimeType', index: 'dime_type', width: 80 }, 			
			{ label: '维度得分', name: 'dimeScore', index: 'dime_score', width: 80 }, 			
			{ label: '维度平均得分', name: 'dimeAverageScore', index: 'dime_average_score', width: 80 }			
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
		rptDimensionScore: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptDimensionScore = {};
		},
		update: function (event) {
			var dimeScoreId = getSelectedRow();
			if(dimeScoreId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(dimeScoreId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptDimensionScore.dimeScoreId == null ? "sys/rptdimensionscore/save" : "sys/rptdimensionscore/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptDimensionScore),
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
			var dimeScoreIds = getSelectedRows();
			if(dimeScoreIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptdimensionscore/delete",
                    contentType: "application/json",
				    data: JSON.stringify(dimeScoreIds),
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
		getInfo: function(dimeScoreId){
			$.get(baseURL + "sys/rptdimensionscore/info/"+dimeScoreId, function(r){
                vm.rptDimensionScore = r.rptDimensionScore;
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