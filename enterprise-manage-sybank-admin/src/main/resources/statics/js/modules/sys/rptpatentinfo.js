$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptpatentinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'rptPatentId', name: 'rptPatentId', index: 'rpt_patent_id', width: 50, key: true },
			{ label: '信用报告ID', name: 'reportId', index: 'report_id', width: 80 }, 			
			{ label: '专利类型 1：发明专利 2：实用新型专利 3：外观专利', name: 'patentType', index: 'patent_type', width: 80 }, 			
			{ label: '专利数量', name: 'patentNum', index: 'patent_num', width: 80 }			
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
		rptPatentInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptPatentInfo = {};
		},
		update: function (event) {
			var rptPatentId = getSelectedRow();
			if(rptPatentId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(rptPatentId)
		},
		saveOrUpdate: function (event) {
			var url = vm.rptPatentInfo.rptPatentId == null ? "sys/rptpatentinfo/save" : "sys/rptpatentinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptPatentInfo),
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
			var rptPatentIds = getSelectedRows();
			if(rptPatentIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/rptpatentinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(rptPatentIds),
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
		getInfo: function(rptPatentId){
			$.get(baseURL + "sys/rptpatentinfo/info/"+rptPatentId, function(r){
                vm.rptPatentInfo = r.rptPatentInfo;
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