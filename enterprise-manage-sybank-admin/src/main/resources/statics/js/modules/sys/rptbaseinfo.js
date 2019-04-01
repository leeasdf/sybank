$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/rptbaseinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会员ID', name: 'memId', index: 'mem_id', width: 80 }, 			
			{ label: '企业ID', name: 'enterpriseId', index: 'enterprise_id', width: 80 }, 			
			{ label: '企业名称', name: 'entname', index: 'entname', width: 80 }, 			
			{ label: '注册号', name: 'regno', index: 'regno', width: 80 }, 			
			{ label: '原注册号', name: 'oriregno', index: 'oriregno', width: 80 }, 			
			{ label: '法定代表人姓名', name: 'frname', index: 'frname', width: 80 }, 			
			{ label: '', name: 'regcap', index: 'regcap', width: 80 }, 			
			{ label: '', name: 'reccap', index: 'reccap', width: 80 }, 			
			{ label: '币种', name: 'regcapcur', index: 'regcapcur', width: 80 }, 			
			{ label: '经营状态', name: 'entstatus', index: 'entstatus', width: 80 }, 			
			{ label: '企业(机构)类型', name: 'enttype', index: 'enttype', width: 80 }, 			
			{ label: '开业日期', name: 'esdate', index: 'esdate', width: 80 }, 			
			{ label: '经营期限自', name: 'opfrom', index: 'opfrom', width: 80 }, 			
			{ label: '经营期限至', name: 'opto', index: 'opto', width: 80 }, 			
			{ label: '住址', name: 'dom', index: 'dom', width: 80 }, 			
			{ label: '登记机关', name: 'regorg', index: 'regorg', width: 80 }, 			
			{ label: '', name: 'abuitem', index: 'abuitem', width: 80 }, 			
			{ label: '', name: 'cbuitem', index: 'cbuitem', width: 80 }, 			
			{ label: '', name: 'opscope', index: 'opscope', width: 80 }, 			
			{ label: '', name: 'opscoandform', index: 'opscoandform', width: 80 }, 			
			{ label: '最后年检年度', name: 'ancheyear', index: 'ancheyear', width: 80 }, 			
			{ label: '变更日期', name: 'changedate', index: 'changedate', width: 80 }, 			
			{ label: '注销日期', name: 'candate', index: 'candate', width: 80 }, 			
			{ label: '吊销日期', name: 'revdate', index: 'revdate', width: 80 }, 			
			{ label: '最后年检日期', name: 'anchedate', index: 'anchedate', width: 80 }, 			
			{ label: '行业门类代码', name: 'industryphycode', index: 'industryphycode', width: 80 }, 			
			{ label: '行业门类名称', name: 'industryphyname', index: 'industryphyname', width: 80 }, 			
			{ label: '国民经济行业代码', name: 'industrycocode', index: 'industrycocode', width: 80 }, 			
			{ label: '国民经济行业名称', name: 'industryconame', index: 'industryconame', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }			
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
		rptBaseInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.rptBaseInfo = {};
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
			var url = vm.rptBaseInfo.id == null ? "sys/rptbaseinfo/save" : "sys/rptbaseinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.rptBaseInfo),
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
				    url: baseURL + "sys/rptbaseinfo/delete",
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
			$.get(baseURL + "sys/rptbaseinfo/info/"+id, function(r){
                vm.rptBaseInfo = r.rptBaseInfo;
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